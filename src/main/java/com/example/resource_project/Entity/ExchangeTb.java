package com.example.resource_project.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ExchangeTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int currentyIdPk;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    String currencyName;

    @NotNull
    @Column(columnDefinition = "varchar (10)")
    String currencySymbol;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    String country;

    @Builder
    public ExchangeTb(String currencyName,
                      String currencySymbol,
                      String country
                       ) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.country = country;
    }
}
