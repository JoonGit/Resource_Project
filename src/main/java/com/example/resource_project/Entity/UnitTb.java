package com.example.resource_project.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UnitTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitIdPk;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String unitName;

    @Builder
    public UnitTb(String unitName) {
        this.unitName = unitName;
    }
}
