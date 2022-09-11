package com.acme.credvarejo.cliente;

import java.util.Arrays;
import java.util.Date;

import com.acme.credvarejo.classesGerais.*;

public class Cliente extends Registro{
	private Cpf cpf;
	private String nome;
	private int idade;
	private Date clienteDesde;
	private double renda;
	private int sexo;
	private final int MASC = 0;
	private final int FEM = 1;
	
	public Cliente(Cpf cpf, String nome, int idade, Date clienteDesde, double renda, int sexo) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.clienteDesde = clienteDesde;
		this.renda = renda;
		this.sexo = sexo;
	}

	public void gravaNomeCompleto(String nomeCompleto) {
		this.nome = nomeCompleto;
	}
	
	public String getPrimeiroNome() {
		String[] textoSeparado = nome.split(" ");
		Arrays.toString(textoSeparado);
		return textoSeparado[0];
	}
	
	public String getSegundoNome() {
		String[] textoSeparado = nome.split(" ");
		Arrays.toString(textoSeparado);
		return textoSeparado[1];
	}
	
	public Cpf getCpf() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public Date getClienteDesde() {
		return this.clienteDesde;
	}
	
	public double getRenda() {
		return this.renda;
	}
	
	public int getSexo() {
		return this.sexo;
	}
	
	public void setSexo(int novoSexo) {
		this.sexo = novoSexo;
	}
	
	public int getMasc() {
		return this.MASC;
	}

	public int getFem() {
		return this.FEM;
	}
	
	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setClienteDesde(Date clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	public String getChave() {
		long l = this.cpf.getNumero();
		String str = Long.toString(l);

		return str;
	}
	
	public void validar() {
		if(this.cpf != null) {
			if(this.nome != null && this.nome.length() != 0 && this.nome.length() <= 60) {
				if(this.idade > 18 && this.idade < 200) {
					if(this.renda == 0 || this.renda > 0 && this.renda < 1000000) {
						if (this.sexo == this.MASC || this.sexo == this.FEM) {
							System.out.println("Cliente Validado");
						}else {
							System.out.println("Cliente invalido");
						}
					}
				}
			}
		}
	}
	
	//REPOSITÓRIO
		Cliente[] repositorio = new Cliente[150];
}
