package com.catalisa.devmarket.service;

import com.catalisa.devmarket.model.ProdutoModel;
import com.catalisa.devmarket.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoModel cadastrar(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> buscarTodos(){
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarPorNome(String nome){
        return produtoRepository.findByNome(nome);
    }

}
