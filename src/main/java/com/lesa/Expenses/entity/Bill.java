package com.lesa.Expenses.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime billDate;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        INFO, ELECTRICITY, CELL_PHONE, CABLE, KINDER_GARDEN
    }
}
