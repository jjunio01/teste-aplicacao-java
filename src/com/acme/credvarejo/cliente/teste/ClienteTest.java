package com.acme.credvarejo.cliente.teste;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class ClienteTest {

	private Cliente novoCliente;
	private Cpf cpfCliente;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void inicializar() {
		System.setOut(new PrintStream(outContent));
		cpfCliente = new Cpf(865189220);
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 0);
	}

	@After
	public void finalizar() throws IOException {
		outContent.close();
	}

	@Test
	public void verificaPrimeiroNomeCliente() {
		assertEquals("José", novoCliente.getPrimeiroNome());
	}

	@Test
	public void verificaChave() {
		assertEquals("865189220", novoCliente.getChave());
	}

	@Test
	public void verificaSegundoNomeCliente() {
		assertEquals("Junio", novoCliente.getSegundoNome());
	}

	@Test
	public void verificaClienteValido() {
		novoCliente.validar();
		assertEquals("Cliente Validado", outContent.toString().trim());

	}
	
	@Test
	public void verificaClienteInvalido() {
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 5);
		novoCliente.validar();
		assertEquals("Cliente invalido", outContent.toString().trim());

	}

	@Test
	public void verificarNomeCompleto() {
		novoCliente.gravaNomeCompleto("José Junio Araújo da Silva");
		assertEquals("José Junio Araújo da Silva", novoCliente.getNome());
	}

}
