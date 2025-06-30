package com.example.UrbanServe.service;

import com.example.UrbanServe.entity.Complaint;
import com.example.UrbanServe.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
//    Complaint createComplaint(Complaint complaint);
    public Complaint creteComplaint(Complaint complaint){
        return complaintRepository.save(complaint);
    }
//    List<Complaint> getComplaintsByUserId(Long userId);
    public List<Complaint> getComplaintsByUserId(Long userId){
        return complaintRepository.findByUserId(userId);
    }
//    List<Complaint> getAllComplaints(); // For admin
    public List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }
//    Complaint getComplaintById(Long id);
    public Complaint getComplaintById(Long id){
        return complaintRepository.findById(id).orElseThrow(()-> new RuntimeException("Complaint not found !"));
    }
//    Complaint updateComplaintStatus(Long id, Complaint.Status newStatus);
    public Complaint updateComplaintStatus(Long id, Complaint.Status newStatus){
        Complaint complaint = getComplaintById(id);
        complaint.setStatus(newStatus);
        return complaintRepository.save(complaint);
    }
}
