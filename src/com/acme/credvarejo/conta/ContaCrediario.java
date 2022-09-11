package com.acme.credvarejo.conta;

import com.acme.credvarejo.classesGerais.Registro;
import com.acme.credvarejo.cliente.Cliente;

public class ContaCrediario extends Registro{
	private IdentificadorContaCrediario identificadorConta;
	private Cliente cliente;
	private double saldoDevido;
	private double limiteDeCredito;
	private int vencimento;
	private boolean ativa;
	
	public ContaCrediario(IdentificadorContaCrediario identificadorConta, Cliente cliente, double saldoDevido, double limiteDeCredito, int vencimento, boolean ativa) {
		this.identificadorConta = identificadorConta;
		this.cliente = cliente;
		this.saldoDevido = saldoDevido;
		saldoDevido = 0;
		this.limiteDeCredito = limiteDeCredito;
		this.vencimento = vencimento;
		this.ativa = ativa;
		ativa = true;
	}
	
	public void efetuarPagamento(double valor) {
		this.saldoDevido -= valor;
	}
	
	public void efetuarCompra(double valor) {
		this.saldoDevido += valor;
	}
	
	public boolean desativar() {
		return this.ativa = false;
	}
	
	public boolean reativar() {
		return this.ativa = true;
	}

	public IdentificadorContaCrediario getIdentificadorConta() {
		return identificadorConta;
	}

	public void setIdentificadorConta(IdentificadorContaCrediario identificadorConta) {
		this.identificadorConta = identificadorConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldoDevido() {
		return saldoDevido;
	}

	public void setSaldoDevido(double saldoDevido) {
		this.saldoDevido = saldoDevido;
	}

	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public int getVencimento() {
		return vencimento;
	}

	public void setVencimento(int vencimento) {
		this.vencimento = vencimento;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public String getChave() {
		long l = this.identificadorConta.getNumero();
		String str = Long.toString(l);

		return str;
	}
	
	public void validar() {
		if(this.identificadorConta != null) {
			if(this.cliente != null) {
				if(this.saldoDevido > 0) {
					System.out.println("Conta Validada");
					}else {
						System.out.println("Conta invalida");
				}
			}
		}
	}
	
	//REPOSITÓRIO
		ContaCrediario[] repositorio = new ContaCrediario[150];
	
}
