package com.acme.credvarejo.conta.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.conta.RepositorioContaCrediario;
import com.acme.credvarejo.ado.conta.RepositorioMovimentoCrediario;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.ControladorContaCrediario;
import com.acme.credvarejo.conta.ControladorMovimentoCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class ControladorContaCrediarioTest {

	private ControladorContaCrediario controladorCrediario;
	private RepositorioContaCrediario repositorioCrediario;
	private Cpf cpfCliente;
	private Cliente novoCliente;
	private ContaCrediario crediario;
	private IdentificadorContaCrediario identificadorConta;
	private ControladorMovimentoCrediario controladorMivimentoCrediario;
	private RepositorioMovimentoCrediario repositorioMovimentoCrediario;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void inicializar() {
		System.setOut(new PrintStream(outContent));
		cpfCliente = new Cpf(865189220);
		novoCliente = new Cliente(cpfCliente, "José Junio", 30, new Date(), 1000, 0);
		identificadorConta = new IdentificadorContaCrediario(10L);
		crediario = new ContaCrediario(identificadorConta, novoCliente, 10, 500, 15, true);
		repositorioCrediario = new RepositorioContaCrediario();
		controladorCrediario = new ControladorContaCrediario(repositorioCrediario);
		repositorioMovimentoCrediario = new RepositorioMovimentoCrediario();
		controladorMivimentoCrediario = new ControladorMovimentoCrediario(repositorioMovimentoCrediario);
	}

	@Test
	public void inserir() {
		controladorCrediario.inserir(novoCliente, 50, 10);
		assertNotNull(repositorioCrediario.getContas()[0]);
	}	
	
	
	@Test
	public void buscraIdentificarInvalido() {
		controladorCrediario.buscar(null);
		assertEquals("Inv�lido!", outContent.toString().trim());
	}
	
	
	
	@Test
	public void creditarIdInvalido() {
		controladorCrediario.creditar(null, 0, controladorMivimentoCrediario);;
		assertEquals("Inv�lido!", outContent.toString().trim());
	}
	
	@Test
	public void devitarIdInvalido() {
		controladorCrediario.debitar(null, 0, controladorMivimentoCrediario);;
		assertEquals("Inv�lido!", outContent.toString().trim());
	}
	
	@Test
	public void creditarInvalido() {
		repositorioCrediario.incluir(crediario);
		controladorCrediario.creditar(crediario.getIdentificadorConta(), 20, controladorMivimentoCrediario);
		assertEquals("Movimento Validado", outContent.toString().trim());
	}
	
	

	@Test
	public void debitarInvalido() {
		repositorioCrediario.incluir(crediario);
		controladorCrediario.debitar(crediario.getIdentificadorConta(), 20, controladorMivimentoCrediario);
		assertEquals("Movimento Validado", outContent.toString().trim());
	}

}
