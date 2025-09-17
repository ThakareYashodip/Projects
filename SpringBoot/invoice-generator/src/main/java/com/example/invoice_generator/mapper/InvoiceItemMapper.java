package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;

public class InvoiceItemMapper {

    public static InvoiceItemDTO toDTO(InvoiceItem invoiceItem) {
        return InvoiceItemDTO.builder()
                .id(invoiceItem.getId())
                .description(invoiceItem.getDescription())
                .quantity(invoiceItem.getQuantity())
                .unitPrice(invoiceItem.getUnitPrice())
                .subtotal(invoiceItem.getSubtotal())
                .invoiceId(invoiceItem.getInvoice().getId())
                .build();
    }

    public static InvoiceItem toEntity(InvoiceItemDTO dto, Invoice parentInvoice) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(dto.getId());
        invoiceItem.setDescription(dto.getDescription());
        invoiceItem.setQuantity(dto.getQuantity());

        // ✅ Use correct field name (unitPrice, not price)
        Double unitPrice = dto.getUnitPrice();
        if (unitPrice == null) {
            throw new IllegalArgumentException("Unit price cannot be null for InvoiceItem");
        }
        invoiceItem.setUnitPrice(unitPrice);

        // ✅ subtotal = unitPrice * quantity (handle null safely)
        invoiceItem.setSubtotal(
                (dto.getQuantity() != null ? dto.getQuantity() : 0) *
                        unitPrice
        );

        invoiceItem.setInvoice(parentInvoice); // back-reference
        return invoiceItem;
    }
}
