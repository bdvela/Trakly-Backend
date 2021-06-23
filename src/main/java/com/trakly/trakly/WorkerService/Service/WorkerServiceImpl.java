package com.trakly.trakly.WorkerService.Service;

import com.trakly.trakly.AreaService.Repository.AreaRepository;
import com.trakly.trakly.Models.Area;
import com.trakly.trakly.Models.Worker;
import com.trakly.trakly.WorkerService.Repository.WorkerRepository;
import com.trakly.trakly.WorkerService.Service.Implementation.WorkerService;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Page<Worker> getAllWorkers(Pageable pageable) {
        return workerRepository.findAll(pageable);
    }

    @Override
    public Worker getWorkerById(Long workerId) {
        return workerRepository.findById(workerId)
                .orElseThrow(()->new ResourceNotFoundException("Worker","Id",workerId));
    }

    @Override
    public Worker createWorker(Long areaId, Worker worker) {
        return areaRepository.findById(areaId).map(area -> {
            worker.setArea(area);
            return workerRepository.save(worker);
        }).orElseThrow(() -> new ResourceNotFoundException("Area","Id",areaId));
    }

    @Override
    public Worker updateWorker(Long workerId, Worker workerRequest) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker","Id",workerId));
        return workerRepository.save(
                worker.setName(workerRequest.getName()).setAge(workerRequest.getAge()).setLastName(workerRequest.getLastName()).setProfession(workerRequest.getProfession()).setPhoneNumber(workerRequest.getPhoneNumber()));
    }

    @Override
    public ResponseEntity<?> deleteWorker(Long workerId) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker","Id",workerId));
        workerRepository.delete(worker);
        return ResponseEntity.ok().build();
    }
}
