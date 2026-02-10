package com.checkmattech.food.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "protudos")
public class ProdutoDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Integer unidade;

    private BigDecimal estoqueAtual = BigDecimal.ZERO;

    private BigDecimal estoqueMinimo = BigDecimal.ZERO;

    public ProdutoDomain() {}

    public void Produto(String nome, Integer unidade, BigDecimal estoqueAtual, BigDecimal estoqueMinimo){
        this.nome = nome;
        this.unidade = unidade;
        this.estoqueAtual = estoqueAtual != null ? estoqueAtual : BigDecimal.ZERO;
        this.estoqueMinimo = estoqueMinimo != null  ? estoqueMinimo : BigDecimal.ZERO;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public Integer getUnidade(){
        return unidade;
    }

    public void setUnidade(){
        this.unidade = unidade;
    }

    public BigDecimal getEstoqueAtual(){
        return estoqueAtual;
    }

    public void setEstoqueAtual(BigDecimal zero){
        this.estoqueAtual = estoqueAtual;
    }

    public  BigDecimal getEstoqueMinimo(){
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }


    public void adicionarEstoque(BigDecimal quantidade){
        if(quantidade == null) return;
        this.estoqueAtual = this.estoqueAtual.add(quantidade);
    }

    public void removerEstoque(BigDecimal quantidade){
        if(quantidade == null) return;
        this.estoqueAtual = this.estoqueAtual.subtract(quantidade);
    }
}
