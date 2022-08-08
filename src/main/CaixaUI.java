package main;

import javax.swing.JOptionPane;

public class CaixaUI {

	String input;
	CaixaCommands cmd = new CaixaCommands();

	public void startup() {
		System.out.println("Aguardando comando...");

		do {
			input = JOptionPane.showInputDialog(null,
							mostraCli()+"\n\n"
							+ "[1] Novo cliente\n"
							+ "[2] Criar conta Corrente\n"
							+ "[3] Criar conta Poupança\n"
							+ "[4] Sacar\n"
							+ "[5] Depositar\n"
							+ "[6] Transferir\n"
							+ "[7] Extrato\n"
							+ "[8] Lista de clientes\n"
							+ "[9] Lista de contas\n"
							+ "[0] Finalizar sessão\n\n",
					"Caixa Eletronico", JOptionPane.PLAIN_MESSAGE);

			if (input == null)
				input = "0";

			switch (input) {
			
			case ("1"):
				cmd.criarCliente();
				break;
			case ("2"):
				cmd.criarCorrente();
				break;
			case ("3"):
				cmd.criarPoupanca();
				break;
			case ("4"):
				cmd.sacar();
				break;
			case ("5"):
				cmd.depositar();
				break;
			case ("6"):
				cmd.transferir();
				break;
			case ("7"):
				cmd.imprimirExtrato();
				break;
			case ("8"):
				cmd.listaClientes();
				break;
			case ("9"):
				cmd.listaContas();
				break;
			}

		} while (!input.equals("0"));
	}
	
	public String mostraCli() {
		if(cmd.cliente == null) {
			return ".::Caixa Eletronico::.";
		} else {
			return "Bem-vindo(a) " + cmd.cliente.getNome() + "!";
		}
	}
}