package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ItemDePedido {

	private int qtde;
	private double subtotal;
	private Notebook notebook;

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public void mostrar() {

		// Mostrar usu�rio
		System.out.println("\n\nItemDePedido: ");
		System.out.println("qtde" + this.qtde);
		System.out.println("subtotal" + this.subtotal + "\n");

	}

	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}

	public ItemDePedido() {
		super();
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ItenDePedido [qtde=" + qtde + ", subtotal=" + subtotal + ", getQtde()=" + getQtde() + ", getSubtotal()="
				+ getSubtotal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public ItemDePedido(Notebook notebook) {
		super();
		this.notebook = notebook;
	}

	public ItemDePedido(int i, double precoUnitario, Notebook aux) {

	}

	public static void main(String[] args) {
		NumberFormat f = NumberFormat.getCurrencyInstance();
		double valor = 55008.537;
		System.out.println("Sem formata��o: " + valor);
		System.out.println("Formatado: " + f.format(valor));
		NumberFormat p = NumberFormat.getPercentInstance();
		double porcento = 0.05;
		System.out.println("Sem formata��o: " + porcento);
		System.out.println("Formatado: " + p.format(porcento));
		NumberFormat n = NumberFormat.getNumberInstance();
		double numero = 100.50;
		System.out.println("Sem formata��o: " + numero);
		System.out.println("Formatado: " + n.format(numero));
		double valor2 = 12000.5;
		DecimalFormat df = new DecimalFormat("R$ ###,###,###.00");
		System.out.println("Sem formata��o: " + valor2);
		System.out.println("Formatado: " + df.format(valor2));
	}

}
