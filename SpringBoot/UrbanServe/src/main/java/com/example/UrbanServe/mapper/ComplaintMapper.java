package com.example.UrbanServe.mapper;

import com.example.UrbanServe.dto.ComplaintDTO;
import com.example.UrbanServe.entity.Complaint;
import com.example.UrbanServe.entity.User;

public class ComplaintMapper {

    public static ComplaintDTO complaintToDTO(Complaint complaint) {
        return new ComplaintDTO(
                complaint.getId(),
                complaint.getTitle(),
                complaint.getDescription(),
                complaint.getStatus(),
                complaint.getCreatedAt()
        );
    }

    public static Complaint complaintDtoToEntity(ComplaintDTO complaintDTO , User user) {
        Complaint complaint = new Complaint();
        complaint.setTitle(complaintDTO.getTitle());
        complaint.setDescription(complaintDTO.getDescription());
        complaint.setStatus(complaintDTO.getStatus());
        complaint.setUser(user);
        // No need to set createdAt here; @PrePersist will handle it
        return complaint;
    }
}
