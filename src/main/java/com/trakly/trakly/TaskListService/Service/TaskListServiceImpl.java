package com.trakly.trakly.TaskListService.Service;

import com.trakly.trakly.Models.TaskList;
import com.trakly.trakly.TaskListService.Repository.TaskListRepository;
import com.trakly.trakly.TaskListService.Service.Implementation.TaskListService;
import com.trakly.trakly.WorkerService.Repository.WorkerRepository;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskListServiceImpl implements TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Page<TaskList> getAllTaskLists(Pageable pageable) {
        return taskListRepository.findAll(pageable);
    }

    @Override
    public TaskList getTaskListById(Long taskListId) {
        return taskListRepository.findById(taskListId)
                .orElseThrow(()->new ResourceNotFoundException("TaskList","Id",taskListId));
    }

    @Override
    public TaskList createTaskList(Long workerId, TaskList taskList) {
        return workerRepository.findById(workerId).map(worker -> {
            taskList.setWorker(worker);
            return taskListRepository.save(taskList);
        }).orElseThrow(() -> new ResourceNotFoundException("Worker","Id", workerId));
    }

    @Override
    public TaskList updateTaskList(Long taskListId, TaskList taskListRequest) {
        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new ResourceNotFoundException("TaskList","Id",taskListId));
        return taskListRepository.save(
                taskList.setName(taskListRequest.getName()));
    }

    @Override
    public ResponseEntity<?> deleteTaskList(Long taskListId) {
        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new ResourceNotFoundException("TaskList","Id",taskListId));
        taskListRepository.delete(taskList);
        return ResponseEntity.ok().build();
    }
}
