package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pedido {

	public ItemDePedido[] getItens() {
		return itens;
	}

	public void setItens(ItemDePedido[] itens) {
		this.itens = itens;
	}

	private String numeroPedido;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	private String enderecoEntrega;
	private ItemDePedido itens[] = new ItemDePedido[10];

	// public int cont= 0;

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public void mostrar() {

		// Mostrar usuário - + cont + "\n"
		System.out.println(" \nPedido: ");
		System.out.println(" numero: " + this.numeroPedido);
		System.out.println(" dataEmissao: " + this.dataEmissao);
		System.out.println(" formaDePagamento: " + this.formaDePagamento);
		System.out.println(" valorTotal: " + this.valorTotal);
		System.out.println(" E-situacao: " + this.situacao + "\n");
		// cont ++;
		System.out.println("\n\nItens do Pedido:\n");
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] != null) {
				itens[i].mostrar();
			}
		}
	}

	public Pedido(String numeroPedido, String dataEmissao, String formaDePagamento, double valorTotal, String situacao,
			String enderecoEntrega) {
		super();
		this.numeroPedido = numeroPedido;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.enderecoEntrega = enderecoEntrega;

	}

	public Pedido() {
		super();

	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		retValue = "Informações sobre Pedido:" + ENTER + "Número do Pedido: " + numeroPedido + ENTER
				+ "Data de Emissão: " + dataEmissao + ENTER + "Forma de pagamento: " + formaDePagamento + ENTER
				+ "Valor Total: " + valorTotal + ENTER + "Situação: " + situacao + ENTER + "Endereço de Entrega: "
				+ ENTER + "Itens: ";
		for (int i = 0; i < itens.length; i++) {
			retValue += itens[i] + ENTER;
		}
		return retValue;
	}

	public boolean inserirItem(ItemDePedido item) {
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] == null) {
				itens[i] = item;
				return true;
			}
		}
		return false;

	}
	public static void main(String[] args) {
		NumberFormat f = NumberFormat.getCurrencyInstance();
		double valor = 55008.537;
		System.out.println("Sem formatação: " + valor);
		System.out.println("Formatado: " + f.format(valor));
		NumberFormat p = NumberFormat.getPercentInstance();
		double porcento = 0.05;
		System.out.println("Sem formatação: " + porcento);
		System.out.println("Formatado: " + p.format(porcento));
		NumberFormat n = NumberFormat.getNumberInstance();
		double numero = 100.50;
		System.out.println("Sem formatação: " + numero);
		System.out.println("Formatado: " + n.format(numero));
		double valor2 = 12000.5;
		DecimalFormat df = new DecimalFormat("R$ ###,###,###.00");
		System.out.println("Sem formatação: " + valor2);
		System.out.println("Formatado: " + df.format(valor2));
		}
	
}
