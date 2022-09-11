package com.acme.credvarejo.classesGerais;

public abstract class Registro {
	String chave;
	
	public Registro() {
	}
	
	public abstract String getChave();
	
	public abstract void validar();

	public void setChave(String novaChave) {
		this.chave = novaChave;
	}
}
