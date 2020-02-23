package com.api.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.model.Produto;
import com.api.app.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends ProdutoService{
	
	@GetMapping
	public List<Produto> consultaTodos() {
		return consultaTodosProdutosService();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultaPorID(@PathVariable Integer id) {
		return consultaID(id);
	}

}
