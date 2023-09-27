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
    private final ProductService productService;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ProductService productService) {
        this.receiptRepository = receiptRepository;
        this.productService = productService;
    }

    @Override
    public List<ReceiptDTO> getReceipts() {
        return receiptRepository.findAll().stream().map(ReceiptMapper.mapper::receiptToReceiptDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptDTO getReceipt(Long id) {
        if(receiptRepository.findById(id).isPresent()) {
            return ReceiptMapper.mapper.receiptToReceiptDto(receiptRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public ReceiptDTO saveReceipt(ReceiptDTO receipt) {
        return ReceiptMapper.mapper.receiptToReceiptDto(receiptRepository.save(ReceiptMapper.mapper.receiptDtoToReceipt(receipt)));
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
            return ReceiptMapper.mapper.receiptToReceiptDto(existingReceipt.get());
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
