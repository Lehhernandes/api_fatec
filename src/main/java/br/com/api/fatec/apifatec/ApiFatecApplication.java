package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
		return args -> {
			//Register initial product
			Produto produto = new Produto();
			produto.setDescricao("Batata frita");
			produto.setQuantidadeEstoque(10);
			produto.setPreco(9.99);
			produto.setAtivo(true);
			
			produtoRepository.save(produto);
			
			//Register initial client
			Cliente cliente = new Cliente();
			cliente.setNome("João neto");
			cliente.setEmail("netovitu@gmail.com");
			cliente.setEndereco("Rua Vereador Roque Motta, 319");
			cliente.setRazaoSocial("NETOVITU");
			
			clienteRepository.save(cliente);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}