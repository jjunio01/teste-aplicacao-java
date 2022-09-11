package com.acme.credvarejo.ado.cliente;

import com.acme.credvarejo.cliente.Cliente;

public interface InterfaceRepositorioCliente {
	
	
	public void incluir(Cliente novoCliente);
	
	public void alterar(long cpf, String nome);
	
	public void excluir(long cpf);
	
	public void buscarPorChave(long cpf);
	
	public void buscarTodos();
}
