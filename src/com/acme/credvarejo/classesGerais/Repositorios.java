package com.acme.credvarejo.classesGerais;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.MovimentoCrediarioCredito;
import com.acme.credvarejo.conta.MovimentoCrediarioDebito;

public class Repositorios extends RepositorioRegistro{
	
	private Cliente[] clienteRepo = new Cliente[150];
	private ContaCrediario[] contaCrediarioRepo = new ContaCrediario[150];
	private MovimentoCrediarioCredito[] movimentoCrediarioCreditoRepo = new MovimentoCrediarioCredito[150];
	private MovimentoCrediarioDebito[] movimentoCrediarioDebitoRepo = new MovimentoCrediarioDebito[150];
	
	
	public Repositorios(int posicao) {
		super(posicao);
	}
	
	public void setClienteRepo(int i, Cliente clienteRepo) {
		this.clienteRepo[i] = clienteRepo;
	}
	
	public Cliente getClienteRepo(int i) {
		return clienteRepo[i];
	}
	
	public void setContaCrediarioRepo(int i, ContaCrediario contaCrediarioRepo) {
		this.contaCrediarioRepo[i] = contaCrediarioRepo;
	}
	
	public ContaCrediario getContaCrediarioRepo(int i) {
		return contaCrediarioRepo[i];
	}
	
	public void setMovimentoCrediarioCreditoRepo(int i, MovimentoCrediarioCredito movimentoCrediarioCreditoRepo) {
		this.movimentoCrediarioCreditoRepo[i] = movimentoCrediarioCreditoRepo;
	}
	
	public MovimentoCrediarioCredito getMovimentoCrediarioCreditoRepo(int i) {
		return movimentoCrediarioCreditoRepo[i];
	}
	
	public void setMovimentoCrediarioDebitoRepo(int i, MovimentoCrediarioDebito movimentoCrediarioDebitoRepo) {
		this.movimentoCrediarioDebitoRepo[i] = movimentoCrediarioDebitoRepo;
	}
	
	public MovimentoCrediarioDebito getMovimentoCrediarioDebitoRepo(int i) {
		return movimentoCrediarioDebitoRepo[i];
	}
}