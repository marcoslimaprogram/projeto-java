package model;

public abstract class Usuario {

	private String login;
	private String senha;
	private int tipo;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Usuario(String login, String senha, int tipo) {
		super();
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void mostrar() {
	}

	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";

		retValue = "Informações do login:" + ENTER + super.toString() + "Login: " + login + ENTER + "Senha: " + senha
				+ ENTER + "Tipo : " + tipo;

		return retValue;

	}

}