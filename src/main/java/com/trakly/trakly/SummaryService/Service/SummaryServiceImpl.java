package com.trakly.trakly.SummaryService.Service;

import com.trakly.trakly.Models.Company;
import com.trakly.trakly.Models.Summary;
import com.trakly.trakly.SummaryService.Repository.SummaryRepository;
import com.trakly.trakly.SummaryService.Service.Implementation.SummaryService;
import com.trakly.trakly.WorkerService.Repository.WorkerRepository;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Page<Summary> getAllSummaries(Pageable pageable) {
        return summaryRepository.findAll(pageable);
    }

    @Override
    public Summary getSummaryById(Long summaryId) {
        return summaryRepository.findById(summaryId)
                .orElseThrow(()->new ResourceNotFoundException("Summary","Id",summaryId));
    }

    @Override
    public Summary createSummary(Long workerId, Summary summary) {
        return workerRepository.findById(workerId).map(worker -> {
            summary.setWorker(worker);
            return summaryRepository.save(summary);
        }).orElseThrow(() -> new ResourceNotFoundException("Worker","Id",workerId));
    }

    @Override
    public Summary updateSummary(Long summaryId, Summary summaryRequest) {
        Summary summary = summaryRepository.findById(summaryId)
                .orElseThrow(() -> new ResourceNotFoundException("Summary","Id",summaryId));
        return summaryRepository.save(
                summary.setFinishedTasks(summaryRequest.getFinishedTasks()).setPendingTasks(summaryRequest.getPendingTasks()).setMonthlyAverage(summaryRequest.getMonthlyAverage()));
    }

    @Override
    public ResponseEntity<?> deleteSummary(Long summaryId) {
        Summary summary = summaryRepository.findById(summaryId)
                .orElseThrow(() -> new ResourceNotFoundException("Summary","Id",summaryId));
        summaryRepository.delete(summary);
        return ResponseEntity.ok().build();
    }
}
