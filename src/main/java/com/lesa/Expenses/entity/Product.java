package com.lesa.Expenses.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    private Double quantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receipt_id")
    @JsonBackReference
    private Receipt receipt;

    public enum Unit {
        PC, PCS, KG, G, M, MM, L
    }
}
