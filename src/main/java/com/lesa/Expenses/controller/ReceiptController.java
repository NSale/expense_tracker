package com.lesa.Expenses.controller;

import com.lesa.Expenses.dto.ReceiptDTO;
import com.lesa.Expenses.service.ProductService;
import com.lesa.Expenses.service.ReceiptService;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;
    private final ProductService productService;

    public ReceiptController(ReceiptService receiptService, ProductService productService) {
        this.receiptService = receiptService;
        this.productService = productService;
    }

    @GetMapping
    public List<ReceiptDTO> getReceipts() {
        return receiptService.getReceipts();
    }

    @GetMapping("{receipt_id}")
    public ReceiptDTO getReceiptById(@PathVariable Long receipt_id) {
        return receiptService.getReceipt(receipt_id);
    }

    @PostMapping()
    public HttpEntity<ReceiptDTO> createReceipt(@Validated @RequestBody ReceiptDTO receipt) {
        receipt.products()
                .forEach(productService::saveProduct);
        return new HttpEntity<>(receiptService.saveReceipt(receipt));
    }

    @PutMapping("{receipt_id}")
    public HttpEntity<ReceiptDTO> updateReceipt(@Validated @RequestBody ReceiptDTO receipt, @PathVariable Long receipt_id) {
        receipt.products().stream()
                .filter(p -> productService.findProductById(p.getId()) !=null)
                .forEach(productService::saveProduct);
        return new HttpEntity<>(receiptService.updateReceipt(receipt_id, receipt));
    }

    @DeleteMapping("{receipt_id}")
    public void deleteReceipt(@PathVariable Long receipt_id) {
        receiptService.deleteReceipt(receipt_id);
    }
}
