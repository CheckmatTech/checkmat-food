package com.checkmattech.food.service;

import com.checkmattech.food.domain.*;
import com.checkmattech.food.repository.FichaTecnicaRepository;
import com.checkmattech.food.repository.PratoRepository;
import com.checkmattech.food.repository.ProdutoRepository;
import com.checkmattech.food.exception.ResourceNotFoundException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PratoService {
    private PratoRepository pratoRepo;
    private ProdutoRepository produtoRepo;
    private FichaTecnicaRepository fichaTecnicaRepo;

    public PratoService(PratoService pratoService, ProdutoService produtoService, FichaTecnicaRepository fichaTecnicaRepo) {
        this.pratoRepo = pratoRepo;
        this.produtoRepo = produtoRepo;
        this.fichaTecnicaRepo = fichaTecnicaRepo;
    }

    public PratoDomain criarPrato(PratoDomain prato){
        return pratoRepo.save(prato);
    }

    public PratoDomain buscarPortID(Long Id){
        return pratoRepo.findById(Id)
                .orElseThrow(() -> new RememberMeAuthenticationException("Prato não encontrado: " + Id));

    }

    @Transactional
    public FichaTecnicaDomain adicionarItemFicha(Long pratoId, Long produtoId, BigDecimal qtdUsada){
        PratoDomain prato = buscarPortID(pratoId);
        ProdutoDomain produto = produtoRepo.findById(pratoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não Encontrado: " + pratoId));
        FichaTecnicaDomain ficha = new FichaTecnicaDomain(prato, produto, qtdUsada);

        return fichaTecnicaRepo.save(ficha);
    }

    public List<FichaTecnicaDomain> listarFichaDoPrato(Long PratoID){
        return fichaTecnicaRepo.findByPratoId(PratoID);
    }

    public BigDecimal calcularCustoDoPrato(Long PratoID) {
        List<FichaTecnicaDomain> itens = fichaTecnicaRepo.findByPratoId(PratoID);
        BigDecimal total = BigDecimal.ZERO;
        for (FichaTecnicaDomain ficha : itens) {
        }
        return total;
    }


}