package com.catalisa.devmarket.controller;

import com.catalisa.devmarket.model.ProdutoModel;
import com.catalisa.devmarket.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody ProdutoModel produtoModel) {
        return ResponseEntity.ok(produtoService.cadastrar(produtoModel));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProdutoModel> buscarTodosProdutos(){
        return produtoService.buscarTodos();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ProdutoModel> buscarProdutoNome(@PathVariable String nome){
        ProdutoModel produto = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok(produto);
    }

}
