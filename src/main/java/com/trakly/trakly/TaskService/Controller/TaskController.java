package com.trakly.trakly.TaskService.Controller;

import com.trakly.trakly.CompanyService.Resource.CompanyResource;
import com.trakly.trakly.CompanyService.Resource.SaveCompanyResource;
import com.trakly.trakly.CompanyService.Service.Implementation.CompanyService;
import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Task;
import com.trakly.trakly.TaskService.Resource.SaveTaskResource;
import com.trakly.trakly.TaskService.Resource.TaskResource;
import com.trakly.trakly.TaskService.Service.Implementation.TaskService;
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
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Post Task", description="Create Task", tags={"tasks"})
    @PostMapping("/task/{taskListId}")
    public TaskResource createTask(@PathVariable Long taskListId, @Valid @RequestBody SaveTaskResource resource) {
        Task task = convertToEntity(resource);
        return convertToResource(taskService.createTask(taskListId, task));
    }

    @Operation(summary = "Get tasks", description = "Get All Tasks", tags={"tasks"})
    @GetMapping("/task")
    public Page<TaskResource> getAllTasks(Pageable pageable){
        Page<Task> taskPage = taskService.getAllTasks(pageable);
        List<TaskResource> resources = taskPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Update Task", description="Update Task", tags={"tasks"})
    @PutMapping("/task/{taskId}")
    public TaskResource updateTask(@PathVariable Long taskId,
                                         @Valid @RequestBody SaveTaskResource resource){
        Task task = convertToEntity(resource);
        return convertToResource(taskService.updateTask(taskId,task));
    }

    @Operation(summary = "Delete Task", description = "Delete Task", tags={"tasks"})
    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }

    @Operation(summary = "Get Task by Id", description = "Get Task by Id", tags={"tasks"})
    @GetMapping("/task/{taskId}")
    public TaskResource getTaskResource(@PathVariable Long taskId){
        return convertToResource(taskService.getTaskById(taskId));
    }


    private Task convertToEntity(SaveTaskResource resource) {
        return mapper.map(resource, Task.class);
    }
    private TaskResource convertToResource(Task entity)
    {
        return mapper.map(entity, TaskResource.class);
    }
}
