package br.com.api.fatec.apifatec.controllers;

import java.util.List;

import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/produtos/v1")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	/*Listar todos produtos cadastrados*/

	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		List<Produto> produtos = produtoService.listarProdutos();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

}
