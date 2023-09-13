package com.example.resource_project.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Unit_tb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitIdPk;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String unitName;

    @Builder
    public Unit_tb(int unitIdPk, String unitName) {
        this.unitIdPk = unitIdPk;
        this.unitName = unitName;
    }
}
