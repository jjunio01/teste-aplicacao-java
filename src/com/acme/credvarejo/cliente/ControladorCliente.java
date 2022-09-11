package com.acme.credvarejo.cliente;

import com.acme.credvarejo.ado.cliente.InterfaceRepositorioCliente;

public class ControladorCliente {
	private InterfaceRepositorioCliente repositorio;
	
	public ControladorCliente(InterfaceRepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}
	
	public void incluir(Cliente cliente) {
		if(cliente == null) {
			System.out.println("Inválido!");
		}else {
			cliente.validar();
			repositorio.incluir(cliente);
		}
	}
	
	public void alterar(long atual, String nova) {
		repositorio.alterar(atual, nova);
	}
	
	public void excluir(long valor) {
		if(valor == 0) {
			System.out.println("CPF inválido!");
		}else {
			repositorio.excluir(valor);
		}
	}
	
	public void buscar(long valor) {
		if(valor == 0) {
			System.out.println("CPF inválido!");
		}else {
			repositorio.buscarPorChave(valor);
		}
	}
	
	public void buscarTodos() {
		repositorio.buscarTodos();
	}
}
