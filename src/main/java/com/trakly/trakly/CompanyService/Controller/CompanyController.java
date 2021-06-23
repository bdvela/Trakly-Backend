package com.trakly.trakly.CompanyService.Controller;

import com.trakly.trakly.CompanyService.Resource.CompanyResource;
import com.trakly.trakly.CompanyService.Resource.SaveCompanyResource;
import com.trakly.trakly.CompanyService.Service.Implementation.CompanyService;
import com.trakly.trakly.Models.Company;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Post Company", description="Create Company", tags={"companies"})
    @PostMapping("/company")
    public CompanyResource createCompany(@Valid @RequestBody SaveCompanyResource resource) {
        Company company = convertToEntity(resource);
        return convertToResource(companyService.createCompany(company));
    }

    @Operation(summary = "Get Companies", description = "Get All Companies", tags={"companies"})
    @GetMapping("/company")
    public Page<CompanyResource> getAllCompanies(Pageable pageable){
        Page<Company> companyPage = companyService.getAllCompanies(pageable);
        List<CompanyResource> resources = companyPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Update Company", description="Update Company", tags={"companies"})
    @PutMapping("/company/{companyId}")
    public CompanyResource updateCompany(@PathVariable Long companyId,
                                         @Valid @RequestBody SaveCompanyResource resource){
        Company company = convertToEntity(resource);
        return convertToResource(companyService.updateCompany(companyId,company));
    }

    @Operation(summary = "Delete Company", description = "Delete Company", tags={"companies"})
    @DeleteMapping("/company/{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId) {
        return companyService.deleteCompany(companyId);
    }

    @Operation(summary = "Get Company by Id", description = "Get Company by Id", tags={"companies"})
    @GetMapping("/company/{companyId}")
    public CompanyResource getCompanyResource(@PathVariable Long companyId){
        return convertToResource(companyService.getCompanyById(companyId));
    }


    private Company convertToEntity(SaveCompanyResource resource) {
        return mapper.map(resource, Company.class);
    }
    private CompanyResource convertToResource(Company entity)
    {
        return mapper.map(entity, CompanyResource.class);
    }
}
