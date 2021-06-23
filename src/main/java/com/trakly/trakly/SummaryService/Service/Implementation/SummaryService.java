package com.trakly.trakly.SummaryService.Service.Implementation;

import com.trakly.trakly.Models.Summary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SummaryService {
    Page<Summary> getAllSummaries(Pageable pageable);
    Summary getSummaryById(Long summaryId);
    Summary createSummary(Summary summary);
    Summary updateSummary(Long summaryId, Summary summaryRequest);
    ResponseEntity<?> deleteSummary (Long summaryId);
}
