package contas;

import main.Banco;
import main.Cliente;

public class Poupanca extends Conta {

	String tipo = "Poupança";
	
	public Poupanca(Cliente cliente) {
		super(cliente);
		Banco.getContas().put(this.numero,tipo);
	}

	@Override
	public void extrato() {
		System.out.println(":: EXTRATO BANCARIO ::");
		System.out.println("Conta: POUPANÇA");
		super.printExtrato();
	}
}