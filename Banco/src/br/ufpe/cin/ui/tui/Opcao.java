package br.ufpe.cin.ui.tui;

public class Opcao {
	
	static void Inicial(){
		System.out.println(" 1. Cadastrar uma conta\n"
				+ " 2. Creditar um valor em uma conta \n"
				+ " 3. Debitar  um  valor em uma conta \n"
				+ " 4. Verificar  o Saldo\n"
				+ " 5. Render Bonus\n"
				+ " 6. Render Juros\n "
				+ " 7. Sair\n");
		
	}

	static void Cadastrar(){
		String tiposDeConta= new String(" Escolha o tipo de conta\n"
				+ "1.Conta corrente \n"
				+ "2.Conta Imposto \n"
				+ "3.Conta Especial \n"
				+ "4.Conta Poupança \n"
				+ "5.Conta Poupança Especial \n");
		System.out.println(tiposDeConta);
	}

	static void MenuCreditar(){
		 System.out.println("Digite o numero da Conta\n");
		 
		 System.out.println("Digite o valor que deseja creditar \n");
		 
	}
	static void MenuDebitar(){
		System.out.println("Digite o numero da Conta\n");
		System.out.println("Digite o valor que deseja debitar\n");
		Cadastrar();
		
	}
	static void MenuSaldo() {
		System.out.println("Digite o numero da Conta\n");
		Cadastrar();
		
		
	}
	static void MenuRenderBonus() {
		System.out.println("Digite o numero da Conta\n");
		System.out.println("Digite o valor que deseja render Bônus\n");
		Cadastrar();
	}
	static void MenRenderJuros() {
		System.out.println("Digite o numero da Conta\n");
		System.out.println("Digite o valor que deseja juros\n");
		Cadastrar();
		
	}

}
