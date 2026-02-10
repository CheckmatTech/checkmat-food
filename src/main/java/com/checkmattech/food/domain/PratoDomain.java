package com.checkmattech.food.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pratos")
public class PratoDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal precoVenda;

    public PratoDomain() {}

    public void Prato(String nome, BigDecimal precoVenda){
        this.nome = nome;
        this.precoVenda = precoVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }


}
