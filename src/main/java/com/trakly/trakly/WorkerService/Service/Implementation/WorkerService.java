package com.trakly.trakly.WorkerService.Service.Implementation;

import com.trakly.trakly.Models.Area;
import com.trakly.trakly.Models.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface WorkerService {
    Page<Worker> getAllWorkers(Pageable pageable);
    Worker getWorkerById(Long workerId);
    Worker createWorker(Long areaId, Worker worker);
    Worker updateWorker(Long workerId, Worker workerRequest);
    ResponseEntity<?> deleteWorker(Long workerId);
}
