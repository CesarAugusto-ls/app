package com.api.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.api.app.model.Produto;
import com.api.app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository prodR;
	
	public ModelMap consultaTodosProdutosService() {
		ModelMap mp = new ModelMap();
		List<Produto> produto = (List<Produto>) prodR.findAll();
		mp.addAttribute(produto);
		return mp;
	}

}
