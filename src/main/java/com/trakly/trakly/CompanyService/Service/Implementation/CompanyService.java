package com.trakly.trakly.CompanyService.Service.Implementation;

import com.trakly.trakly.Models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CompanyService {
    Page<Company> getAllCompanies(Pageable pageable);
    Company getCompanyById(Long companyId);
    Company createCompany(Company company);
    Company updateCompany(Long companyId, Company companyRequest);
    ResponseEntity<?> deleteCompany (Long companyId);
}
