package br.com.model.entidades;

public class Gasolina extends Combustivel{
	
	
	public void comprar() {
	double Desconto;
	double valorFinal = 0;
			setPreco(6.30);
			
			if(getLitros()<20) {
				Desconto = getLitros() * 0.04;
				valorFinal = getLitros()* getPreco()-Desconto;
				setValorTotal(valorFinal);
				
			}else {
				
				Desconto =getLitros() * 0.06;
				valorFinal =getLitros()* getPreco()-Desconto;
				setValorTotal(valorFinal);
			}
		
	}
	
	public String imprimir() {
		return "valor total R$:"+getValorTotal();
	}
	
}
