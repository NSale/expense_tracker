package com.lesa.Expenses.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Unit unit;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    private enum Unit {
        pc, pcs, kg, g, m, mm, l
    }
}
