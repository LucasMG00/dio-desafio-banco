package main;

import javax.swing.JOptionPane;

import contas.*;

public class CaixaCommands {
	
	String input, cliNome, cliCPF;
	Double valor;
	Cliente cliente;
	Conta corrente,poupanca;

public void criarCliente() {
		
		cliNome = JOptionPane.showInputDialog(null,"Digite o nome do cliente","Caixa Eletronica",JOptionPane.PLAIN_MESSAGE);
		cliCPF = JOptionPane.showInputDialog(null,"Digite o CPF do cliente","Caixa Eletronica",JOptionPane.PLAIN_MESSAGE);
		
		cliente = new Cliente(cliNome, cliCPF);
	}

public void criarCorrente() {
	
	corrente = new Corrente(cliente);
	JOptionPane.showMessageDialog(null, "Conta Corrente criada com sucesso!","Caixa Eletronico",JOptionPane.PLAIN_MESSAGE);
	System.out.println("Conta Corrente criada com sucesso!");
}

public void criarPoupanca() {
	
	poupanca = new Poupanca(cliente);
	JOptionPane.showMessageDialog(null, "Conta Poupan?a criada com sucesso!","Caixa Eletronico",JOptionPane.PLAIN_MESSAGE);
	System.out.println("Conta Poupan?a criada com sucesso!");
}

public void sacar() {
	
	do {
		
		input = JOptionPane.showInputDialog(null,""
				+ "Deseja sacar da conta poupan?a ou corrente?\n"
				+ "[1] Corrente\n[2] Poupan?a\n[0] Voltar",
				"Caixa Eletronico", JOptionPane.INFORMATION_MESSAGE);
		
		switch (input) {
		case "1": {
			input = JOptionPane.showInputDialog(null,"Qual valor a ser sacado?","Caixa Eletronico | Sacar",JOptionPane.QUESTION_MESSAGE);
			valor = Double.parseDouble(input);
			if(corrente.getSaldo() < valor) {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente!\nSaldo atual: "+corrente.getSaldo(),"ERRO",JOptionPane.ERROR_MESSAGE);
			break;
			}else {
			corrente.sacar(valor);
			JOptionPane.showMessageDialog(null, "Saque feito com sucesso!\nSaldo atual: "+corrente.getSaldo(),"Caixa Eletronico | Saque",JOptionPane.PLAIN_MESSAGE);
			break;
			}
			}
		case "2": {
			input = JOptionPane.showInputDialog(null,"Qual valor a ser sacado?","Caixa Eletronico | Sacar",JOptionPane.QUESTION_MESSAGE);
			valor = Double.parseDouble(input);
			if(poupanca.getSaldo() < valor) {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente!\nSaldo atual: "+poupanca.getSaldo(),"ERRO",JOptionPane.ERROR_MESSAGE);
			break;
			}else {
			poupanca.sacar(valor);
			JOptionPane.showMessageDialog(null, "Saque feito com sucesso!\nSaldo atual: "+poupanca.getSaldo(),"Caixa Eletronico | Saque",JOptionPane.PLAIN_MESSAGE);
			break;
			}
			}
		}
	}while(!input.equals("0"));	
}

public void depositar() {
	
do {
		
		input = JOptionPane.showInputDialog(null,""
				+ "Deseja depositar pela conta poupan?a ou corrente?\n"
				+ "[1] Corrente\n[2] Poupan?a\n[0] Voltar",
				"Caixa Eletronico | Depositar", JOptionPane.INFORMATION_MESSAGE);
		
		switch (input) {
		case "1": {
			input = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico | Depositar",JOptionPane.QUESTION_MESSAGE);
			valor = Double.parseDouble(input);
			corrente.depositar(valor);
			JOptionPane.showMessageDialog(null, "Dep?sito feito com sucesso!\nSaldo atual: "+corrente.getSaldo(),"Caixa Eletronico | Depositar",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		case "2": {
			input = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico | Depositar",JOptionPane.QUESTION_MESSAGE);
			valor = Double.parseDouble(input);
			poupanca.depositar(valor);
			JOptionPane.showMessageDialog(null, "Dep?sito feito com sucesso!\nSaldo atual: "+poupanca.getSaldo(),"Caixa Eletronico | Depositar",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		}
	}while(!input.equals("0"));
}

public void transferir() {
	
	JOptionPane.showMessageDialog(null, "Fun??o indispon?vel no momento","Caixa Eletronico",JOptionPane.ERROR_MESSAGE);

}

public void imprimirExtrato() {
do {
		
		input = JOptionPane.showInputDialog(null,""
				+ "Deseja imprimir extrato pela conta poupan?a ou corrente?\n"
				+ "[1] Corrente\n[2] Poupan?a\n[0] Voltar",
				"Caixa Eletronico | Extrato", JOptionPane.INFORMATION_MESSAGE);
		
		switch (input) {
		case "1": {
			corrente.extrato();
			JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!","Caixa Eletronico | Extrato",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		case "2": {
			poupanca.extrato();
			JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!","Caixa Eletronico | Extrato",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		}
	}while(!input.equals("0"));
}

public void listaClientes() {
	
	System.out.println("::Lista de Clientes::\n"+Banco.getClientes());
	JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!","Caixa Eletronico | Clientes",JOptionPane.PLAIN_MESSAGE);
	
}

public void listaContas() {
	
	System.out.println("::Lista de Contas::\n"+Banco.listaDeContas(Banco.getContas()));
	JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!","Caixa Eletronico | Contas",JOptionPane.PLAIN_MESSAGE);
	
}
}
