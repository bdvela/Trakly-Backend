package com.trakly.trakly.AreaService.Service.Implementation;

import com.trakly.trakly.Models.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AreaService {
    Page<Area> getAllAreas(Pageable pageable);
    Area getAreaById(Long areaId);
    Area createArea(Long companyId, Area area);
    Area updateArea(Long areaId, Area areaRequest);
    ResponseEntity<?> deleteArea(Long areaId);
}
