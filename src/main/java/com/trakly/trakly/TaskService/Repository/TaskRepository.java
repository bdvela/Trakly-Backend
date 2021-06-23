package com.trakly.trakly.TaskService.Repository;

import com.trakly.trakly.Models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public Page<Task> findById(Long Id, Pageable pageable);
}
