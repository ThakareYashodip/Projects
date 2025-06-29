package com.example.UrbanServe.controller;

import com.example.UrbanServe.dto.ComplaintCreateRequestDTO;
import com.example.UrbanServe.dto.ComplaintDTO;
import com.example.UrbanServe.entity.Complaint;
import com.example.UrbanServe.entity.User;
import com.example.UrbanServe.mapper.ComplaintMapper;
import com.example.UrbanServe.service.ComplaintService;
import com.example.UrbanServe.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/complaints")
public class ComplaintController {

    private ComplaintService complaintService;
    private UserService userService;

    // Create complaint
    @PostMapping
    public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintCreateRequestDTO request) {
        User user = userService.getUserById(request.getUserId());
        Complaint complaint = ComplaintMapper.complaintDtoToEntity(request.getComplaint(), user);
        Complaint saved = complaintService.creteComplaint(complaint);
        return ResponseEntity.ok(ComplaintMapper.complaintToDTO(saved));
    }

    // Get all the complaint in list
    @GetMapping
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints(){
        List<Complaint> complaintsList = complaintService.getAllComplaints();
        List<ComplaintDTO> complaintDTOList = complaintsList.
                stream().
                map(ComplaintMapper::complaintToDTO).
                collect(Collectors.toList()
                );
        return ResponseEntity.ok(complaintDTOList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ComplaintDTO>> getComplaintsByUser(@PathVariable Long userId) {
        List<Complaint> complaints = complaintService.getComplaintsByUserId(userId);
        List<ComplaintDTO> dtos = complaints.stream()
                .map(ComplaintMapper::complaintToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ComplaintDTO> updateComplaintStatus(@PathVariable Long id, @RequestParam Complaint.Status status) {
        Complaint updated = complaintService.updateComplaintStatus(id, status);
        return ResponseEntity.ok(ComplaintMapper.complaintToDTO(updated));
    }
}


/*
package com.example.UrbanServe.controller;

import com.example.UrbanServe.dto.ComplaintDTO;
import com.example.UrbanServe.entity.Complaint;
import com.example.UrbanServe.entity.User;
import com.example.UrbanServe.mapper.ComplaintMapper;
import com.example.UrbanServe.service.ComplaintService;
import com.example.UrbanServe.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintDTO complaintDTO, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        Complaint complaint = ComplaintMapper.complaintDtoToEntity(complaintDTO);
        complaint.setUser(user);

        Complaint saved = complaintService.createComplaint(complaint);
        return ResponseEntity.ok(ComplaintMapper.complaintToDTO(saved));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ComplaintDTO>> getComplaintsByUser(@PathVariable Long userId) {
        List<Complaint> complaints = complaintService.getComplaintsByUserId(userId);
        List<ComplaintDTO> dtos = complaints.stream()
                .map(ComplaintMapper::complaintToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ComplaintDTO> updateComplaintStatus(@PathVariable Long id, @RequestParam Complaint.Status status) {
        Complaint updated = complaintService.updateComplaintStatus(id, status);
        return ResponseEntity.ok(ComplaintMapper.complaintToDTO(updated));
    }

    @GetMapping
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        List<ComplaintDTO> dtos = complaints.stream()
                .map(ComplaintMapper::complaintToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}

*/