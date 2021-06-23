package com.trakly.trakly.PositionService.Service;

import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Position;
import com.trakly.trakly.PositionService.Repository.PositionRepository;
import com.trakly.trakly.PositionService.Service.Implementation.PositionService;
import com.trakly.trakly.WorkerService.Repository.WorkerRepository;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Page<Position> getAllPositions(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position getPositionById(Long positionId) {
        return positionRepository.findById(positionId)
                .orElseThrow(()->new ResourceNotFoundException("Position","Id",positionId));
    }

    @Override
    public Position createPosition(Long workerId, Position position) {
        return workerRepository.findById(workerId).map(worker -> {
            position.setWorker(worker);
            return positionRepository.save(position);
        }).orElseThrow(() -> new ResourceNotFoundException("Worker","Id",workerId));
    }

    @Override
    public Position updatePosition(Long positionId, Position positionRequest) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position","Id",positionId));
        return positionRepository.save(
                position.setName(positionRequest.getName()));
    }

    @Override
    public ResponseEntity<?> deletePosition(Long positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position","Id",positionId));
        positionRepository.delete(position);
        return ResponseEntity.ok().build();
    }
}
