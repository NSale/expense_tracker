package com.lesa.Expenses.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shopName;
    private LocalDateTime receiptDate;
    private Double price;
    private Currency currency;
    @OneToMany(mappedBy = "receipt")
    private List<Product> products;

    public enum Currency {
        DIN, EUR
    }
}
