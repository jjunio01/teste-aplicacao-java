package com.acme.credvarejo.conta;

import java.util.Date;

import com.acme.credvarejo.classesGerais.Registro;
import com.acme.credvarejo.classesGerais.RepositorioRegistro;

abstract class MovimentoCrediario extends Registro{
	private ContaCrediario contaCrediario;
	private double valorTransacao;
	private Date dataHoraDaOperacao;
	

	public MovimentoCrediario(ContaCrediario contaCrediario, double valorTransacao, Date dataHoraDaOperacao) {
		this.contaCrediario = contaCrediario;
		this.valorTransacao = valorTransacao;
		this.dataHoraDaOperacao = dataHoraDaOperacao;
	}
	
	public String getNomeExtrato(int i){
		if(i == 0) {
			return contaCrediario.getCliente().getSegundoNome().toUpperCase()+", "+contaCrediario.getCliente().getPrimeiroNome().toUpperCase()+" MR.";
		}else if(i == 1){
			return contaCrediario.getCliente().getSegundoNome().toUpperCase()+", "+contaCrediario.getCliente().getPrimeiroNome().toUpperCase()+" MRS.";
		}else {
			return "Inválido!";
		}
	}

	public ContaCrediario getContaCrediario() {
		return this.contaCrediario;
	}

	public void setContaCrediario(ContaCrediario contaCrediario) {
		this.contaCrediario = contaCrediario;
	}

	public double getValorTransacao() {
		return this.valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	public Date getDataHoraDaOperacao() {
		return this.dataHoraDaOperacao;
	}

	public void setDataHoraDaOperacao(Date dataHoraDaOperacao) {
		this.dataHoraDaOperacao = dataHoraDaOperacao;
	}

	public String getChave() {
		return "ID: "+String.valueOf(contaCrediario.getIdentificadorConta().getNumero())+
				"\nHora da Operação: "+String.valueOf(dataHoraDaOperacao);
	}
	
	public void validar() {
		if(this.contaCrediario != null) {
			if(this.valorTransacao > 0) {
				if(this.dataHoraDaOperacao != null) {
					System.out.println("Movimento Validado");
				}else {
					System.out.println("Movimento Inválido");
				}
			}
		}
	}
	
	//REPOSITÓRIO
		MovimentoCrediario[] repositorio = new MovimentoCrediario[150];
	
}
