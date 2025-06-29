package com.example.UrbanServe.service;

import com.example.UrbanServe.entity.Complaint;
import com.example.UrbanServe.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private ComplaintRepository complaintRepository;
//    Complaint createComplaint(Complaint complaint);
    Complaint creteComplaint(Complaint complaint){
        return complaintRepository.save(complaint);
    }
//    List<Complaint> getComplaintsByUserId(Long userId);
    public List<Complaint> getComplaintByUserId(Long userId){
        return complaintRepository.findByUserId(userId);
    }
//    List<Complaint> getAllComplaints(); // For admin
    List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }
//    Complaint getComplaintById(Long id);
    Complaint getComplaintById(Long id){
        return complaintRepository.findById(id).orElseThrow(()-> new RuntimeException("Complaint not found !"));
    }
//    Complaint updateComplaintStatus(Long id, Complaint.Status newStatus);
    Complaint updateComplaintStatus(Long id, Complaint.Status newStatus){
        Complaint complaint = getComplaintById(id);
        complaint.setStatus(newStatus);
        return complaintRepository.save(complaint);
    }
}
