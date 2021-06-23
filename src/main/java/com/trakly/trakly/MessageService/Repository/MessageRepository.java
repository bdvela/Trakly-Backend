package com.trakly.trakly.MessageService.Repository;

import com.trakly.trakly.Models.Message;
import com.trakly.trakly.Models.Summary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public Page<Message> findById(Long Id, Pageable pageable);
}
