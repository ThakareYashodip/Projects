package com.example.HireHub.repositories;

import com.example.HireHub.entity.Company;
import com.example.HireHub.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCaseAndTypeContainingIgnoreCase(
            String title, String location, String type);

    List<Job> findByCompany(Company company);

    List<Job> findByCompanyEmail(String email);

    @Query("SELECT j FROM Job j WHERE " +
            "(:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
            "(:type IS NULL OR LOWER(j.type) = LOWER(:type))")
    List<Job> searchJobs(@Param("title") String title,
            @Param("location") String location,
            @Param("type") String type);

}
