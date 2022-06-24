package contas;

public interface interConta {

	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, Conta destino);
	
	void extrato();
	
}