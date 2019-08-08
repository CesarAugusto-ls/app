package com.api.app.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.service.ProdutoService;

@RestController
public class ProdutoController extends ProdutoService{
	
	@GetMapping("/produto")
	public ModelMap consultaTodos() {
		return consultaTodosProdutosService();
	}

}
