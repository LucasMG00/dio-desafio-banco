package main;

import javax.swing.JOptionPane;

import contas.*;

public class CaixaUI {
	
	String s, v, cliNome, cliCPF;
	Double z;
	Cliente c;
	Conta cc,cp;
	CaixaCommands cmd = new CaixaCommands();

	public void startup() {
		System.out.println("Aguardando comando...");
		
		do {
		s = JOptionPane.showInputDialog(null,
				".::Caixa Eletronico::.\n\n"
			   +"[1] Novo cliente\n"
			   +"[2] Criar conta Corrente\n"
			   +"[3] Criar conta Poupança\n"
			   +"[4] Sacar\n"
			   +"[5] Depositar\n"
			   +"[6] Transferir\n"
			   +"[7] Extrato\n"
			   +"[8] Lista de clientes\n"
			   +"[9] Lista de contas\n"
			   +"[0] Finalizar sessão\n\n"
			   , "Caixa Eletronico", JOptionPane.PLAIN_MESSAGE);
		
		if(s == null) s = "0";
		
		switch(s) {
		case("1"):
			cmd.criarCliente();
			break;
		case("2"):
			if(Banco.getClientes().size() != 0) {
				cmd.criarCorrente();
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer conta!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("3"):
			if(Banco.getClientes().size() != 0) {
				cmd.criarPoupanca();
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer conta!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("4"):
			if(Banco.getContas().size() != 0) {
				cmd.sacar();
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer saque!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("5"):
			if(Banco.getContas().size() != 0) {
				cmd.depositar();
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer deposito!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("6"):
			JOptionPane.showMessageDialog(null, "Função indisponível no momento","Caixa Eletronico",JOptionPane.INFORMATION_MESSAGE);
			break;
		case("7"):
			if(Banco.getContas().size() != 0) {
				cmd.imprimirExtrato();
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer extrato!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("8"):
			if(Banco.getClientes().size() != 0) {
				cmd.listaClientes();
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer listagem!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		case("9"):
			if(Banco.getContas().size() != 0) {
				cmd.listaContas();
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer listagem!","ERRO",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
		}while(!s.equals("0"));
	}
}