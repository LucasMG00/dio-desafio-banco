package contas;

import main.Banco;
import main.Cliente;

public class Corrente extends Conta {

	String tipo = "Corrente";
	
	public Corrente(Cliente cliente) {
		super(cliente);
		Banco.getContas().put(this.numero,tipo);
	}

	@Override
	public void extrato() {
		System.out.println(":: EXTRATO BANCARIO ::");
		System.out.println("Conta: CORRENTE");
		super.printExtrato();
	}
}