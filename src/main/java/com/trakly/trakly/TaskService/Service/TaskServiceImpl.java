package com.trakly.trakly.TaskService.Service;

import com.trakly.trakly.CompanyService.Repository.CompanyRepository;
import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Task;
import com.trakly.trakly.Models.TaskList;
import com.trakly.trakly.TaskListService.Repository.TaskListRepository;
import com.trakly.trakly.TaskService.Repository.TaskRepository;
import com.trakly.trakly.TaskService.Service.Implementation.TaskService;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    @Override
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(()->new ResourceNotFoundException("Task","Id",taskId));
    }

    @Override
    public Task createTask(Long taskListId, Task task) {
        return taskListRepository.findById(taskListId).map(taskList -> {
            task.setTaskList(taskList);
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("TaskList", "Id", taskListId));
    }

    @Override
    public Task updateTask(Long taskId, Task taskRequest) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task","Id",taskId));
        return taskRepository.save(
                task.setDescription(taskRequest.getDescription()).setStatus(taskRequest.getStatus()).setStartDate(taskRequest.getStartDate()).setEndDate(taskRequest.getEndDate()));
    }

    @Override
    public ResponseEntity<?> deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Company","Id",taskId));
        taskRepository.delete(task);
        return ResponseEntity.ok().build();
    }
}
