package com.api.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.api.app.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
