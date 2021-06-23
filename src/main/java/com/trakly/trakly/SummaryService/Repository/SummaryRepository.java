package com.trakly.trakly.SummaryService.Repository;

import com.trakly.trakly.Models.Summary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    public Page<Summary> findById(Long Id, Pageable pageable);
}
