	
	package br.ufpe.cin.ui.tui;

	import java.util.Arrays;
	import java.util.Scanner;

	import br.ufpe.cin.banco.Banco;
	import br.ufpe.cin.banco.Conta;
	import br.ufpe.cin.banco.ContaAbstrata;
	import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValoresNegativoException;
import br.ufpe.cin.dados.RepositorioContas;
	import br.ufpe.cin.dados.RepositorioContasArray;

	@SuppressWarnings("null")
	public class TextUserInterface {

		public static void main(String[] args) throws ContaJaCadastradaException,OperacaoComValoresNegativoException {

			Banco banco = new Banco(null);
			Scanner teclado = new Scanner(System.in);
			int option = 0;
			String numberAccount;
			double valueAccount = 0.0;
			String InputValueAccount = new String("Digite o valor da conta: \n");
			String InputNumberAccount = new String("Digite o número da conta: \n");

			{

				do {
					Opcao.Inicial();
					option = teclado.nextInt();
					switch (option) {
					case 1:
						Opcao.MenuCadastrar();
						option = teclado.nextInt();
						if (option == 1) {
							RepositorioContas repositorio = new RepositorioContasArray(100);
							Banco bank = new Banco(repositorio);
							
							System.out.println(InputNumberAccount);
							numberAccount = teclado.next();
							bank.cadastrar(new Conta(numberAccount));
							System.out.println(InputValueAccount);
							valueAccount = teclado.nextDouble();
							opcao.CadastroRealizado();
							System.out.println(repositorio);
							
							
							
							System.out.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
							option = teclado.nextInt();
							if (option == 1) {
								Menus.Cadastrar();
							} else {
								Menus.Principal();
							}
							// banco.cadastrar(conta); = numberAccount;
							try {
								banco.cadastrar(null);
							} catch (ContaJaCadastradaException e) {
								e.printStackTrace();
							}

						} else {
							Menus.Principal();
						}
						break;
					case 2:
						Menus.Creditar();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.Creditar();
							
						} else {
							Menus.Principal();
						}

						break;
//						try {
//							banco.creditar(null, valueAccount);
//						} catch (ContaJaCadastradaException e) {
//							e.printStackTrace();
//						}
					case 3:
						Menus.Debitar();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out
								.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.Debitar();
						} else {
							Menus.Principal();
						}
						break;
					case 4:
						Menus.Saldo();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out
								.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.Saldo();
						} else {
							Menus.Principal();
						}
						break;
					case 5:
						Menus.Transferencia();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out
								.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.Transferencia();
						} else {
							Menus.Principal();
						}
						break;
					case 6:
						Menus.RenderBonus();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out
								.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.RenderBonus();
						} else {
							Menus.Principal();
						}
						break;
					case 7:
						Menus.RenderJuros();
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println(InputValueAccount);
						valueAccount = teclado.nextDouble();
						Menus.CadastroRealizado();
						System.out
								.println("O que deseja fazer agora? \n (1) Cadastrar outra conta? \n (2) Menu inicial?\n");
						option = teclado.nextInt();
						if (option == 1) {
							Menus.RenderJuros();
						} else {
							Menus.Principal();
						}
						break;
					case 0:
						break;
					default:
						System.out.println("Opção inválida! ");
						break;
					}

				} while (option != 0);

			}
		}
	}

}
