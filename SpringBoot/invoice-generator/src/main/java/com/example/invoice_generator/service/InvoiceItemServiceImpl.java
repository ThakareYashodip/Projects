package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;
import com.example.invoice_generator.mapper.InvoiceItemMapper;
import com.example.invoice_generator.mapper.InvoiceMapper;
import com.example.invoice_generator.repository.InvoiceItemRepository;
import com.example.invoice_generator.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service @RequiredArgsConstructor
public class InvoiceItemServiceImpl implements InvoiceItemService{

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceItemDTO addInvoiceItem(Long invoiceId,InvoiceItemDTO invoiceItemDTO) {

        Invoice parent  = invoiceRepository.findById(invoiceId).orElseThrow(()-> new RuntimeException("Invoice not found !"));

        InvoiceItem invoiceItem = InvoiceItemMapper.invoiceItemDtoToEntity(invoiceItemDTO,parent);

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        return InvoiceItemMapper.invoiceItemToDTO(invoiceItem);
    }

    @Override
    public InvoiceItemDTO getInvoiceItemById(Long id) {
        InvoiceItem invoiceItem = invoiceItemRepository
                .findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Invoice Item not found ! ")
                );
        return InvoiceItemMapper.invoiceItemToDTO(invoiceItem);
    }

    @Override
    public List<InvoiceItemDTO> getAllItems() {
        return invoiceItemRepository
                .findAll()
                .stream()
                .map(InvoiceItemMapper::invoiceItemToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceItemDTO updateInvoiceById(Long id, InvoiceItemDTO invoiceItemDTO) {
        InvoiceItem existing = invoiceItemRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Invalid Invoice Item Id !"));
        existing.setQuantity(invoiceItemDTO.getQuantity());
        existing.setUnitPrice(invoiceItemDTO.getPrice());
        existing.setDescription(invoiceItemDTO.getDescription());
        existing.setId(invoiceItemDTO.getId());
        return InvoiceItemMapper.invoiceItemToDTO(existing);
    }

    @Override
    public void deleteItemById(Long id) {
        if(!invoiceItemRepository.existsById(id)){
            throw new RuntimeException("Invalid/Not found Id !");
        }
        invoiceItemRepository.deleteById(id);
    }
}
