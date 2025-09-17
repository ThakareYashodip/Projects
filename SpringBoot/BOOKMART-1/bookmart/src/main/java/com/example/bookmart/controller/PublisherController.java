package com.example.bookmart.controller;

import com.example.bookmart.entity.Publisher;
import com.example.bookmart.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // Create Publisher
    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(publisherService.savePublisher(publisher));
    }

    // Get All Publishers
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    // Get Publisher by ID
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    // Update Publisher
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        return ResponseEntity.ok(publisherService.updatePublisher(id, publisher));
    }

    // Delete Publisher
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted successfully!");
    }

    // Search Publisher by Name
    @GetMapping("/search")
    public ResponseEntity<List<Publisher>> searchPublishers(@RequestParam String name) {
        return ResponseEntity.ok(publisherService.searchPublishersByName(name));
    }
}
