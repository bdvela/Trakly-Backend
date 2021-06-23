package com.trakly.trakly.TaskService.Service.Implementation;

import com.trakly.trakly.Models.Area;
import com.trakly.trakly.Models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    Page<Task> getAllTasks(Pageable pageable);
    Task getTaskById(Long taskId);
    Task createTask(Long taskListId, Task task);
    Task updateTask(Long taskId, Task taskRequest);
    ResponseEntity<?> deleteTask(Long taskId);
}
