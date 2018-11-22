package controlle;

import model.*;

public class Teste {
	 
	public static void main(String[] args) {
		
		Usuario Usu = new Usuario();
		Usu.setMatricula(1069);
		Usu.setLogin("Limam2");
		Usu.setSenha("1069");
		Usu.setNome("Marcos lima");
		Usu.setEmail("marcos_lima@hotmail");
		Usu.setTelefone("23257777");
		System.out.println();
		
		Endereco End = new Endereco();
		End.setLogradouro(logradouro);
		End.setNumero(numero);		
		End.setComplemento(complemento);
		End.setBairro(bairro);
		End.setCidade(cidade);
		End.setEstado(estado);
		End.setCep(cep);
		
		ItemDePedido Idp1 = new ItemDePedido();
		Idp1.setQtde (2);
		Idp1.setSubtotal(22.98);
		System.out.println(Idp1.toString());
		
		ItemDePedido Idp2 = new ItemDePedido();
		Idp1.setQtde (1);
		Idp1.setSubtotal(98.75);
		System.out.println(Idp2.toString());
		
		
		
		
	}
}