package com.acme.credvarejo.ado.cliente;

import com.acme.credvarejo.classesGerais.Repositorios;
import com.acme.credvarejo.cliente.Cliente;

public class RepositorioCliente implements InterfaceRepositorioCliente{
	public int posicao = 0;
	public Repositorios repositorios = new Repositorios(posicao);
	
	public RepositorioCliente(int posicao) {
		this.posicao = posicao;
	}
	
	public void incluir(Cliente novoCliente) {
		repositorios.setClienteRepo(posicao, novoCliente);
		posicao++;
	}
	
	//altera nome
	public void alterar(long cpf, String nome) {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
		
		int impressao = 0;
		
		for(int i = 0; i < posicao; i++) {
			if(repositorios.getClienteRepo(i).getCpf().getNumero() == cpf) {
				impressao++;
				repositorios.getClienteRepo(i).setNome(nome);
			}
		}
		
		if(impressao == 0) {
			System.out.println("Inválido!");
		}
	}
	
	public void excluir(long cpf) {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
		
		for(int i = 0; i < posicao; i++) {
			if(repositorios.getClienteRepo(i).getCpf().getNumero() == cpf) {
				repositorios.setClienteRepo(i, null);
				repositorios.setClienteRepo(i, repositorios.getClienteRepo(posicao - 1));
				repositorios.setClienteRepo(posicao - 1, null);
				posicao--;
			}
		}
	}
	
	public void buscarPorChave(long cpf) {
		int impressoes = 0;
		
		for(int i = 0; i < posicao; i++) {
			if(repositorios.getClienteRepo(i).getCpf().getNumero() == cpf) {
				impressoes++;
				System.out.println("Cliente: "+repositorios.getClienteRepo(i).getNome());
			}
		}
		
		if(impressoes == 0) {
			System.out.printf("Inválido");
		}
	}
	
	public void buscarTodos() {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
		
		for(int i = 0; i < posicao; i++) {
			System.out.println("Cliente: "+repositorios.getClienteRepo(i).getNome()+"\n");
		}
	}

}
