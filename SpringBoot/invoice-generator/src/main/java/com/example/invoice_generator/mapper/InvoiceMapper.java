package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Client;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceMapper {

    // Convert Entity -> DTO
    public static InvoiceDTO invoiceToDTO(Invoice invoice) {
        List<InvoiceItemDTO> itemDTOs = invoice.getItems()
                .stream()
                .map(InvoiceItemMapper::toDTO)
                .collect(Collectors.toList());

        return new InvoiceDTO(
                invoice.getId(),
                invoice.getInvoiceNumber(),
                invoice.getDate(),
                invoice.getClient().getId(),
                itemDTOs,
                invoice.getTotalAmount()
        );
    }

    // Convert DTO -> Entity
    public static Invoice invoiceDtoToEntity(InvoiceDTO dto, Client client) {
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setInvoiceNumber(dto.getInvoiceNumber());
        invoice.setDate(dto.getInvoiceDate());
        invoice.setDueDate(dto.getInvoiceDate().plusDays(30)); // Example: due 30 days later
        invoice.setTotalAmount(dto.getTotal());
        invoice.setStatus("DRAFT"); // default status
        invoice.setClient(client);

        // map items and set back-reference
        List<InvoiceItem> items = dto.getItems()
                .stream()
                .map(itemDto -> InvoiceItemMapper.toEntity(itemDto, invoice))
                .collect(Collectors.toList());

        invoice.setItems(items);

        return invoice;
    }


}
