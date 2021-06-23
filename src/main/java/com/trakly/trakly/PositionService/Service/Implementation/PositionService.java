package com.trakly.trakly.PositionService.Service.Implementation;

import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PositionService {
    Page<Position> getAllPositions(Pageable pageable);
    Position getPositionById(Long positionId);
    Position createPosition(Long workerId, Position position);
    Position updatePosition(Long positionId, Position positionRequest);
    ResponseEntity<?> deletePosition (Long positionId);
}
