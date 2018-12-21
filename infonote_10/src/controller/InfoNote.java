package controller;

import java.text.DateFormat;
import java.util.Date;

import model.*;
import util.*;

public class InfoNote {
	Usuario user;
	boolean logado = false;

	int opcao = 8;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;

	private static Cliente clienteGlobal = null;
	private static Funcionario funcionarioGlobal = null;

	public static void main(String[] args) {

		InfoNote info = new InfoNote();
		int opcao = 8;
		do {
			info.mostrarMenu();
			opcao = Teclado.LerInt("Digite sua opção: ");
			switch (opcao) {

			case 1:
				info.efetuarLogin();
				break;
			case 2:
				info.cadastrarUsuario();
				break;
			case 3:
				info.buscarNotebook();
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
				System.out.println("Saída do Sistema.");
				break;
			default:
				System.out.println("Opção inválida!");
			}

		} while (opcao != 8);
		Teclado.LerTexto("Pressione uma tecla para continuar...");
	}

	public InfoNote() {
		notebooks[0] = new Notebook(1, "Negativo N22BR", "CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB", 6, 1200.00,
				"img\\n22br.jpg", "19/05/2011");
		notebooks[1] = new Notebook(2, "Bell B55BR", "CPU Intel I3, Memória 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");
		notebooks[2] = new Notebook(3, "Pompaq P41BR", "CPU Intel I3, Memória 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");
		notebooks[3] = new Notebook(4, "CCF CR71CH", "CPU Intel Dual Core, Memória 2 GB, HD 160 GB", 5, 1100.00,
				"img\\cr71ch.jpg", "10/06/2011");
		notebooks[4] = new Notebook(5, "BradescoTech BD22BR", "CPU AMD Phenon II, Memória 4 GB, HD 500 GB", 2, 1900.00,
				"img\\bd22br.jpg", "10/06/2011");
	}

	public void buscarNotebook1() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "-----" + notebooks[i].getModelo());
			}
		}
	}

	public void mostrarMenu() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Se não é Info não vendemos. "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));
		if (logado == true) {
			System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
		}

		System.out.println("==================================================");

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
		if (clienteGlobal != null) {
			logado = clienteGlobal.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou senha inválido.");
			}

		} else {
			logado = funcionarioGlobal.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou senha inválido.");
			}

		}
	}

	public void cadastrarUsuario() {
		System.out.println("==================================================");
		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usuários. ");
		System.out.println("=================================================");

		String login = Teclado.LerTexto(" Login: ");
		String senha = Teclado.LerTexto(" Senha: ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}

		int tipo = 1;
		String codigoCliente = Teclado.LerTexto("codigo cliente");
		String nome = Teclado.LerTexto("Nome: ");
		String email = Teclado.LerTexto("E-mail: ");
		String telefone = Teclado.LerTexto("Telefone: ");

		// Endereco
		String logradouro = Teclado.LerTexto("logradouro:");
		String numero = Teclado.LerTexto("numero:");
		String complemento = Teclado.LerTexto("complemento:");
		String bairro = Teclado.LerTexto("bairro");
		String cidade = Teclado.LerTexto("cidade");
		String estado = Teclado.LerTexto("estado");

		String cep = Teclado.LerTexto("CEP: ");

		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);

		Cliente cliente = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone, endereco);
		clienteGlobal = cliente;

		// user = new Usuario("Marcos Lima", "Senha 12345", 1);
		System.out.println("=================================================");
		System.out.println(" Usuário Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(cliente);
		System.out.println(endereco);
		// System.out.println(Usuario);
	}

	public void buscarNotebook() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "-----" + notebooks[i].getModelo());
			}

		}

	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Construção");
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Construção");

	}

	// InfoNote info = new InfoNote();

	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {
		// Lê o notebook escolhido do teclado
		String numeroNote = Teclado.LerTexto("Informe o número do notebook" + " para compra: ");
		// Cria pedido
		if (pedido == null) {
			pedido = new Pedido();
		}
		// Busca notebook selecionado
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getSerialNote())) {
				aux = notebooks[i];
			}
		}
		// Se não existir, interrompe
		if (aux == null) {
			return;
		}
		// Cria item
		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
		// Insere item no pedido
		pedido.inserirItem(item);
	}
}
