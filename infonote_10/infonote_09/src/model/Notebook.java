package model;

public class Notebook {

	private Notebook notebook;

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	private String serialNote;
	private String modelo;
	private String descricao;
	private int estoque;
	private double precoUnitario;
	private String figura;
	private String dataCadastro;

	public void mostrar() {

		// Mostrar usu�rio
		System.out.println("serial Note" + this.serialNote);
		System.out.println("modelo" + this.modelo);
		System.out.println("descricao" + this.descricao);
		System.out.println("estoque" + this.estoque);
		System.out.println("preco Unitario" + this.precoUnitario);
		System.out.println("figura" + this.figura);
		System.out.println("data Cadastro" + this.dataCadastro + "\n");

	}

	public Notebook(int numeroNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		super();
		this.serialNote = serialNote;
		this.modelo = modelo;
		this.descricao = descricao;
		this.estoque = estoque;
		this.precoUnitario = precoUnitario;
		this.figura = figura;
		this.dataCadastro = dataCadastro;
	}

	public Notebook() {
		super();
	}

	
	public String getSerialNote() {
		return serialNote;
	}

	public void setSerialNote(String serialNote) {
		this.serialNote = serialNote;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Notebook [SerialNote=" + serialNote + ", modelo=" + modelo + ", descricao=" + descricao + ", estoque="
				+ estoque + ", precoUnitario=" + precoUnitario + ", figura=" + figura + ", dataCadastro=" + dataCadastro
				+ ", getNumeroNote()=" + getSerialNote() + ", getModelo()=" + getModelo() + ", getDescricao()="
				+ getDescricao() + ", getEstoque()=" + getEstoque() + ", getPrecoUnitario()=" + getPrecoUnitario()
				+ ", getFigura()=" + getFigura() + ", getDataCadastro()=" + getDataCadastro() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
