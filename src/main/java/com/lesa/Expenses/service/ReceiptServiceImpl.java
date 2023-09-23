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
    private final ProductRepository productRepository;
    private final ReceiptMapper receiptMapper;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ProductRepository productRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.productRepository = productRepository;
        this.receiptMapper = receiptMapper;
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
        if(receipt.products() != null) {
            receipt.products().stream()
                    .filter(p -> !productRepository.existsByName(p.getName()))
                    .forEach(productRepository::save);
        }
        return receiptMapper.receiptToReceiptDto(receiptRepository.save(receiptMapper.receiptDtoToReceipt(receipt)));
    }

    @Override
    public ReceiptDTO updateReceipt(Long receipt_id, ReceiptDTO receipt) {
        if(receiptRepository.existsById(receipt_id)) {
            Optional<Receipt> existingReceipt = receiptRepository.findById(receipt_id);
            if(existingReceipt.get().getProducts() != null) {
                existingReceipt.get().getProducts().stream()
                        .filter(p -> productRepository.findById(p.getId()).isPresent())
                        .forEach(productRepository::save);
            }
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
