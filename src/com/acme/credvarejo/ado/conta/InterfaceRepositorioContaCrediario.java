package com.acme.credvarejo.ado.conta;

import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public interface InterfaceRepositorioContaCrediario {
	
	public void incluir(ContaCrediario c);
	
	public void alterar(IdentificadorContaCrediario atual, double nova);
	
	public void excluir(IdentificadorContaCrediario numero);

	public ContaCrediario buscarPorChave(IdentificadorContaCrediario id);
	
	public void buscarTodos();
}
