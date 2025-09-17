package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.entity.Client;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.mapper.InvoiceItemMapper;
import com.example.invoice_generator.mapper.InvoiceMapper;
import com.example.invoice_generator.repository.ClientRepository;
import com.example.invoice_generator.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        // Step 1: Fetch client
        Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found!"));
        // Step 2: Map DTO -> Entity
        Invoice invoice = InvoiceMapper.invoiceDtoToEntity(invoiceDTO, client);
        // Step 3: Save and return DTO
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return InvoiceMapper.invoiceToDTO(savedInvoice);
    }


    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .map(InvoiceMapper::invoiceToDTO)
                .orElseThrow(()-> new RuntimeException("Invoice not found!"));
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream().map(InvoiceMapper::invoiceToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        Invoice existedInvoice = invoiceRepository.findById(id).orElseThrow(()-> new RuntimeException("Invoice not found !"));

        existedInvoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        existedInvoice.setDate(invoiceDTO.getInvoiceDate());
        existedInvoice.setDueDate(invoiceDTO.getInvoiceDate().plusDays(30));
        existedInvoice.setTotalAmount(invoiceDTO.getTotal());

        // Map items again if provided
        if (invoiceDTO.getItems() != null && !invoiceDTO.getItems().isEmpty()) {
            existedInvoice.setItems(
                    invoiceDTO.getItems().stream()
                            .map(itemDto ->
                                    InvoiceItemMapper
                                            .toEntity(itemDto, existedInvoice))
                            .collect(Collectors.toList())
            );
        }

        return InvoiceMapper.invoiceToDTO(invoiceRepository.save(existedInvoice));
    }

    @Override
    public void deleteInvoice(Long id) {
        if(!invoiceRepository.existsById(id)){
            throw new RuntimeException("Invoice not found !");
        }
        invoiceRepository.deleteById(id);
    }
}
