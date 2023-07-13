package com.smartIq.vehicledealership.vehicledealership.Company.service;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.SaveCompanyRequestToCompany;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.UpdateCompanyRequestToCompany;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SaveCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.UpdateCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.repository.CompanyRepository;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


    public List<Company> getAllCompany(){
       return   companyRepository.findAll();


    }

    public Company getOneCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(()->new RuntimeException("Company not found"+ id));
    }
    public Company createCompany(SaveCompanyRequest saveCompanyRequest){
        Company company = SaveCompanyRequestToCompany.toCompany(saveCompanyRequest);
        company.setStatus(Status.ACTIVE); //Mapper içerisine de alınabilir.
        return companyRepository.save(company);
    }


    public Company updateCompanyById(Long id, UpdateCompanyRequest request) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Can't find a Company with given id: "+id));

        company.setTitle(request.getTitle());
        company.setStatus(request.getStatus());

        return companyRepository.save(company);

    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
