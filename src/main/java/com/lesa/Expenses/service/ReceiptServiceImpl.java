package com.lesa.Expenses.service;

import com.lesa.Expenses.domain.Receipt;
import com.lesa.Expenses.repository.ProductRepository;
import com.lesa.Expenses.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ProductRepository productRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ProductRepository productRepository) {
        this.receiptRepository = receiptRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Receipt> getReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public Optional<Receipt> getReceipt(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public Receipt saveReceipt(Receipt receipt) {
        if(receipt.getProducts() != null) {
            receipt.getProducts().stream()
                    .filter(p -> !productRepository.existsByName(p.getName()))
                    .forEach(productRepository::save);
        }
        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> updateReceipt(Long receipt_id, Receipt receipt) {
        if(receiptRepository.existsById(receipt_id)) {
            Optional<Receipt> existingReceipt = receiptRepository.findById(receipt_id);
            if(existingReceipt.get().getProducts() != null) {
                existingReceipt.get().getProducts().stream()
                        .filter(p -> productRepository.findById(p.getId()).isPresent())
                        .forEach(productRepository::save);
            }
            existingReceipt.get().setShopName(receipt.getShopName());
            existingReceipt.get().setReceiptDate(receipt.getReceiptDate());
            existingReceipt.get().setPrice(receipt.getPrice());
            existingReceipt.get().setCurrency(receipt.getCurrency());
            existingReceipt.get().setProducts(receipt.getProducts());
            receiptRepository.save(existingReceipt.get());
            return existingReceipt;
        }
        return Optional.empty();
    }

    @Override
    public void deleteReceipt(Long id) {
        if(receiptRepository.existsById(id)) {
            receiptRepository.deleteById(id);
        }
    }
}
