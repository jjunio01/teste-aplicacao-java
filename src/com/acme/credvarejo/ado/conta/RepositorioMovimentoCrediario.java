package com.acme.credvarejo.ado.conta;


import com.acme.credvarejo.conta.MovimentoCrediarioCredito;
import com.acme.credvarejo.conta.MovimentoCrediarioDebito;

public class RepositorioMovimentoCrediario implements InterfaceRepositorioMovimentoCrediario{
	private MovimentoCrediarioCredito[] movimentacaoCredito;
	private MovimentoCrediarioDebito[] movimentacaoDebito;
	private int indiceC;
	private int indiceD;
	
	public RepositorioMovimentoCrediario() {
		movimentacaoCredito = new MovimentoCrediarioCredito[150];
		movimentacaoDebito = new MovimentoCrediarioDebito[150];
		indiceC = 0;
		indiceD = 0;
	}
	
	public void incluirCredito(MovimentoCrediarioCredito c) {
		movimentacaoCredito[indiceC] = c;
		indiceC++;
	}
	
	public void incluirDebito(MovimentoCrediarioDebito d) {
		movimentacaoDebito[indiceD] = d;
		indiceD++;
	}
	
	public void buscarTodos() {
		System.out.println("Crédito: \n");
		for(int i = 0; i < indiceC; i++) {
			System.out.println("Nome: "+movimentacaoCredito[i].getContaCrediario().getCliente().getNome()+
							   "\nValor da Transa��o: "+movimentacaoCredito[i].getValorTransacao()+
							   "\nSaldo devido: "+movimentacaoCredito[i].getContaCrediario().getSaldoDevido()+
							   "\nHora da transa��o: "+movimentacaoCredito[i].getDataHoraDaOperacao()+
							   "\nEst� ativa: "+movimentacaoCredito[i].getContaCrediario().isAtiva()+"\n");
		}
		System.out.println("Débito: \n");
		for(int i = 0; i < indiceD; i++) {
			System.out.println("Nome: "+movimentacaoDebito[i].getContaCrediario().getCliente().getNome()+
							   "\nValor da Transa��o: "+movimentacaoDebito[i].getValorTransacao()+
							   "\nSaldo devido: "+movimentacaoDebito[i].getContaCrediario().getSaldoDevido()+
							   "\nHora da transa��o: "+movimentacaoDebito[i].getDataHoraDaOperacao()+
							   "\nEst� ativa: "+movimentacaoDebito[i].getContaCrediario().isAtiva()+"\n");
		}
	}
}
