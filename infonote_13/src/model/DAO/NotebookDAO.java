package model.DAO;

import java.awt.geom.Arc2D.Double;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Notebook;
import model.Usuario;
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

	public static Notebook[] buscarTodos() {
		Notebook[] notebook = null;

		try {

			String sql = "Select * from notebook";

			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote_13?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver", "Marcos", "1234");
			Connection con = conex.obterConexao();

			Statement comando = con.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			notebook = new Notebook[10];

			int i = 0;
			while (rs.next()) {
				notebook[i++] = new Notebook(

						rs.getString("serialNote"), rs.getString("modelo"), rs.getString("descricao"),
						rs.getInt("estoque"), rs.getDouble("precoUnitario"), rs.getString("Figura"),
						rs.getString("dataCadastro"));
			}

			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

	public static Notebook excluir(int estoque) {

		String sql = "DELETE FROM notebook WHERE Estoque =" + estoque;

		Conexao conex = new Conexao("jdbc:mysql://localhost:3306/infonote_13?useTimezone=true&serverTimezone=UTC",
				"com.mysql.cj.jdbc.Driver", "Marcos", "1234");
		Connection con = conex.obterConexao();

		PreparedStatement comando = con.prepareStatement(sql);
		comando.setInt(1, estoque);
		comando.executeUpdate();
		// Comando executado

		return null;
	}

}
