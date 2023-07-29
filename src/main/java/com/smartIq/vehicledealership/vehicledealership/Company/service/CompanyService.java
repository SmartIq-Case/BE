package com.smartIq.vehicledealership.vehicledealership.Company.service;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySaveRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanyUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.repository.CompanyRepository;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    /**
     * Bir kullanıcı bu isteği attığında kendisi User konumundan artık bir şirket sahibi konumuna geçer.
     * Rolü Company_Owner olarak güncellenir ve Company ile ilişkilendirilir.
     *
     * @param request
     * @return
     */
    @Transactional
    public Company createCompany(
            CompanySaveRequest request,
            User user) {
        if (companyRepository.existsByTitle(request.getTitle())) {
            throw new RuntimeException("There is already a company with same title!");
        }

        final Company companyEntityToBeSave = CompanyMapper.mapForSaving(request, user);

        final Company savedCompanyEntity = companyRepository.save(companyEntityToBeSave);

        user.setCompany(savedCompanyEntity);
        user.setRole(Role.COMPANY_OWNER);

        userRepository.save(user);

        return savedCompanyEntity;
    }


    /**
     * Yalnızca ADMIN seviyesinde rolü olan bir kullanıcı tarafından erişilebilen bir metoddur.
     * Projedeki tüm {@link Company} entity nesnelerini geriye döndürür.
     *
     * @return
     */
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }


    public Company getOneCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found:" + id));
    }


    /**
     * ID değeri belirtilen {@link Company} entity nesnesini verilen
     * {@link CompanyUpdateRequest} request DTO nesnesini kullanarak günceller
     * ve geriye güncellenmiş olan {@link Company} entity nesnesini döner.
     *
     * @param id
     * @param request
     * @return
     */
    public Company updateCompanyById(Long id, CompanyUpdateRequest request, User user) {

        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find a Company with given id: " + id));

        if(!user.getCompany().getId().equals(id))
            throw new RuntimeException("Aga nereye erişiyon?");

        CompanyMapper.mapForUpdating(company, request, user);

        return companyRepository.save(company);

    }

    /**
     * ID değeri belirtilen {@link Company} nesnesini silmek için kullanılan metoddur.
     *
     * @param id
     */
    @Transactional
    public void deleteCompanyById(
            Long id,
            User ownerUser
    ) {


        Company companyEntityToDelete = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Böyle bir company bulunamadı."));

        if(!companyEntityToDelete.getId().equals(ownerUser.getCompany().getId())){
            // TODO : Bu lisanı düzelt

            throw new RuntimeException("Aga sen nereye erişiyorsun!");
        }

        List<User> subUserEntitiesToDelete = companyEntityToDelete.getUsers();
        companyEntityToDelete.setUsers(null);

        subUserEntitiesToDelete.stream()
                .filter(user -> user.getRole().equals(Role.COMPANY_USER))
                .forEach(user ->
                {
                    user.setCompany(null);
                    userRepository.delete(user);
                });



        ownerUser.setRole(Role.USER);
        ownerUser.setCompany(null);

        userRepository.save(ownerUser);

        companyRepository.delete(companyEntityToDelete);
    }
}
