package com.acme.credvarejo.contaCrediario;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class ContaCrediarioEspecial extends ContaCrediario{
	private double percentualDeDesconto;
	private int pontosAcumulados;
	
	public ContaCrediarioEspecial(IdentificadorContaCrediario identificadorConta, Cliente cliente, double saldoDevido, double limiteDeCredito, int vencimento, boolean ativa, double percentualDeDesconto, int pontosAcumulados) {
		super(identificadorConta, cliente, saldoDevido, limiteDeCredito, vencimento, ativa);
		this.percentualDeDesconto = percentualDeDesconto;
		this.pontosAcumulados = pontosAcumulados;
		pontosAcumulados = 0;
	}
	
	//SOBRECARGA
	public ContaCrediarioEspecial(IdentificadorContaCrediario identificadorConta, Cliente cliente, double saldoDevido, double limiteDeCredito, int vencimento, boolean ativa, double percentualDeDesconto) {
		super(identificadorConta, cliente, saldoDevido, limiteDeCredito, vencimento, ativa);
		this.percentualDeDesconto = percentualDeDesconto;
	}
	
	public void efetuarPagamento(double valor) {
		super.efetuarPagamento(valor);
		
		double pontos = valor / 100;
		this.pontosAcumulados += (int)pontos;
	}
	
	//SOBRECARGA
	public void efetuarPagamento(double valor, double percentualDeDescontoPassado) {
		if(percentualDeDesconto == 0 && percentualDeDescontoPassado == 0) {
			efetuarPagamento(valor);
		}else if(percentualDeDesconto > percentualDeDescontoPassado){
			double saldoDev = getSaldoDevido();
			double desconto = saldoDev * (percentualDeDesconto / 100);
			saldoDev -= desconto;
			saldoDev -= valor;
			setSaldoDevido(saldoDev);
			
			double pontos = valor / 100;
			this.pontosAcumulados += (int)pontos;
		}else {	
			double saldoDev = getSaldoDevido();
			double desconto = saldoDev * (percentualDeDescontoPassado / 100);
			saldoDev -= desconto;
			saldoDev -= valor;
			setSaldoDevido(saldoDev);
			
			double pontos = valor / 100;
			this.pontosAcumulados += (int)pontos;
		}
	}
	
	public double getPercentualDeDesconto() {
		return this.percentualDeDesconto;
	}
	
	public void setPercentualDeDesconto(double novoPercentualDeDesconto) {
		this.percentualDeDesconto = novoPercentualDeDesconto;
	}
	
	public int getPontosAcumulados() {
		return this.pontosAcumulados;
	}
	
	public void setPontosAcumulados(int novoPontosAcumulados) {
		this.pontosAcumulados = novoPontosAcumulados;
	}
}
