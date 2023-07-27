package com.smartIq.vehicledealership.vehicledealership.Company.repository;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    boolean existsByTitle(String title);
}
