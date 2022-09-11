package com.acme.credvarejo.classesGerais;

public interface InterfaceRepositorioRegistro {
	
	public void incluir(String chave);
	
	public void alterar(String chave, String novaChave);
	
	public void excluir(String chave);
	
	public void buscarChave(String chave);
	
	public void buscarTodos();
}
