package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {

	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;

	public NotebookDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Notebook inserir(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String Figura, String dataCadastro) {

		Notebook notebook = null;
		NotebookDAO notebookDAO = new NotebookDAO();
		try {

			String sql = "insert into notebook (serialNote, modelo, descricao, estoque, precoUnitario, Figura, dataCadastro) values (?,?,?,?,?,?,?)";

			Conexao conex = new Conexao(notebookDAO.url, notebookDAO.driver, notebookDAO.login, notebookDAO.senha);

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6, Figura);
			comando.setString(7, dataCadastro);

			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

	
	public static Notebook excluir(String id) {

		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();

		try {

			String sql = "delete from notebook where serialNote,  modelo, descricao, estoque, precoUnitario, figura, dataCadastro = ?";
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffery", "1234");

			Connection con = conex.obterConexao();
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, id);
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;
	}

	public static Notebook atualizar(String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {

		Notebook notebook = null;

		try {

			String sql = "update notebook set serialNote,  modelo, descricao, estoque, precoUnitario, figura, dataCadastro = ? where estoque = ? ";
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "jeffery", "1234");

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, descricao);
			comando.setInt(2, estoque);
			comando.setDouble(3, precoUnitario);
			comando.setString(4, figura);
			comando.setString(5, dataCadastro);

			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;
	}
	
	public static Notebook[] buscarTodos() {
		Notebook[] notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// Crição do select
			String sql = "Select * from notebook";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			Connection con = conex.obterConexao();
			/*
			 * Executa a confirmação direta de acesso ao banco pois não são necessárias
			 * informações para a Query (caracter curinga)
			 */
			Statement comando = con.createStatement();
			/*
			 * ResultSet - Classe java que monta em memória uma matriz com a resposta das
			 * linhas do banco de dados
			 */
			ResultSet rs = comando.executeQuery(sql);
			// vetor de objetos
			notebook = new Notebook[10];
			/*
			 * Passagem de linha de dados do ResultSet para o vetor de objetos (uma linha de
			 * dados da matriz do ResultSet é copiada para um objeto no vetor contatos)
			 */
			int i = 0;
			while (rs.next()) {
				notebook[i++] = new Notebook(
						rs.getString("serialnote"), 
						rs.getString("modelo"),
						rs.getString("descricao"),
						rs.getInt("estoque"),
						rs.getDouble("precoUnitario"),
						rs.getString("figura"),
						rs.getString("dataCadastro")
						);
			}
			// É necessário encerrar o acesso ao banco para liberar a conexão
			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}	
}
