package com.example.HireHub.service;

import com.example.HireHub.dto.CompanyJobDashboardResponse;
import com.example.HireHub.dto.CreateJobRequest;
import com.example.HireHub.entity.Company;
import com.example.HireHub.entity.Job;
import com.example.HireHub.repositories.ApplicationRepository;
import com.example.HireHub.repositories.CompanyRepository;
import com.example.HireHub.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final ApplicationRepository applicationRepository;

    public Job createJob(CreateJobRequest request, String email) {
        Company company = companyRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Job job = Job.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .salary(request.getSalary())
                .type(request.getType())
                .postedDate(LocalDate.now())
                .company(company)
                .build();

        return jobRepository.save(job);
    }

    public Job updateJob(Long id, CreateJobRequest request, String email) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Ensure company owns this job
        if (!job.getCompany().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setType(request.getType());

        return jobRepository.save(job);
    }

    public void deleteJob(Long id, String email) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getCompany().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        jobRepository.delete(job);
    }

    public List<Job> searchJobs(String title, String location, String type) {
        return jobRepository.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCaseAndTypeContainingIgnoreCase(
                title == null ? "" : title,
                location == null ? "" : location,
                type == null ? "" : type);
    }

    public List<CompanyJobDashboardResponse> getCompanyJobDashboard(String companyEmail) {
        Company company = companyRepository.findByEmail(companyEmail)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        List<Job> jobs = jobRepository.findByCompany(company);

        return jobs.stream().map(job -> {
            CompanyJobDashboardResponse dto = new CompanyJobDashboardResponse();
            dto.setJobId(job.getId());
            dto.setTitle(job.getTitle());
            dto.setLocation(job.getLocation());
            dto.setType(job.getType());
            dto.setTotalApplicants(applicationRepository.countByJob(job));
            return dto;
        }).toList();
    }

}
