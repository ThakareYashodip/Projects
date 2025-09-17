package com.example.bookmart.service;

import com.example.bookmart.entity.Publisher;
import com.example.bookmart.repository.PublisherRepository;
import com.example.bookmart.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    @Override
    public Publisher updatePublisher(Long id, Publisher publisher) {
        Publisher existing = getPublisherById(id);
        existing.setName(publisher.getName());
        existing.setAddress(publisher.getAddress());
        return publisherRepository.save(existing);
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public List<Publisher> searchPublishersByName(String name) {
        return publisherRepository.findByNameContainingIgnoreCase(name);
    }
}
