package com.dextris.dextris.repository;

import com.dextris.dextris.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AttachmentRepository  extends JpaRepository<Attachment,String> {

    @Transactional
    @Modifying
    @Query("update Attachment info set info.URL=:url where info.id=:id")

    void updateURLById(@Param("url") String url,@Param("id") String id);
}
