package com.example.bookmart.service;

import com.example.bookmart.entity.Publisher;
import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Long id);
    Publisher updatePublisher(Long id, Publisher publisher);
    void deletePublisher(Long id);
    List<Publisher> searchPublishersByName(String name);
}
