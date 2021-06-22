package com.trakly.trakly.CompanyService.Service;

import com.trakly.trakly.CompanyService.Repository.CompanyRepository;
import com.trakly.trakly.CompanyService.Service.Implementation.CompanyService;
import com.trakly.trakly.Models.Company;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> getAllCompany(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFoundException("Company","Id",companyId));
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long companyId, Company companyRequest) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company","Id",companyId));
        return companyRepository.save(
                company.setName(companyRequest.getName()));
    }

    @Override
    public ResponseEntity<?> deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company","Id",companyId));
        companyRepository.delete(company);
        return ResponseEntity.ok().build();
    }
}
