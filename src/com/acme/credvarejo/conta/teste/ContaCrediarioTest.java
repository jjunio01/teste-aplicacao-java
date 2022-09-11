package com.acme.credvarejo.conta.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class ContaCrediarioTest {

	private ContaCrediario crediario;
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
		crediario = new ContaCrediario(identificadorConta, novoCliente, 10, 500, 15, true);
	}

	@Test
	public void verificarContaCrediarioValida() {
		crediario.validar();
		assertEquals("Conta Validada", outContent.toString().trim());
	}

	@Test
	public void verificarContaCrediarioInvalida() {
		crediario = new ContaCrediario(identificadorConta, novoCliente, -60, 500, 15, true);
		crediario.validar();
		assertEquals("Conta invalida", outContent.toString().trim());
	}

	@Test
	public void efetuarCompra() {
		crediario.efetuarCompra(10);
		assertEquals(20, crediario.getSaldoDevido(), 0);
	}

	@Test
	public void desativar() {
		assertFalse(crediario.desativar());
	}

	@Test
	public void reativar() {
		assertTrue(crediario.reativar());
	}

	@Test
	public void alterarIdentificador() {
		crediario.setIdentificadorConta(new IdentificadorContaCrediario(6L));
		assertEquals(6L, crediario.getIdentificadorConta().getNumero());
	}

	@Test
	public void atualizarCliente() {
		novoCliente = new Cliente(new Cpf(22L), "Novo", 32, new Date(), 50, 0);
		crediario.setCliente(novoCliente);
		assertEquals("Novo", crediario.getCliente().getNome());

	}

	@Test
	public void verificarVencimento() {
		assertEquals(15, crediario.getVencimento());
	}

	@Test
	public void alterarVencimento() {
		crediario.setVencimento(31);
		assertEquals(31, crediario.getVencimento());
	}

	@Test
	public void estaAtiva() {
		assertTrue(crediario.isAtiva());
	}

	@Test
	public void verificarChave() {
		assertEquals("10", crediario.getChave());
	}

}
