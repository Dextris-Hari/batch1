package com.dextris.dextris.repository;

import com.dextris.dextris.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository  extends JpaRepository<Attachment,String> {
}
