package controlle;

import model.*;

public class Teste {

	public static void main(String[] args) {

		Usuario user = new Usuario(1, "joseph", "climber", "Joseph Climber", "josephclimber@gmail.com", "2222-3344");

		user.mostrar();

		Endereco end = new Endereco("R. Fidel Castro", "98", "aPTO 407", "Tijuca", "RJ", "RJ", "20250650");
		end.mostrar();

		Pedido ped = new Pedido(15000, "15102018", "A vista", 5000.00, "Ativo");
		ped.mostrar();

		ItemDePedido Idp1 = new ItemDePedido(9, 5000.00);
		Idp1.mostrar();

		ItemDePedido Idp2 = new ItemDePedido(12, 5800.00);
		Idp2.mostrar();

		Notebook Note1 = new Notebook(20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Note1.mostrar();

		Notebook Note2 = new Notebook(20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Note1.mostrar();

		Notebook Note3 = new Notebook(20250122, "Rs200", "Modelo Completo", 10, 4200.00, "figura", "01012018");
		Note1.mostrar();

	}
}