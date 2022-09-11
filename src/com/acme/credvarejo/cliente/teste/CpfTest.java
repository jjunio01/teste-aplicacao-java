package com.acme.credvarejo.cliente.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cpf;

public class CpfTest {
	
	Cpf novoCPF;

	@Before
	public void inicializar() {
		novoCPF = new Cpf(6532);
	}
	@Test
	public void verificaDigitoCPF() {
		assertEquals("95", novoCPF.calculaDigitoMod11("865189220", 2, 12, true));
	}
	
	@Test
	public void verificaCPFValido() {
		assertTrue(novoCPF.isCPF("86518922095"));
	}
	
	@Test
	public void verificaCPFInvalido() {
		assertFalse(novoCPF.isCPF("00000000000"));
	}
	
	@Test
	public void verificaCPFFormatado() {
		assertEquals("865.189.220-95", novoCPF.imprimeCPF("86518922095"));
	}

}
