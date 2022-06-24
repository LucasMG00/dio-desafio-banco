package Teste;

import javax.swing.JOptionPane;

import contas.Conta;
import contas.Corrente;
import contas.Poupanca;
import main.Cliente;

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
			v = JOptionPane.showInputDialog(null,"Qual valor a ser sacado","Caixa Eletronico",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			if(cc.getSaldo() > z)
				JOptionPane.showMessageDialog(null, "","ERRO",JOptionPane.ERROR_MESSAGE);
			else
			cc.sacar(z);
			}
		case "2": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser sacado","Caixa Eletronico",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			if(cp.getSaldo() > z)
				JOptionPane.showMessageDialog(null, "","ERRO",JOptionPane.ERROR_MESSAGE);
			else
			cp.sacar(z);
			}
		}
	}while(!v.equals("0"));	
}

public void depositar() {
	
do {
		
		v = JOptionPane.showInputDialog(null,""
				+ "Deseja depositar pela conta poupança ou corrente?\n"
				+ "[1] Corrente\n[2] Poupança\n[0] Voltar",
				"Caixa Eletronico", JOptionPane.INFORMATION_MESSAGE);
		
		switch (v) {
		case "1": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			cc.depositar(z);
			}
		case "2": {
			v = JOptionPane.showInputDialog(null,"Qual valor a ser depositado","Caixa Eletronico",JOptionPane.QUESTION_MESSAGE);
			z = Double.parseDouble(v);
			cp.depositar(z);
			}
		}
	}while(!v.equals("0"));
}

public void transferir() {
	
}
}
