package com.trakly.trakly.AreaService.Repository;

import com.trakly.trakly.Models.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    public Page<Area> findById(Long Id, Pageable pageable);
}
