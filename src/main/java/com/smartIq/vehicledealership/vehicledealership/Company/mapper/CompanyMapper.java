package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySaveRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanyUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanyGetResponse;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Company entity nesneleri ile DTO nesneleri arasında mapleme işlemlerini yürüten
 * mapper sınıftır.
 *
 */
public class CompanyMapper {

    /**
     * Verilen {@link CompanySaveRequest} request DTO nesnesini kullanarak
     * veritabanına kayıt edilmek üzere bir Company entity nesnesi geriye mapler ve döndürür.
     *
     * @param request
     * @return
     */
    public static Company mapForSaving(
            CompanySaveRequest request,
            User user
    ){
        return Company.builder()
                .title(request.getTitle())
                .companyStatus(Status.ACTIVE)
                .createdAt(LocalDateTime.now())
                .createdBy(user.getId())
                .build();
    }


    public static void mapForUpdating(
            Company company,
            CompanyUpdateRequest request,
            User user
    ){
        company.setTitle(request.getTitle());
        company.setCompanyStatus(request.getStatus());

        company.setUpdatedAt(LocalDateTime.now());
        company.setUpdatedBy(user.getId());

    }

    /**
     * Parametre olarak verilen {@link Company} entity nesnesini kullanarak
     * geriye {@link CompanyGetResponse} DTO nesnesi oluşturup döndürür.
     *
     * @param company
     * @return
     */
    public static CompanyGetResponse toGetCompanyResponse(
            Company company
    ) {
        return CompanyGetResponse.builder()
                .title(company.getTitle())
                .id(company.getId())
                .build();
    }


    /**
     * Verilen {@link Company} entity nesnesi türündeki listeyi kullanarak
     * {@link CompanyGetResponse} DTO nesnelerinden oluşan bir response DTO listesi
     * oluşturup bunu geriye döner.
     *
     *
     * @param companies
     * @return
     */
    public static List<CompanyGetResponse> toGetCompanyResponse(
            List<Company> companies
    ){
        if(companies == null)
            return null;

        return companies.stream()
                .map(CompanyListToCompanyResponseMapper::toGetCompanyResponse)
                .toList();
    }








}
