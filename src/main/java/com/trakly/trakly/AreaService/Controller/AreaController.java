package com.trakly.trakly.AreaService.Controller;

import com.trakly.trakly.AreaService.Resource.AreaResource;
import com.trakly.trakly.AreaService.Resource.SaveAreaResource;
import com.trakly.trakly.AreaService.Service.Implementation.AreaService;
import com.trakly.trakly.Models.Area;
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
public class AreaController {
    @Autowired
    private AreaService areaService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Post Area", description = "Create Area", tags = {"areas"})
    @PostMapping("/area/{companyId}")
    public AreaResource createArea(@PathVariable Long companyId, @Valid @RequestBody SaveAreaResource resource){
        Area area = convertToEntity(resource);
        return convertToResource(areaService.createArea(companyId, area));
    }

    @Operation(summary = "Get Areas", description = "Get All Areas", tags = {"areas"})
    @GetMapping("/area")
    public Page<AreaResource> getAllAreas(Pageable pageable){
        Page<Area> areaPage = areaService.getAllAreas(pageable);
        List<AreaResource> resources = areaPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Update Area", description = "Update Area", tags = {"areas"})
    @PutMapping("/area/{areaId}")
    public AreaResource updateArea(@PathVariable Long areaId, @Valid @RequestBody SaveAreaResource resource){
        Area area = convertToEntity(resource);
        return convertToResource(areaService.updateArea(areaId,area));
    }

    @Operation(summary = "Delete Area", description = "Delete Area", tags = {"areas"})
    @DeleteMapping("/area/{areaId}")
    public ResponseEntity<?> deleteArea(@PathVariable Long areaId){
        return areaService.deleteArea(areaId);
    }

    @Operation(summary = "Get Area by Id", description = "Get Area by Id", tags = {"areas"})
    @GetMapping("/area/{areaId}")
    public AreaResource getAreaResource(@PathVariable Long areaId){
        return convertToResource(areaService.getAreaById(areaId));
    }

    private Area convertToEntity(SaveAreaResource resource) {
        return mapper.map(resource, Area.class);
    }
    private AreaResource convertToResource(Area entity)
    {
        return mapper.map(entity, AreaResource.class);
    }
}
