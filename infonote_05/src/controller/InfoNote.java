package controller;

import model.*;
import util.*;

public class InfoNote {
	public static void main(String[] args) {

		InfoNote info = new InfoNote();
		int opcao = 8;
		info.mostrarMenu();
		opcao = Teclado.LerInt("Digite sua op��o: ");
		do {
			switch (opcao) {

			case 1:
				info.efetuarLogin();
				break;
			case 2:
				info.cadastrarUsuario();
				break;
			case 3:
				info.buscarNotebook1();
				break;
			case 4:
				info.manterCarrinho();
				break;
			case 5:
				info.manterCarrinho();
				break;
			case 6:
				info.manterCarrinho();
				break;
			case 7:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}
			case 8:
				System.out.println("Sa�da do Sistema.");
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
			Teclado.LerTexto("Pressione uma tecla para continuar...");

		} while (opcao != 8);
	}

	Usuario user;
	boolean logado = false;
	int opcao = 8;

	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;

	public InfoNote() {
		notebooks[0] = new Notebook(1, "Negativo N22BR", "CPU Intel Core 2 Duo, Mem�ria 2 GB, HD 250 GB", 6, 1200.00,
				"img\\n22br.jpg", "19/05/2011");
		notebooks[1] = new Notebook(2, "Bell B55BR", "CPU Intel I3, Mem�ria 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");
		notebooks[2] = new Notebook(3, "Pompaq P41BR", "CPU Intel I3, Mem�ria 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");
		notebooks[3] = new Notebook(4, "CCF CR71CH", "CPU Intel Dual Core, Mem�ria 2 GB, HD 160 GB", 5, 1100.00,
				"img\\cr71ch.jpg", "10/06/2011");
		notebooks[4] = new Notebook(5, "BradescoTech BD22BR", "CPU AMD Phenon II, Mem�ria 4 GB, HD 500 GB", 2, 1900.00,
				"img\\bd22br.jpg", "10/06/2011");
	}

	public void buscarNotebook1() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getNumeroNote() + "-----" + notebooks[i].getModelo());
			}
		}
	}

	public void mostrarMenu() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Se n�o � Info n�o vendemos. ");
		System.out.println("=================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar Notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - Ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.LerTexto("Digite o login: ");
		senha = Teclado.LerTexto("Digite a senha: ");
		if (login.equals("admin") && senha.equals("1234")) {
			System.out.println("Login efetuado com sucesso.");
			logado = true;
		} else {
			System.out.println("Login ou Senha inv�lido.");
			efetuarLogin();
		}
	}

	public void cadastrarUsuario() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usu�rios. ");
		System.out.println("=================================================");
		int matricula = Teclado.LerInt("Matr�cula: ");
		String login = Teclado.LerTexto("Login: ");
		String senha = Teclado.LerTexto("Senha: ");
		String nome = Teclado.LerTexto("Nome: ");
		String email = Teclado.LerTexto("E-mail: ");
		String telefone = Teclado.LerTexto("Telefone: ");
		user = new Usuario(matricula, login, senha, nome, email, telefone);
		System.out.println("=================================================");
		System.out.println(" Usu�rio Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(user);
	}

	public void buscarNotebook() {
		System.out.println("buscarNotebook - Em Constru��o");
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Constru��o");
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Constru��o");

	}

	InfoNote info = new InfoNote();

	public void inserirNotebook() {
		// L� o notebook escolhido do teclado
		String numeroNote = Teclado.LerTexto("Informe o n�mero do notebook" + " para compra: ");
		// Cria pedido
		if (pedido == null) {
			pedido = new Pedido();
		}
		// Busca notebook selecionado
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getNumeroNote())) {
				aux = notebooks[i];
			}
		}
		// Se n�o existir, interrompe
		if (aux == null) {
			return;
		}
		// Cria item
		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
		// Insere item no pedido
		pedido.inserirItem(item);
	}
}
