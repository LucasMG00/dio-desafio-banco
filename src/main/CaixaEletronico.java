package main;

import contas.*;

//import Teste.*;

public class CaixaEletronico {

public static void main(String[] args) {
	
	//Comandos dentro da classe de teste;
	//Empolguei um pouco e acabei fazendo mais do que tenho tempo para terminar;
	//Pretendo finalizar esse projeto no futuro, não ficará imcompleto.
/*		CaixaUI cx = new CaixaUI();
		cx.startup();
		
		System.out.println("Sessão finalizada com sucesso!");  */
	
	//Cria clientes c1 e c2
	Cliente c1 = new Cliente("Lucas", "1234567890");
	Cliente c2 = new Cliente("sacuL", "0987654321");
	
	//Cliente c1 abre uma conta corrente e c2 uma poupança
	Conta ccc1 = new Corrente(c1);
	Conta cpc2 = new Poupanca(c2);
	
	//Clientes depositam valores Double em suas Conta.getSaldo()
	ccc1.depositar(700);
	cpc2.depositar(1200);
	
	//c1 e c2 sacam valores de suas contas corrente(cc) e poupança(cp) respectivamente
	ccc1.sacar(200);
	cpc2.sacar(375.50);
	
	//Conta corrente transfere 400 para conta poupança
	ccc1.transferir(400, cpc2);
	
	//Cliente 1 (c1) abre uma conta poupança
	Conta cpc1 = new Poupanca(c1);
	
	//Extrato bancario de c1 em ambas as contas
	ccc1.extrato();
	cpc1.extrato();
	
	//Extrato bancario de c2
	cpc2.extrato();
	
	}
}