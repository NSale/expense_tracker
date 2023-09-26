package com.lesa.Expenses.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @NotNull
    private String shopName;
    private LocalDateTime receiptDate;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public enum Currency {
        DIN, EUR
    }
}
