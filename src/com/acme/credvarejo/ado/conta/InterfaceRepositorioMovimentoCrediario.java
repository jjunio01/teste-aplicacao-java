package com.acme.credvarejo.ado.conta;

import com.acme.credvarejo.conta.MovimentoCrediarioCredito;
import com.acme.credvarejo.conta.MovimentoCrediarioDebito;

public interface InterfaceRepositorioMovimentoCrediario {
	
	public void incluirCredito(MovimentoCrediarioCredito c);
	
	public void incluirDebito(MovimentoCrediarioDebito d);
	
	public void buscarTodos();
}
