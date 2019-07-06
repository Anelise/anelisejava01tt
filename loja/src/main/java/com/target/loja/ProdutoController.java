package com.target.loja;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="ProdutoController",description="Permite gerenciar produtos")
@RestController
public class ProdutoController {

    @ApiOperation( value="Obtém produto por id", response=Produto.class, tags="getProduto" )
    @GetMapping("/produto/{id}")
    public Produto getProduto(@PathVariable Long id, ProdutoRepository repo){
        return new Produto();
    }


    @ApiOperation( value="Cria produto", tags="addProduto " )
    @PostMapping("/produto")
    public void addProduto(@RequestBody Produto p, ProdutoRepository repo){
        repo.save(p);
    }

    @ApiOperation( value="Obtém a lista de produtos", response=Iterable.class, tags="getProdutos")
    @GetMapping("/produto/")
    public List<Produto> getProdutos(ProdutoRepository repo){
        return (List<Produto>)repo.findAll();
    }

    @ApiOperation( value="Atualiza produto", tags="upProduto")
    @PutMapping("/produto/{id}")
    public void upProduto(@PathVariable("id") long id,
                             @RequestBody Produto p, ProdutoRepository repo){
         Produto p2 = repo.findById(id).get();

         p2.setNome(p.getNome());
        p2.setValor(p.getValor());
        repo.save(p2);

    }

    @DeleteMapping("/produto/{id}")
    public void delProduto(@PathVariable("id")long id,ProdutoRepository repo){
        repo.deleteById(id);

    }

    @PostMapping("/produto/nome/")
    public List<Produto> getProdutosPorNome(@RequestBody String nome, ProdutoRepository repo){
        return repo.findByNome(nome);
    }

    @GetMapping("/produto/valor")
    public List<Produto> getProdutosPorValor(@RequestParam Double v1, @RequestParam Double v2,ProdutoRepository repo){
        return repo.findByValores(v1,v2);
    }
}
