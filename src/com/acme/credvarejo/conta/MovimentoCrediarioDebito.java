package com.acme.credvarejo.conta;

import java.util.Date;

public class MovimentoCrediarioDebito extends MovimentoCrediario{
		
	public MovimentoCrediarioDebito(ContaCrediario contaCrediario, double valorTransacao, Date dataHoraDaOperacao, double saldo) {
		super(contaCrediario, valorTransacao, dataHoraDaOperacao);
	}
}
