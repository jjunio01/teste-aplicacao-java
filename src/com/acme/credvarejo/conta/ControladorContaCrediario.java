package com.acme.credvarejo.conta;


import java.util.Date;

import com.acme.credvarejo.ado.conta.InterfaceRepositorioContaCrediario;
import com.acme.credvarejo.cliente.Cliente;

public class ControladorContaCrediario {
	private InterfaceRepositorioContaCrediario repositorio;
	

	public ControladorContaCrediario(InterfaceRepositorioContaCrediario repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserir(Cliente cliente, double limiteCredito, int data) {
			if(cliente == null || (limiteCredito <= 0) || (data < 1 || data > 31)) {
				
			}else {
				IdentificadorContaCrediario id = new IdentificadorContaCrediario(cliente.getCpf().getNumero());
				ContaCrediario conta = new ContaCrediario(id, cliente, 0, limiteCredito, data, true);
				conta.validar();
				repositorio.incluir(conta);
			}
	}
	
	public void creditar(IdentificadorContaCrediario id, double valor, ControladorMovimentoCrediario movimento) {
		if(id == null) {
			System.out.println("Inválido!");
		}else {
			ContaCrediario c = null;
			c = repositorio.buscarPorChave(id);
			c.efetuarPagamento(valor);
			Date data = new Date();
			MovimentoCrediarioCredito mov = new MovimentoCrediarioCredito(c, valor, data, c.getSaldoDevido());
			movimento.inserirCredito(mov);
		}
	}
	
	public void debitar(IdentificadorContaCrediario id, double valor, ControladorMovimentoCrediario movimento) {
		if(id == null) {
			System.out.println("Inválido!");
		}else {
			ContaCrediario c = repositorio.buscarPorChave(id);
			if(valor <= c.getLimiteDeCredito()) {	
				c.efetuarCompra(valor);
				Date data = new Date();
				MovimentoCrediarioDebito mov = new MovimentoCrediarioDebito(c, valor, data, c.getSaldoDevido());
				movimento.inserirDebito(mov);
			}else {}
			
		}
	}
	
	public void buscar(IdentificadorContaCrediario id) {
		if(id == null) {
			System.out.println("Inválido!");
		}else {
			repositorio.buscarPorChave(id);
		}
	}
	
	public void buscarTodos() {
		repositorio.buscarTodos();
	}

}
