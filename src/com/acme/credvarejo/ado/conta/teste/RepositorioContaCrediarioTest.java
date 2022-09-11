package com.acme.credvarejo.ado.conta.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.conta.RepositorioContaCrediario;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class RepositorioContaCrediarioTest {

	private RepositorioContaCrediario repositorioCrediario;
	private ContaCrediario crediario;
	private Cpf cpfCliente;
	private Cliente novoCliente;
	private IdentificadorContaCrediario identificadorConta;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void inicializar() {
		System.setOut(new PrintStream(outContent));
		cpfCliente = new Cpf(865189220);
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 0);
		identificadorConta = new IdentificadorContaCrediario(10L);
		crediario = new ContaCrediario(identificadorConta, novoCliente, 10, 500, 15, true);
		repositorioCrediario = new RepositorioContaCrediario();
	}

	@Test
	public void incluirContaCrediario() {
		repositorioCrediario.incluir(crediario);
		assertNotNull(repositorioCrediario.getContas()[0]);
	}

	@Test
	public void alterarLimiteCredito() {
		repositorioCrediario.incluir(crediario);
		repositorioCrediario.alterar(identificadorConta, 300);
		assertEquals(300, crediario.getLimiteDeCredito(), 0);
	}

	@Test
	public void exluirContaCrediario() {
		repositorioCrediario.incluir(crediario);
		repositorioCrediario.excluir(identificadorConta);
		assertNull(repositorioCrediario.getContas()[0]);
	}

	@Test
	public void buscarPorChave() {
		repositorioCrediario.incluir(crediario);
		assertEquals(crediario, repositorioCrediario.buscarPorChave(identificadorConta));
	}

	@Test
	public void buscarListaVazia() {
		repositorioCrediario.buscarTodos();
		assertTrue(outContent.toString().isEmpty());
	}
	
	@Test
	public void buscarTodos() {
		repositorioCrediario.incluir(crediario);
		repositorioCrediario.buscarTodos();
		assertFalse(outContent.toString().isEmpty());
	}

}
