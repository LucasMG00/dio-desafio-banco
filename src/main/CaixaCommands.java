package main;

import javax.swing.JOptionPane;

import contas.Conta;
import contas.Corrente;
import contas.Poupanca;

public class CaixaCommands {
	
	String s, v, cliNome, cliCPF;
	Double z;
	Cliente c;
	Conta cc,cp;

public void criarCliente() {
		
		cliNome = JOptionPane.showInputDialog(null,"Digite o nome do cliente","Caixa Eletronica",JOptionPane.PLAIN_MESSAGE);
		cliCPF = JOptionPane.showInputDialog(null,"Digite o CPF do cliente","Caixa Eletronica",JOptionPane.PLAIN_MESSAGE);
		
		c = new Cliente(cliNome, cliCPF);
	}

public void criarCorrente() {
	
	cc = new Corrente(c);
	JOptionPane.showMessageDialog(null, "Conta Corrente criada com sucesso!","Caixa Eletronico",JOptionPane.PLAIN_MESSAGE);
	System.out.println("Conta Corrente criada com sucesso!");
}

public void criarPoupanca() {
	
	cp = new Poupanca(c);
	JOptionPane.showMessageDialog(null, "Conta Poupança criada com sucesso!","Caixa Eletronico",JOptionPane.PLAIN_MESSAGE);
	System.out.println("Conta Poupança criada com sucesso!");
}

public void sacar() {
	
	do {
		
		v = JOptionPane.showInputDialog(null,""
				+ "Deseja sacar da conta poupança ou corrente?\n"
				+ "[1] Corrente\n[2] Poupança\n[0] Voltar",
				"Caixa Eletronico", JOptionPane.INFORMATION_MESSAGE);
		
		switch (v) {
		case "1": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser sacado","Caixa Eletronico | Sacar",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			if(cc.getSaldo() > z) {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente! Saldo atual: "+cc.getSaldo(),"ERRO",JOptionPane.ERROR_MESSAGE);
			break;
			}else {
			cc.sacar(z);
			break;
			}
			}
		case "2": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser sacado","Caixa Eletronico | Sacar",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			if(cp.getSaldo() > z) {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente!Saldo atual: "+cp.getSaldo(),"ERRO",JOptionPane.ERROR_MESSAGE);
			break;
			}else {
			cp.sacar(z);
			break;
			}
			}
		}
	}while(!v.equals("0"));	
}

public void depositar() {
	
do {
		
		v = JOptionPane.showInputDialog(null,""
				+ "Deseja depositar pela conta poupança ou corrente?\n"
				+ "[1] Corrente\n[2] Poupança\n[0] Voltar",
				"Caixa Eletronico | Depositar", JOptionPane.INFORMATION_MESSAGE);
		
		switch (v) {
		case "1": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico | Depositar",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			cc.depositar(z);
			break;
			}
		case "2": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico | Depositar",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			cp.depositar(z);
			break;
			}
		}
	}while(!v.equals("0"));
}

public void transferir() {
	
}

public void imprimirExtrato() {
do {
		
		v = JOptionPane.showInputDialog(null,""
				+ "Deseja imprimir extrato pela conta poupança ou corrente?\n"
				+ "[1] Corrente\n[2] Poupança\n[0] Voltar",
				"Caixa Eletronico | Extrato", JOptionPane.INFORMATION_MESSAGE);
		
		switch (v) {
		case "1": {
			cc.extrato();
			JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!","",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		case "2": {
			cp.extrato();
			JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!","",JOptionPane.PLAIN_MESSAGE);
			break;
			}
		}
	}while(!v.equals("0"));
}

public void listaClientes() {
	
	JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!","Caixa Eletronico | Clientes",JOptionPane.PLAIN_MESSAGE);
	System.out.println(Banco.getClientes());
	
}

public void listaContas() {
	
	JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!","Caixa Eletronico | Contas",JOptionPane.PLAIN_MESSAGE);
	System.out.println(Banco.listaDeContas(Banco.getContas())+"\n");
	
}
}
