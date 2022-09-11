package com.acme.credvarejo.ado.conta;

import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class RepositorioContaCrediario implements InterfaceRepositorioContaCrediario{
	private ContaCrediario[] contas;
	private int indice;
	
	public RepositorioContaCrediario() {
		contas = new ContaCrediario[150];
		indice = 0;
	}
	
	public void incluir(ContaCrediario c){
		contas[indice] = c;
		indice++;
	}
	
	//altera o limite de cr�dito
	public void alterar(IdentificadorContaCrediario atual, double nova) {
		for(int i = 0; i < indice; i++) {
			if(contas[i].getIdentificadorConta().equals(atual)) {
				contas[i].setLimiteDeCredito(nova);
			}
		}
	}
	
	public void excluir(IdentificadorContaCrediario numero) {
		ContaCrediario[] aux = new ContaCrediario[contas.length - 1];
		int index = 0;
		for(int i = 0; i < indice; i++) {
			if(contas[i].getIdentificadorConta() != numero) {
				aux[index] = contas[i];
				index++;
			}
		}
		contas = aux;
		indice = index;
	}
	
	public ContaCrediario buscarPorChave(IdentificadorContaCrediario id) {
		ContaCrediario c = null;
		for(int i = 0; i < indice; i++) {
			if(contas[i].getIdentificadorConta().equals(id)) {
				c = contas[i];
			}
		}
		return c;
	}
	
	public void buscarTodos() {
		for(int i = 0; i < indice; i++) {
			System.out.println("Nome: "+contas[i].getCliente().getNome()+
							"\nID Conta: "+contas[i].getIdentificadorConta().getNumero()+
							"\nCPF: "+contas[i].getCliente().getCpf().getNumero()+
							"\nLimite de Crédito: "+contas[i].getLimiteDeCredito()+"\n");
		}
	}
	
	public ContaCrediario[] getContas() {
		return contas;
	}

	public void setContas(ContaCrediario[] contas) {
		this.contas = contas;
	}

	
}
