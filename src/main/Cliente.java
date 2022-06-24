package main;

import lombok.*;

public class Cliente {

	@Getter @Setter private String nome;
	@Getter @Setter private String cpf;
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		
		Banco.getClientes().add(this.nome);
	}
}