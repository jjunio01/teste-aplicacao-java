package com.acme.credvarejo.contaCrediario.teste;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;
import com.acme.credvarejo.contaCrediario.ContaCrediarioEspecial;

public class ContaCrediarioEspecialTest {

	private ContaCrediarioEspecial crediario;
	private IdentificadorContaCrediario identificadorConta;
	private Cliente novoCliente;
	private Cpf cpfCliente;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void inicializar() {
		System.setOut(new PrintStream(outContent));
		cpfCliente = new Cpf(865189220);
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 0);
		identificadorConta = new IdentificadorContaCrediario(10L);
		crediario = new ContaCrediarioEspecial(identificadorConta, novoCliente, 50, 200, 20, true, 10, 20);
	}

	@Test
	public void efetuarPagamentoComDesconto() {
		crediario = new ContaCrediarioEspecial(identificadorConta, novoCliente, 50, 200, 20, true, 2);
		crediario.efetuarPagamento(10, 5);
		assertEquals(37.5, crediario.getSaldoDevido(), 0);
	}

	@Test
	public void efetuarPagamentoComDescontoMaior() {
		crediario.efetuarPagamento(10, 5);
		assertEquals(35.0, crediario.getSaldoDevido(), 0);
	}

	@Test
	public void efetuarPagamento() {
		crediario = new ContaCrediarioEspecial(identificadorConta, novoCliente, 50, 200, 20, true, 0, 10);
		crediario.efetuarPagamento(10, 0);
		assertEquals(40.0, crediario.getSaldoDevido(), 0);
	}

	@Test
	public void verificarPercentualDesconto() {
		assertEquals(10, crediario.getPercentualDeDesconto(),0);
	}
	
	@Test
	public void alterarPercentualDesconto() {
		crediario.setPercentualDeDesconto(20);
		assertEquals(20, crediario.getPercentualDeDesconto(), 0);
	}
	
	@Test
	public void verificarPontosAcumulados() {
		assertEquals(20, crediario.getPontosAcumulados());
	}
	
	
	@Test
	public void atualizarPontosAcumulados() {
		crediario.setPontosAcumulados(569);
		assertEquals(569, crediario.getPontosAcumulados());
	}

}
