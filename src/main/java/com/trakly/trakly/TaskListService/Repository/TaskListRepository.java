package com.trakly.trakly.TaskListService.Repository;

import com.trakly.trakly.Models.TaskList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    public Page<TaskList> findById(Long Id, Pageable pageable);
}
