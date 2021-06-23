package com.trakly.trakly.PositionService.Repository;

import com.trakly.trakly.Models.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
    public Page<Position> findById(Long Id, Pageable pageable);
}
