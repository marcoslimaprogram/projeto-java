package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import model.*;
import util.*;

public class InfoNote {
	Usuario user;
	boolean logado = false;
	
	Configurador config;
	Ajuda ajuda;

	int opcao = 8;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;

	private static Cliente clienteGlobal = null;
	private static Funcionario funcionarioGlobal = null;
	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;
	private static final int SAIR = 9;

	public static void main(String[] args) throws Exception {
		InfoNote info = new InfoNote();
		int opcao = SAIR;
		do {
			info.mostrarMenu();
			opcao = Teclado.LerInt("Digite sua opção: ");
			
			switch (opcao) {
			case LOGIN:
				info.efetuarLogin();
				break;
				
			case CADASTRAR_USUARIO:
				info.cadastrarUsuario();
				break;
				
			case BUSCAR_NOTEBOOK:
				info.buscarNotebook();
				break;
				
			case INSERIR_NOTEBOOK:
				info.manterCarrinho();
				break;
				
			case REMOVER_NOTEBOOK:
				info.manterCarrinho();
				break;
				
			case VER_CARRINHO:
				info.manterCarrinho();
				break;
				
			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}
				
			case AJUDA:
				info.ajuda();
				break;
				
			case SAIR:
				System.out.println("Saída do Sistema");
				break;
			default:
				System.out.println("Opção inválida!");
			}
			Teclado.LerTexto("Pressione uma tecla para continuar...");
		} while (opcao != SAIR);
	}

	public InfoNote() throws Exception {
		// Cria objeto de configurações
		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		// Cria o objeto Ajuda
		ajuda = new Ajuda(config.getArquivoAjuda());
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
		System.out.println("3 - Buscar notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Ajuda");
		System.out.println("9 - Sair");

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
	
	public void ajuda(){
		System.out.println(ajuda.getTexto());
		
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
	
	public static boolean isNumeric(String str)
	{
		try
		{
			int d = Int.parseInt(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
					}
		return true;
	}
}
