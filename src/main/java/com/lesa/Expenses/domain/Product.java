package com.lesa.Expenses.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double quantity;
    private UNIT unit;
    private Double price;
    @ManyToOne
    private Receipt receipt;

    private enum UNIT {
        pc, pcs, kg, g, m, mm, l
    }
}
