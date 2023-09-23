package com.lesa.Expenses.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    private Double quantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    public enum Unit {
        PC, PCS, KG, G, M, MM, L
    }
}
