package com.lesa.Expenses.controller;

import com.lesa.Expenses.domain.Receipt;
import com.lesa.Expenses.service.ReceiptService;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<Receipt> getReceipts() {
        return receiptService.getReceipts();
    }

    @GetMapping("receipt/{receipt_id}")
    public Optional<Receipt> getReceiptById(@PathVariable Long receipt_id) {
        return receiptService.getReceipt(receipt_id);
    }

    @PostMapping("receipt")
    public HttpEntity<Receipt> createReceipt(@Validated @RequestBody Receipt receipt) {
        return new HttpEntity<>(receiptService.saveReceipt(receipt));
    }

    @PutMapping("receipt/{receipt_id}")
    public HttpEntity<Optional<Receipt>> updateReceipt(@Validated @RequestBody Receipt receipt, @PathVariable Long receipt_id) {
        return new HttpEntity<>(receiptService.updateReceipt(receipt_id, receipt));
    }

    @DeleteMapping("receipt/{receipt_id}")
    public void deleteReceipt(@PathVariable Long receipt_id) {
        receiptService.deleteReceipt(receipt_id);
    }
}
