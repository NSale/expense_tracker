package com.lesa.Expenses.service;

import com.lesa.Expenses.dto.ProductDTO;
import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.entity.Product;
import com.lesa.Expenses.entity.Receipt;
import com.lesa.Expenses.mapper.ProductMapper;
import com.lesa.Expenses.mapper.ReceiptMapper;
import com.lesa.Expenses.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper, ProductService productService, ProductMapper productMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
        this.productService = productService;
        this.productMapper = productMapper;
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
    public ReceiptDTO saveReceipt(ReceiptDTO receipt, Set<Product> products) {
        Receipt savedReceipt = receiptRepository.save(receiptMapper.receiptDtoToReceipt(receipt));
        products.forEach(savedReceipt::addProduct);
        return receiptMapper.receiptToReceiptDto(savedReceipt);
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
