package com.target.loja;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    public List<Produto> findByNome(String nome);

    @Query("select p from Produto p where p.valor >= :v1 and p.valor <= :v2")
    List<Produto> findByValores(@Param("v1") Double v1,@Param("v2") Double v2);

}
