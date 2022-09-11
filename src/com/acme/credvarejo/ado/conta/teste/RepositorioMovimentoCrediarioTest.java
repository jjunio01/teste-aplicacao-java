package com.acme.credvarejo.ado.conta.teste;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.conta.RepositorioMovimentoCrediario;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;
import com.acme.credvarejo.conta.MovimentoCrediarioCredito;
import com.acme.credvarejo.conta.MovimentoCrediarioDebito;

public class RepositorioMovimentoCrediarioTest {

	private RepositorioMovimentoCrediario repositorioMovimento;
	private MovimentoCrediarioCredito movimentoCredito;
	private MovimentoCrediarioDebito movimentoDebito;
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
		repositorioMovimento = new RepositorioMovimentoCrediario();
		movimentoCredito = new MovimentoCrediarioCredito(crediario, 5, new Date(), 10);
		movimentoDebito = new MovimentoCrediarioDebito(crediario, 50, new Date(), 0);
	}

	@Test
	public void buscarTodosListaVazia() {
		repositorioMovimento.buscarTodos();
		assertEquals(23, outContent.toString().length());
	}
	
	@Test
	public void buscarTodosCredito() {
		repositorioMovimento.incluirCredito(movimentoCredito);
		repositorioMovimento.buscarTodos();
		assertEquals(150, outContent.toString().length());
	}
	
	@Test
	public void buscarTodosDebito() {
		repositorioMovimento.incluirDebito(movimentoDebito);
		repositorioMovimento.buscarTodos();
		assertEquals(151, outContent.toString().length());
	}

}
