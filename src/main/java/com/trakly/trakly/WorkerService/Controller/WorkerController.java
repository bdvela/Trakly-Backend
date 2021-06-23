package com.trakly.trakly.WorkerService.Controller;

import com.trakly.trakly.AreaService.Resource.AreaResource;
import com.trakly.trakly.AreaService.Resource.SaveAreaResource;
import com.trakly.trakly.Models.Area;
import com.trakly.trakly.Models.Worker;
import com.trakly.trakly.WorkerService.Resource.SaveWorkerResource;
import com.trakly.trakly.WorkerService.Resource.WorkerResource;
import com.trakly.trakly.WorkerService.Service.Implementation.WorkerService;
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
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Post Worker", description = "Create Worker", tags = {"workers"})
    @PostMapping("/worker/{areaId}")
    public WorkerResource createWorker(@PathVariable Long areaId, @Valid @RequestBody SaveWorkerResource resource){
        Worker worker = convertToEntity(resource);
        return convertToResource(workerService.createWorker(areaId, worker));
    }

    @Operation(summary = "Get Workers", description = "Get All Workers", tags = {"workers"})
    @GetMapping("/worker")
    public Page<WorkerResource> getAllWorkers(Pageable pageable){
        Page<Worker> workerPage = workerService.getAllWorkers(pageable);
        List<WorkerResource> resources = workerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Update Worker", description = "Update Worker", tags = {"workers"})
    @PutMapping("/worker/{workerId}")
    public WorkerResource updateWorker(@PathVariable Long workerId, @Valid @RequestBody SaveWorkerResource resource){
        Worker worker = convertToEntity(resource);
        return convertToResource(workerService.updateWorker(workerId,worker));
    }

    @Operation(summary = "Delete Worker", description = "Delete Worker", tags = {"workers"})
    @DeleteMapping("/worker/{workerId}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long workerId){
        return workerService.deleteWorker(workerId);
    }

    @Operation(summary = "Get Worker by Id", description = "Get Worker by Id", tags = {"workers"})
    @GetMapping("/worker/{workerId}")
    public WorkerResource getWorkerResource(@PathVariable Long workerId){
        return convertToResource(workerService.getWorkerById(workerId));
    }

    private Worker convertToEntity(SaveWorkerResource resource) {
        return mapper.map(resource, Worker.class);
    }
    private WorkerResource convertToResource(Worker entity)
    {
        return mapper.map(entity, WorkerResource.class);
    }
}
