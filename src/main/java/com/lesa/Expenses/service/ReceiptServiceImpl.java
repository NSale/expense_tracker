package com.lesa.Expenses.service;

import com.lesa.Expenses.dtos.ReceiptDTO;
import com.lesa.Expenses.entities.Receipt;
import com.lesa.Expenses.mappers.ReceiptMapper;
import com.lesa.Expenses.repository.ProductRepository;
import com.lesa.Expenses.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;
    private final ProductService productService;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper, ProductService productService) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
        this.productService = productService;
    }

    @Override
    public List<ReceiptDTO> getReceipts() {
        return receiptRepository.findAll().stream().map(receiptMapper::receiptToReceiptDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptDTO getReceipt(Long id) {
        if(receiptRepository.findById(id).isPresent()) {
            return receiptMapper.receiptToReceiptDto(receiptRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public ReceiptDTO saveReceipt(ReceiptDTO receipt) {
        ReceiptDTO savedReceipt = receiptMapper.receiptToReceiptDto(receiptRepository.save(receiptMapper.receiptDtoToReceipt(receipt)));
        receipt.products().forEach(p -> productService.addProductToReceipt(savedReceipt, p));
        return savedReceipt;
    }

    @Override
    public ReceiptDTO updateReceipt(Long receipt_id, ReceiptDTO receipt) {
        if(receiptRepository.existsById(receipt_id)) {
            Optional<Receipt> existingReceipt = receiptRepository.findById(receipt_id);
            existingReceipt.get().setShopName(receipt.shopName());
            existingReceipt.get().setReceiptDate(receipt.receiptDate());
            existingReceipt.get().setPrice(receipt.price());
            existingReceipt.get().setCurrency(receipt.currency());
            existingReceipt.get().setProducts(receipt.products());
            receiptRepository.save(existingReceipt.get());
            return receiptMapper.receiptToReceiptDto(existingReceipt.get());
        }
        return null;
    }

    @Override
    public void deleteReceipt(Long id) {
        if(receiptRepository.existsById(id)) {
            receiptRepository.deleteById(id);
        }
    }
}
