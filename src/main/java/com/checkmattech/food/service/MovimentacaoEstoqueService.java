package com.checkmattech.food.service;

import com.checkmattech.food.repository.MovimentacaoEstoqueRepository;
import com.checkmattech.food.domain.*;
import com.checkmattech.food.exception.ResourceNotFoundException;
import com.checkmattech.food.repository.ProdutoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;


@Service
public class MovimentacaoEstoqueService {
    private final MovimentacaoEstoqueRepository movRepo;
    private final ProdutoRepository produtoRepo;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movRepo, ProdutoRepository produtoRepo) {
        this.movRepo = movRepo;
        this.produtoRepo = produtoRepo;
    }

    public List<MovimentacaoEstoqueDomain> listarPorProduto(Long produtoID){
        return movRepo.findByProdutoIdOrderByDataMovimentoDesc(produtoID);
    }

    @Transactional
    public MovimentacaoEstoqueDomain ajustarEntrada(Long produtoID, BigDecimal quantidade, String observacao){
        ProdutoDomain produto = produtoRepo.findById(produtoID)
                .orElseThrow(() -> new ResourceNotFoundException("Protudo não encontrado"));

        produto.adicionarEstoque(quantidade);
        produtoRepo.save(produto);
        MovimentacaoEstoqueDomain mov = new MovimentacaoEstoqueDomain(produto, quantidade, TipoMovimentoDomain.Entrada, observacao);
        return movRepo.save(mov);
    }

    @Transactional
    public MovimentacaoEstoqueDomain ajustarSaida(Long produtoID, BigDecimal quantidade, String observacao){
        ProdutoDomain protudo = produtoRepo.findById(produtoID)
                .orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado: " + produtoID));
        if(protudo.getEstoqueAtual().compareTo(quantidade) < 0 )
            throw new IllegalArgumentException("Quantidade insuficiente");
        protudo.removerEstoque(quantidade);
        produtoRepo.save(protudo);
        MovimentacaoEstoqueDomain mov = new MovimentacaoEstoqueDomain(protudo, quantidade, TipoMovimentoDomain.Sainda, observacao);
        return movRepo.save(mov);
    }


}
