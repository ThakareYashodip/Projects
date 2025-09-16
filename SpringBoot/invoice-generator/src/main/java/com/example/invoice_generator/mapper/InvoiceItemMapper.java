package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;

public class InvoiceItemMapper {
    
    public static InvoiceItemDTO invoiceItemToDTO(InvoiceItem invoiceItem){
        return new InvoiceItemDTO(
                invoiceItem.getId(),
                invoiceItem.getDescription(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitPrice()
        );
    }

    public static InvoiceItem invoiceItemDtoToEntity(InvoiceItemDTO dto, Invoice parentInvoice) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(dto.getId());
        invoiceItem.setDescription(dto.getDescription());
        invoiceItem.setQuantity(dto.getQuantity());
        invoiceItem.setUnitPrice(dto.getPrice());
        invoiceItem.setLineTotal(dto.getPrice() * dto.getQuantity());
        invoiceItem.setInvoice(parentInvoice); // ✅ set back-reference
        return invoiceItem;
    }

}
