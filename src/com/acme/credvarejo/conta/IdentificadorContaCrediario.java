package com.acme.credvarejo.conta;

public class IdentificadorContaCrediario {
	private Long numero;
	
	public IdentificadorContaCrediario(Long numero) {
		this.numero = numero;
	}
	
	public int calcularDigitoVerificador() {
		Long soma = (somaNumeros(numero) % 11);
		return soma.intValue();
	}
	
	public static Long somaNumeros(Long numero){
        String numeros;
        int x;
        Long soma = 0L;
        numeros = numero.toString();
        x = numeros.length();
        if ( x == 0 ){
            soma = 0L;
        } else if ( x == 1 ){
            soma = numero;
        } else if ( x > 1 ){
            for(char numeroParaSoma: numeros.toCharArray()){
                soma += Long.valueOf(Character.toString(numeroParaSoma));
            }     
        }  
        return soma;
    }
			
	public boolean verificarValidadeDigito(int valor) {
		if(valor == calcularDigitoVerificador()) {
			return true;
		}else {
			return false;
		}
	}
	
	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long novoNumero) {
		this.numero = novoNumero;
	}
}
