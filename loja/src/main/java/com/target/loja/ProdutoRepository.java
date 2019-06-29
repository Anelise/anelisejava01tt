package com.target.loja;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    public List<Produto> findByNome(String nome);

}
