package br.ufpe.cin.ui.tui;

import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValoresNegativoException;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.PoupancaEsp;
import br.ufpe.cin.banco.SaldoInsuficienteException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArray;

public class Menu {
	Banco banco= new Banco(new RepositorioContasArray(200));
	public static void main(String[] args) throws ContaJaCadastradaException, NumberFormatException, 
	OperacaoComValoresNegativoException,ContaNaoEncontradaException{

		Banco banco = new Banco(null);
		Scanner receber = new Scanner(System.in);
		String number= new String();
		ContaAbstrata conta = null;
		String msg = new String();
		double valor;
		int number1;
		int number2;
		int number3;
	
		/* Declaração das variáveis*/
		
		String menuPrincipal =new String(" 1. Cadastrar uma conta\n"
				+ " 2. Creditar um valor em uma conta \n"
				+ " 3. Debitar  um  valor em uma conta \n"
				+ " 4. Verificar  o Saldo\n"
				+ " 5. Render Bonus\n"
				+ " 6. Render Juros\n "
				+ " 7. Sair\n");
		String menuConta= new String(" Escolha o tipo de conta\n"
				+ "1.Conta corrente \n"
				+ "2.Conta Imposto \n"
				+ "3.Conta Especial \n"
				+ "4.Conta Poupança \n"
				+ "5.Conta Poupança Especial \n");
		String numeroDaconta= new String("número da Conta");
		String valorConta= new String("Digite o valor que desejo");
		
		System.out.println(menuPrincipal);
		number1=receber.nextInt();
		
		while(number1<=0 || number1>7) {
		System.out.println(menuPrincipal);
		number1=receber.nextInt();
		}
		
		
		if(number1==1) {
			System.out.println(menuConta);
			number2=receber.nextInt();
			
			while(number2>0 && number2<6) {	
				RepositorioContas repositorio = new RepositorioContasArray(100);
				Banco bank = new Banco(repositorio);
				
					
				if(number2==1) {
					System.out.println(numeroDaconta);
					number= receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new Conta(number,valor);
					
				}else if(number2==2) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new ContaImposto(number, valor);
					
				}else if(number2==3) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new ContaEspecial(number, valor);

					System.out.println(repositorio);
				}
				else if(number2==4) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new Poupanca(number, valor);
					System.out.println(repositorio);
					
				}
				else if(number2==5) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new Poupanca(number, valor);
					
				}	
				
				try {
						System.out.println("Conta Criada com sucesso ! \n"
						+ "\n Conta: "+conta.getNumero()+
						"\n Saldo :  \n"+conta.getSaldo());
					   bank.cadastrar(new Conta(number));
					    System.out.println(repositorio);
					
		
				}
					
				catch (ContaJaCadastradaException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				
			}
		
			System.out.println("Você digitou uma opção inválida\n"
					+ "Digite novamente!\n\n");
			System.out.println(menuConta);
			number2=receber.nextInt();
			
			//System.out.println(valorConta);
			//valor=receber.nextDouble();
		}
		
		
	if(number1==2) {
		try {
		System.out.println(numeroDaconta);
		number= receber.next();
		System.out.println(valorConta);
			valor=receber.nextDouble();
			conta.creditar(valor);
			System.out.println("Credito executado com "
					+ "sucesso\n. A conta é"+conta.getNumero()
							+ " O saldo é "+conta.getSaldo());
			banco.creditar(number, valor);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (ContaNaoEncontradaException e) {
			System.out.println(e.getMessage());
	    } catch (OperacaoComValoresNegativoException e) {
	    	System.out.println(e.getMessage());
	    }
	}
		if(number1==3) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
			try {
				conta.debitar(valor);	
				banco.debitar(number, valor);
				System.out.println("Debito executado com sucesso");
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (OperacaoComValoresNegativoException e) {
				System.out.println(e.getMessage());
		    }
		}
		if(number1==4) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
		}
		if(number1==5) {
			System.out.println(numeroDaconta);
			number=receber.next();
			System.out.println(" O numero da conta"+conta.getNumero()+"\n "
					+ "O saldo é"+conta.getSaldo());
						
		}
		if(number1==6) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
		}
		if(number1==7) {
		
			System.out.println("Você realmente quer sair do sistema\n"
					+ "Se sim digite 1 \n"
					+ "Se não digite qualquer número");
			number1=receber.nextInt();
				
				
					if(number1==1) {
						System.out.println("Obrigada por ter"
								+ " utilizado o sistema !!\n"
								+ "Volte Sempre!!");
						return;			
					}
					else {
						System.out.println(menuPrincipal);
						number1=receber.nextInt();
						while(number1<=0 || number1>7) {
							System.out.println(menuPrincipal);
							number1=receber.nextInt();
					} 
						
					}
				}
			
		}
		}

	









