package com.trakly.trakly.AreaService.Service;

import com.trakly.trakly.AreaService.Repository.AreaRepository;
import com.trakly.trakly.AreaService.Service.Implementation.AreaService;
import com.trakly.trakly.CompanyService.Repository.CompanyRepository;
import com.trakly.trakly.Models.Area;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Area> getAllAreas(Pageable pageable){
        return areaRepository.findAll(pageable);
    }

    @Override
    public Area getAreaById(Long areaId){
        return areaRepository.findById(areaId)
                .orElseThrow(()->new ResourceNotFoundException("Area","Id",areaId));
    }

    @Override
    public Area createArea(Long companyId, Area area){
        return companyRepository.findById(companyId).map(company -> {
            area.setCompany(company);
            return areaRepository.save(area);
        }).orElseThrow(() -> new ResourceNotFoundException("Company","Id",companyId));
    }

    @Override
    public Area updateArea(Long areaId, Area areaRequest){
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new ResourceNotFoundException("Area","Id",areaId));
        return areaRepository.save(
                area.setName(areaRequest.getName()));
    }

    @Override
    public ResponseEntity<?> deleteArea(Long areaId){
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new ResourceNotFoundException("Area","Id",areaId));
        areaRepository.delete(area);
        return ResponseEntity.ok().build();
    }
}
