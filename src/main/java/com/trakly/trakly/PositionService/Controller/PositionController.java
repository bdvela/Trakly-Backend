package com.trakly.trakly.PositionService.Controller;

import com.trakly.trakly.CompanyService.Resource.CompanyResource;
import com.trakly.trakly.CompanyService.Resource.SaveCompanyResource;
import com.trakly.trakly.CompanyService.Service.Implementation.CompanyService;
import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Position;
import com.trakly.trakly.PositionService.Resource.PositionResource;
import com.trakly.trakly.PositionService.Resource.SavePositionResource;
import com.trakly.trakly.PositionService.Service.Implementation.PositionService;
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
public class PositionController {
    @Autowired
    private PositionService positionService;

    @Autowired
    private ModelMapper mapper;


    @Operation(summary = "Post Position", description = "Create Position", tags = {"positions"})
    @PostMapping("/position")
    public PositionResource createPosition(@Valid @RequestBody SavePositionResource resource) {
        Position position = convertToEntity(resource);
        return convertToResource(positionService.createPosition(position));
    }

    @Operation(summary = "Get Positions", description = "Get All Positions", tags={"positions"})
    @GetMapping("/position")
    public Page<PositionResource> getAllPositions(Pageable pageable){
        Page<Position> positionPage = positionService.getAllPositions(pageable);
        List<PositionResource> resources = positionPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Update Position", description="Update Position", tags={"positions"})
    @PutMapping("/position/{positionId}")
    public PositionResource updatePosition(@PathVariable Long positionId,
                                         @Valid @RequestBody SavePositionResource resource){
        Position position = convertToEntity(resource);
        return convertToResource(positionService.updatePosition(positionId,position));
    }

    @Operation(summary = "Delete Position", description = "Delete Position", tags={"positions"})
    @DeleteMapping("/position/{positionId}")
    public ResponseEntity<?> deletePosition(@PathVariable Long positionId) {
        return positionService.deletePosition(positionId);
    }

    @Operation(summary = "Get Position by Id", description = "Get Position by Id", tags={"positions"})
    @GetMapping("/position/{positionId}")
    public PositionResource getPositionResource(@PathVariable Long positionId){
        return convertToResource(positionService.getPositionById(positionId));
    }

    private Position convertToEntity(SavePositionResource resource) {
        return mapper.map(resource, Position.class);
    }

    private PositionResource convertToResource(Position entity) {
        return mapper.map(entity, PositionResource.class);
    }
}