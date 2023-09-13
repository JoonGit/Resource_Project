package com.example.resource_project.Entity;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Resource_tb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resource_id_pk;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String resourceKorName;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String resourceEngName;

    @NotNull
    @Column(columnDefinition = "varchar (10)")
    private String resourceSymbol;

    @Builder
    public Resource_tb(String resourceKorName, String resourceEngName, String resourceSymbol) {
        this.resourceKorName = resourceKorName;
        this.resourceEngName = resourceEngName;
        this.resourceSymbol = resourceSymbol;
    }
}
