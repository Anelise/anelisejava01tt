package com.target.loja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository repo;

    public ProdutoController(){


    }
    @GetMapping("/produto/{id}")
    public Produto getProduto(@PathVariable Long id){
        return repo.findById(id).get();
    }



    @PostMapping("/produto")
    public void addProduto(@RequestBody Produto p){
        repo.save(p);
    }

    @GetMapping("/produto/")
    public List<Produto> getProdutos(){
        return (List<Produto>)repo.findAll();
    }

    @PutMapping("/produto/{id}")
    public void upProduto(@PathVariable("id") long id,
                             @RequestBody Produto p){
         Produto p2 = repo.findById(id).get();

         p2.setNome(p.getNome());
        p2.setValor(p.getValor());
        repo.save(p2);

    }

    @DeleteMapping("/produto/{id}")
    public void delProduto(@PathVariable("id")long id){
        repo.deleteById(id);

    }

    @PostMapping("/produto/nome/")
    public List<Produto> getProdutosPorNome(@RequestBody String nome){
        return repo.findByNome(nome);
    }

    @GetMapping("/produto/valor")
    public List<Produto> getProdutosPorValor(@RequestParam Double v1, @RequestParam Double v2){
        return repo.findByValores(v1,v2);
    }
}
