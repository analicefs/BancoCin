package br.ufpe.cin.banco;

public class PoupancaEsp extends Poupanca {

	public PoupancaEsp(String numero) {
		super(numero);
		
	}

	public PoupancaEsp(String numero, double saldo) {
		super(numero, saldo);
		
	}
		@Override
		public void renderJuros(double taxa) {
			double juros = (this.getSaldo() * (taxa + 0.10));
			this.creditar(juros);
		}
	}
	

