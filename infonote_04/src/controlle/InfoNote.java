package controlle;

import model.*;
import util.*;

public class InfoNote {
	public static void main(String[] args) {
		
		InfoNote info = new InfoNote();
		int opcao = 8;
		info.mostrarMenu();
		opcao = Teclado.LerInt("Digite sua op��o: ");
		
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
			System.out.println("Sa�da do Sistema.");
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}
		Teclado.LerTexto("Pressione uma tecla para continuar...");
		do {
		} while (opcao != 8);
	}

	Usuario user;
	boolean logado = false;
	int opcao = 8;

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
		InfoNote info = new InfoNote();

	}

}
