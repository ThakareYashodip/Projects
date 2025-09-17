package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;
import com.example.invoice_generator.mapper.InvoiceItemMapper;
import com.example.invoice_generator.repository.InvoiceItemRepository;
import com.example.invoice_generator.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceRepository invoiceRepository;

    public InvoiceItemDTO createItem(Long invoiceId, InvoiceItemDTO dto) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        InvoiceItem item = InvoiceItemMapper.toEntity(dto, invoice);
        return InvoiceItemMapper.toDTO(invoiceItemRepository.save(item));
    }

    public List<InvoiceItemDTO> getItemsByInvoice(Long invoiceId) {
        return invoiceItemRepository.findByInvoiceId(invoiceId)
                .stream().map(InvoiceItemMapper::toDTO).collect(Collectors.toList());
    }

    public InvoiceItemDTO updateItem(Long itemId, InvoiceItemDTO dto) {
        InvoiceItem existing = invoiceItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        existing.setDescription(dto.getDescription());
        existing.setQuantity(dto.getQuantity());
        existing.setUnitPrice(dto.getUnitPrice());
        existing.setSubtotal(dto.getQuantity() * dto.getUnitPrice());

        return InvoiceItemMapper.toDTO(invoiceItemRepository.save(existing));
    }

    public void deleteItem(Long itemId) {
        invoiceItemRepository.deleteById(itemId);
    }
}
