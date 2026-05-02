package com.cdtc.Mazdoor_application.repository;

import com.cdtc.Mazdoor_application.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    // Spring Data JPA provides save(), findById(), etc., automatically.
    @Query("SELECT j FROM Job j WHERE LOWER(j.requiredSkill) LIKE LOWER(CONCAT('%', :requiredSkill, '%'))")
    List<Job> findByRequiredSkill(@Param("requiredSkill") String requiredSkill);
}
