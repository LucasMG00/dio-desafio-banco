package contas;

import java.util.Random;
import lombok.*;
import main.Banco;
import main.Cliente;

public abstract class Conta implements interConta {

	private static int SEQUENCIA = 1;
	
	@Getter protected Cliente cliente;
	@Getter protected int agencia;
	@Getter protected int numero;
	@Getter protected Double saldo;
	
	public Conta(Cliente cliente) {
		Random random = new Random();
		int AGENCIA = random.nextInt(999+1 - 111)+111;
		
		this.cliente = cliente;
		this.agencia = AGENCIA;
		this.numero = SEQUENCIA++;
		this.saldo = 0d;	
	}
	
	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
	}
	
	public void printExtrato() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("------------------------\n");
	}
}