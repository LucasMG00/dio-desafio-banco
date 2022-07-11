package main;

import lombok.*;

@Getter @Setter
public class Cliente {

	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		
		Banco.getClientes().add(this.nome);
	}
}