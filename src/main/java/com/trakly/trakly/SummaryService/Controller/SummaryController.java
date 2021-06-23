package com.trakly.trakly.SummaryService.Controller;

import com.trakly.trakly.CompanyService.Resource.CompanyResource;
import com.trakly.trakly.CompanyService.Resource.SaveCompanyResource;
import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Summary;
import com.trakly.trakly.SummaryService.Resource.SaveSummaryResource;
import com.trakly.trakly.SummaryService.Resource.SummaryResource;
import com.trakly.trakly.SummaryService.Service.Implementation.SummaryService;
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
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Post Summary", description="Create Summary", tags={"summaries"})
    @PostMapping("/summary/{workerId}")
    public SummaryResource createSummary(@PathVariable Long workerId, @Valid @RequestBody SaveSummaryResource resource) {
        Summary summary = convertToEntity(resource);
        return convertToResource(summaryService.createSummary(workerId, summary));
    }

    @Operation(summary = "Get Summaries", description = "Get All Summaries", tags={"summaries"})
    @GetMapping("/summary")
    public Page<SummaryResource> getAllSummaries(Pageable pageable){
        Page<Summary> summaryPage = summaryService.getAllSummaries(pageable);
        List<SummaryResource> resources = summaryPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Update Summary", description="Update Summary", tags={"summaries"})
    @PutMapping("/summary/{summaryId}")
    public SummaryResource updateSummary(@PathVariable Long summaryId,
                                         @Valid @RequestBody SaveSummaryResource resource){
        Summary summary = convertToEntity(resource);
        return convertToResource(summaryService.updateSummary(summaryId,summary));
    }

    @Operation(summary = "Delete Summary", description = "Delete Summary", tags={"summaries"})
    @DeleteMapping("/summary/{summaryId}")
    public ResponseEntity<?> deleteSummary(@PathVariable Long summaryId) {
        return summaryService.deleteSummary(summaryId);
    }

    @Operation(summary = "Get Summary by Id", description = "Get Summary by Id", tags={"summaries"})
    @GetMapping("/summary/{summaryId}")
    public SummaryResource getSummaryResource(@PathVariable Long summaryId){
        return convertToResource(summaryService.getSummaryById(summaryId));
    }

    private Summary convertToEntity(SaveSummaryResource resource) {
        return mapper.map(resource, Summary.class);
    }
    private SummaryResource convertToResource(Summary entity)
    {
        return mapper.map(entity, SummaryResource.class);
    }
}
