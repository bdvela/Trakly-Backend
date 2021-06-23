package com.trakly.trakly.TaskListService.Controller;

import com.trakly.trakly.Models.TaskList;
import com.trakly.trakly.TaskListService.Resource.SaveTaskListResource;
import com.trakly.trakly.TaskListService.Resource.TaskListResource;
import com.trakly.trakly.TaskListService.Service.Implementation.TaskListService;
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
public class TaskListController {
    @Autowired
    private TaskListService taskListService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Post TaskList", description = "Create TaskList", tags = {"taskLists"})
    @PostMapping("/taskList/")
    public TaskListResource createTaskList(@Valid @RequestBody SaveTaskListResource resource){
        TaskList taskList = convertToEntity(resource);
        return convertToResource(taskListService.createTaskList(taskList));
    }

    @Operation(summary = "Get TaskLists", description = "Get All TaskLists", tags = {"taskLists"})
    @GetMapping("/taskList")
    public Page<TaskListResource> getAllTaskLists(Pageable pageable){
        Page<TaskList> taskListPage = taskListService.getAllTaskLists(pageable);
        List<TaskListResource> resources = taskListPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Update TaskList", description = "Update TaskList", tags = {"taskLists"})
    @PutMapping("/taskList/{taskListId}")
    public TaskListResource updateTaskList(@PathVariable Long taskListId, @Valid @RequestBody SaveTaskListResource resource){
        TaskList taskList = convertToEntity(resource);
        return convertToResource(taskListService.updateTaskList(taskListId,taskList));
    }

    @Operation(summary = "Delete TaskList", description = "Delete TaskList", tags = {"taskLists"})
    @DeleteMapping("/taskList/{taskListId}")
    public ResponseEntity<?> deleteTaskList(@PathVariable Long taskListId){
        return taskListService.deleteTaskList(taskListId);
    }

    @Operation(summary = "Get TaskList by Id", description = "Get TaskList by Id", tags = {"taskLists"})
    @GetMapping("/taskList/{taskListId}")
    public TaskListResource getTaskListResource(@PathVariable Long taskListId){
        return convertToResource(taskListService.getTaskListById(taskListId));
    }

    private TaskList convertToEntity(SaveTaskListResource resource) {
        return mapper.map(resource, TaskList.class);
    }
    private TaskListResource convertToResource(TaskList entity)
    {
        return mapper.map(entity, TaskListResource.class);
    }
}
