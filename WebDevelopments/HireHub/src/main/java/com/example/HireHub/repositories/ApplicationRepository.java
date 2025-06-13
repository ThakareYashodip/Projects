package com.example.HireHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HireHub.entity.Application;
import com.example.HireHub.entity.Job;
import com.example.HireHub.entity.User;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByUser(User user);

    List<Application> findByJob(Job job);

    boolean existsByUserAndJob(User user, Job job);
    
    List<Application> findByJobId(Long jobId);

    List<Application> findByUserEmail(String email);

    List<Application> findByJobIn(List<Job> jobs);

    long countByJob(Job job);

}

    