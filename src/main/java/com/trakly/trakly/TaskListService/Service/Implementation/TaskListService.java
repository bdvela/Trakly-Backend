package com.trakly.trakly.TaskListService.Service.Implementation;

import com.trakly.trakly.Models.TaskList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TaskListService {
    Page<TaskList> getAllTaskLists(Pageable pageable);
    TaskList getTaskListById(Long taskListId);
    TaskList createTaskList(Long workerId, TaskList taskList);
    TaskList updateTaskList(Long taskListId, TaskList taskListRequest);
    ResponseEntity<?> deleteTaskList(Long taskListId);
}
