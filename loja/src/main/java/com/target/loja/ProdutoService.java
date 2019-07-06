package com.target.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repo;

    public ProdutoDTO getProdutoById(long id){
        Produto p = repo.findById(id).get();
        return new ProdutoDTO(p.getId(),p.getNome(),p.getValor());
    }
}
