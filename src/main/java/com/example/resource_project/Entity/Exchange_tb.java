package com.example.resource_project.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Exchange_tb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int currenty_id_pk;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    String currency_name;

    @NotNull
    @Column(columnDefinition = "varchar (10)")
    String currency_symbol;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    String country;

    @Builder
    public Exchange_tb(String currency_name,
                       String currency_symbol,
                       String country
                       ) {
        this.currency_name = currency_name;
        this.currency_symbol = currency_symbol;
        this.country = country;
    }
}
