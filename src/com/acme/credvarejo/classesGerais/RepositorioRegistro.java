package com.acme.credvarejo.classesGerais;


public class RepositorioRegistro implements InterfaceRepositorioRegistro{
	public int posicao;
	Registro[] identificavelRepo = new Registro[150];
	
	
	public RepositorioRegistro(int posicao){
		this.posicao=posicao;
	}
	
	public void incluir(String chave) {
		identificavelRepo[posicao].setChave(chave);
		posicao++;
	}
	
	public void alterar(String chave, String novaChave) {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
			int impressao = 0;
			
			for(int i = 0; i < posicao; i++) {
				if(identificavelRepo[i].getChave().equals(chave)) {
					impressao++;
					identificavelRepo[i].setChave(novaChave);
				}
			
			}
		
		if(impressao == 0) {
			System.out.println("Chave Inválida!");
		}
	}
	
	public void excluir(String chave) {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
		
		for(int i = 0; i < posicao; i++) {
			if(identificavelRepo[i].getChave().equals(chave)) {
				identificavelRepo[i] = null;
				identificavelRepo[i] = identificavelRepo[posicao - 1];
				identificavelRepo[posicao - 1] = null;
				posicao--;
			}
		}
	}
	
	public void buscarChave(String chave) {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
			for(int i = 0; i < posicao; i++) {
				if(identificavelRepo[i].getChave().equals(chave)) {
					System.out.println("Chave: "+identificavelRepo[i].getChave());
				}
			
			}
	}
	
	public void buscarTodos() {
		if(posicao == 0) {
			System.out.println("Vazio!");
		}
		
		for(int i = 0; i < posicao; i++) {
			System.out.println(identificavelRepo[i].getChave()+"\n");
		}
	}
	
}