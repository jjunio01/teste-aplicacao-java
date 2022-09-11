package com.acme.credvarejo.cliente.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.cliente.RepositorioCliente;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.ControladorCliente;
import com.acme.credvarejo.cliente.Cpf;

public class ControladorClienteTest {

	private ControladorCliente clienteControlador;
	private Cpf cpfCliente;
	private Cliente novoCliente;
	private RepositorioCliente clienteRepositorio;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void inicializar() {
		System.setOut(new PrintStream(outContent));
		cpfCliente = new Cpf(865189220);
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 0);
		clienteRepositorio = new RepositorioCliente(0);
		clienteControlador = new ControladorCliente(clienteRepositorio);
	}

	@After
	public void finalizar() throws IOException {
		outContent.close();
	}

	@Test
	public void incluirClienteValido() {
		clienteControlador.incluir(novoCliente);
		assertEquals(1, clienteRepositorio.posicao);
	}

	@Test
	public void incluirClienteNulo() {
		clienteControlador.incluir(null);
		assertEquals("Inválido!", outContent.toString().trim());
	}

	@Test
	public void alterarNomeCliente() {
		clienteControlador.incluir(novoCliente);
		clienteControlador.alterar(865189220, "Junio Araújo");
		assertEquals("Junio Araújo", novoCliente.getNome());
	}

	@Test
	public void excluirCliente() {
		clienteControlador.incluir(novoCliente);
		clienteControlador.excluir(865189220);
		assertEquals(0, clienteRepositorio.posicao);
	}

	@Test
	public void excluirClienteInvalido() {
		clienteControlador.excluir(0);
		assertEquals("CPF inválido!", outContent.toString().trim());
	}

	@Test
	public void buscarClienteCPFInvalido() {
		clienteControlador.buscar(0);
		assertEquals("CPF inválido!", outContent.toString().trim());
	}

	@Test
	public void buscarClientePorChaveInvalida() {
		clienteRepositorio.buscarPorChave(0);
		assertEquals("Inválido", outContent.toString().trim());
	}
	
	@Test
	public void buscarClientePorChave() {
		clienteControlador.incluir(novoCliente);
		outContent.reset();
		clienteRepositorio.buscarPorChave(865189220);
		assertEquals("Cliente: José Junio", outContent.toString().trim());
	}
	
	
	@Test
	public void buscarTodosClienteRepositorioVazio() {
		clienteRepositorio.buscarTodos();
		assertEquals("Vazio!", outContent.toString().trim());
	}
	
	@Test
	public void buscarTodosClienteRepositorio() {
		clienteControlador.incluir(novoCliente);
		outContent.reset();
		clienteRepositorio.buscarTodos();
		assertNotEquals("Vazio!", outContent.toString().trim());
	}

}
