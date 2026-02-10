package com.checkmattech.food.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fichaTecnica")
public class FichaTecnicaDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prato_id", nullable = false)
    private PratoDomain prato;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoDomain produto;

    @Column(nullable = false)
    private BigDecimal quantidadeUsada;

    public FichaTecnicaDomain(){}

    public FichaTecnicaDomain(PratoDomain prato, ProdutoDomain produto, BigDecimal quantidadeUsada){
        this.prato = prato;
        this.produto = produto;
        this.quantidadeUsada = quantidadeUsada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PratoDomain getPrato() {
        return prato;
    }

    public void setPrato(PratoDomain prato) {
        this.prato = prato;
    }

    public ProdutoDomain getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDomain produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(BigDecimal quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }
}
