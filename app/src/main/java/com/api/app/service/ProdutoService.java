package com.api.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.app.model.Produto;
import com.api.app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository prodR;
	
	public List<Produto> consultaTodosProdutosService() {
		
		return (List<Produto>) prodR.findAll();
	}
	
	public ResponseEntity<Produto> consultaID(Long id) {
		
		Optional<Produto> produto = prodR.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		
		return ResponseEntity.notFound().build();
	}

}
