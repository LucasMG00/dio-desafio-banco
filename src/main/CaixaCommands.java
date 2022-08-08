package main;

import javax.swing.JOptionPane;

import contas.*;

public class CaixaCommands {

	String input, cliNome, cliCPF;
	Double valor;
	Cliente cliente;
	Conta corrente, poupanca;

	public void criarCliente() {

		cliNome = JOptionPane.showInputDialog(null, "Digite o nome do cliente", "Caixa Eletronica",
				JOptionPane.PLAIN_MESSAGE);
		cliCPF = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Caixa Eletronica",
				JOptionPane.PLAIN_MESSAGE);

		cliente = new Cliente(cliNome, cliCPF);
		System.out.println("\nCliente "+cliente.getNome()+ " iniciou a sess�o...");
	}

	public void criarCorrente() {

		if (Banco.getClientes().size() != 0) {

			corrente = new Corrente(cliente);
			JOptionPane.showMessageDialog(null, "Conta Corrente criada com sucesso!", "Caixa Eletronico",
					JOptionPane.PLAIN_MESSAGE);
			System.out.println("Conta Corrente criada com sucesso!");

		} else {
			JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer conta!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void criarPoupanca() {

		if (Banco.getClientes().size() != 0) {

			poupanca = new Poupanca(cliente);
			JOptionPane.showMessageDialog(null, "Conta Poupan�a criada com sucesso!", "Caixa Eletronico",
					JOptionPane.PLAIN_MESSAGE);
			System.out.println("Conta Poupan�a criada com sucesso!");

		} else {
			JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer conta!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void sacar() {

		if (Banco.getContas().size() != 0) {

			do {

				input = JOptionPane.showInputDialog(null,
						"Deseja sacar da conta poupan�a ou corrente?\n" 
								+ "[1] Corrente\n[2] Poupan�a\n[0] Voltar",
						"Caixa Eletronico", JOptionPane.INFORMATION_MESSAGE);

				switch (input) {
				
				case "1": {
					if(corrente == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Corrente existente para fazer saque!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
					
					input = JOptionPane.showInputDialog(null, "Qual valor a ser sacado?", "Caixa Eletronico | Sacar",
							JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					if (corrente.getSaldo() < valor) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente!\nSaldo atual: " + corrente.getSaldo(),
								"ERRO", JOptionPane.ERROR_MESSAGE);
						break;
					} else {
						corrente.sacar(valor);
						JOptionPane.showMessageDialog(null,
								"Saque feito com sucesso!\nSaldo atual: " + corrente.getSaldo(),
								"Caixa Eletronico | Saque", JOptionPane.PLAIN_MESSAGE);
						System.out.println(cliente.getNome()+" sacou "+valor+" pela Conta Corrente...");
						break;
					}
					}
				}
				case "2": {
					if(poupanca == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Poupan�a existente para fazer saque!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					input = JOptionPane.showInputDialog(null, "Qual valor a ser sacado?", "Caixa Eletronico | Sacar",
							JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					if (poupanca.getSaldo() < valor) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente!\nSaldo atual: " + poupanca.getSaldo(),
								"ERRO", JOptionPane.ERROR_MESSAGE);
						break;
					} else {
						poupanca.sacar(valor);
						JOptionPane.showMessageDialog(null,
								"Saque feito com sucesso!\nSaldo atual: " + poupanca.getSaldo(),
								"Caixa Eletronico | Saque", JOptionPane.PLAIN_MESSAGE);
						System.out.println(cliente.getNome()+" sacou "+valor+" pela Conta Poupan�a...");
						break;
					}
					}
				}
				}
			} while (!input.equals("0"));

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer saque!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void depositar() {

		if (Banco.getContas().size() != 0) {

			do {

				input = JOptionPane.showInputDialog(null,
						"Deseja depositar pela conta poupan�a ou corrente?\n"
								+ "[1] Corrente\n[2] Poupan�a\n[0] Voltar",
						"Caixa Eletronico | Depositar", JOptionPane.INFORMATION_MESSAGE);

				switch (input) {
				
				case "1": {
					if(corrente == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Corrente existente para fazer desp�sito!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					input = JOptionPane.showInputDialog(null, "Qual valor a ser depositado",
							"Caixa Eletronico | Depositar", JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					corrente.depositar(valor);
					JOptionPane.showMessageDialog(null,
							"Dep�sito feito com sucesso!\nSaldo atual: " + corrente.getSaldo(),
							"Caixa Eletronico | Depositar", JOptionPane.PLAIN_MESSAGE);
					System.out.println(cliente.getNome()+" depositou "+valor+" na Conta Corrente...");
					break;
				}
				}
				case "2": {
					if(poupanca == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Poupan�a existente para fazer dep�sito!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					input = JOptionPane.showInputDialog(null, "Qual valor a ser depositado",
							"Caixa Eletronico | Depositar", JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					poupanca.depositar(valor);
					JOptionPane.showMessageDialog(null,
							"Dep�sito feito com sucesso!\nSaldo atual: " + poupanca.getSaldo(),
							"Caixa Eletronico | Depositar", JOptionPane.PLAIN_MESSAGE);
					System.out.println(cliente.getNome()+" depositou "+valor+" na Conta Poupan�a...");
					break;
				}
				}
				}
			} while (!input.equals("0"));

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer deposito!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void transferir() {

		if (Banco.getContas().size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer transfer�ncia!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} else if (this.corrente == null) {
			JOptionPane.showMessageDialog(null, "Nenhuma conta Corrente existente para fazer transfer�ncia!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} else if (this.poupanca == null) {
			JOptionPane.showMessageDialog(null, "Nenhuma conta Poupan�a existente para fazer transfer�ncia!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} else {

			do {

				input = JOptionPane.showInputDialog(null,
						"Escolha um m�todo de transfer�ncia:\n"
						+ "[1] Corrente para Poupan�a\n[2] Poupan�a para Corrente\n[0] Voltar",
						"Caixa Eletronico | Transferir", JOptionPane.INFORMATION_MESSAGE);

				switch (input) {
				
				case "1": {
					input = JOptionPane.showInputDialog(null, "Qual valor a ser transferido",
							"Caixa Eletronico | Transferir", JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					corrente.transferir(valor, poupanca);
					JOptionPane.showMessageDialog(null,
							"Transfer�ncia feita com sucesso!\nSaldos atuais:\n" 
									+ "Corrente: " + corrente.getSaldo() + "\n"
									+ "Poupan�a: " + poupanca.getSaldo(),
							"Caixa Eletronico | Transferir", JOptionPane.PLAIN_MESSAGE);
					System.out.println(cliente.getNome()+" transferiu "+valor+" da Conta Corrente para Conta Poupan�a...");
					break;
				}
				case "2": {
					input = JOptionPane.showInputDialog(null, "Qual valor a ser transferido",
							"Caixa Eletronico | Transferir", JOptionPane.QUESTION_MESSAGE);
					valor = Double.parseDouble(input);
					poupanca.transferir(valor, corrente);
					JOptionPane.showMessageDialog(null,
							"Transfer�ncia feita com sucesso!\nSaldos atuais:\n"
									+ "Poupan�a: " + poupanca.getSaldo() + "\n" 
									+ "Corrente: " + corrente.getSaldo(),
							"Caixa Eletronico | Transferir", JOptionPane.PLAIN_MESSAGE);
					System.out.println(cliente.getNome()+" transferiu "+valor+" da Conta Poupan�a para Conta Corrente...");
					break;
				}
				}
			} while (!input.equals("0"));

		}
	}

	public void imprimirExtrato() {

		if (Banco.getContas().size() != 0) {

			do {

				input = JOptionPane.showInputDialog(null,
						"Deseja imprimir extrato pela conta poupan�a ou corrente?\n"
								+ "[1] Corrente\n[2] Poupan�a\n[0] Voltar",
						"Caixa Eletronico | Extrato", JOptionPane.INFORMATION_MESSAGE);

				switch (input) {
				
				case "1": {
					if(corrente == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Corrente existente para fazer extrato!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					corrente.extrato();
					JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!", "Caixa Eletronico | Extrato",
							JOptionPane.PLAIN_MESSAGE);
					break;
				}
				}
				case "2": {
					if(poupanca == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma conta Poupan�a existente para fazer extrato!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					poupanca.extrato();
					JOptionPane.showMessageDialog(null, "Extrato impresso com sucesso!", "Caixa Eletronico | Extrato",
							JOptionPane.PLAIN_MESSAGE);
					break;
				}
				}
				}
			} while (!input.equals("0"));

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer extrato!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaClientes() {

		if (Banco.getClientes().size() != 0) {

			System.out.println("::Lista de Clientes::\n" + Banco.getClientes());
			JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!", "Caixa Eletronico | Clientes",
					JOptionPane.PLAIN_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "Nenhum cliente existente para fazer listagem!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaContas() {

		if (Banco.getContas().size() != 0) {

			System.out.println("::Lista de Contas::\n" + Banco.listaDeContas(Banco.getContas()));
			JOptionPane.showMessageDialog(null, "Lista impressa com sucesso!", "Caixa Eletronico | Contas",
					JOptionPane.PLAIN_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma conta existente para fazer listagem!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
