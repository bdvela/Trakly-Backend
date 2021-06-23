package com.trakly.trakly.WorkerService.Repository;

import com.trakly.trakly.Models.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    public Page<Worker> findById(Long Id, Pageable pageable);
}
