package com.acme.credvarejo.conta;

import java.util.Date;

public class MovimentoCrediarioCredito extends MovimentoCrediario{
	
	public MovimentoCrediarioCredito (ContaCrediario contaCrediario, double valorTransacao, Date dataHoraDaOperacao, double saldo) {
		super(contaCrediario, valorTransacao, dataHoraDaOperacao);
	}
}
