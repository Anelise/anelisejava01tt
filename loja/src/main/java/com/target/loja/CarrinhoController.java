package com.target.loja;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value="CarrinhoController",description="Permite gerenciar carrinho, que é relacionado com uma lista de produtos ")
@RestController
public class CarrinhoController {
    @Autowired
    CarrinhoRepository repo;

    @Autowired
    ProdutoRepository repoProd;

    @PostMapping("/carrinho")
    public void addProduto(@RequestBody Carrinho c){
        List<Produto> lista = new ArrayList<>();

        for(int i=0;i<c.getProdutos().size();i++){

            Produto p = repoProd.findById(c.getProdutos().get(i).getId()).get();
            lista.add(p);

        }
        c.setProdutos(lista);
        repo.save(c);
    }

    @GetMapping("/carrinho")
    public List<Carrinho> getCarrinhos(){
        return (List<Carrinho>)repo.findAll();
    }
}
