package com.trakly.trakly.CompanyService.Repository;

import com.trakly.trakly.Models.Area;
import com.trakly.trakly.Models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Page<Area> findById(Long Id, Pageable pageable);
}
