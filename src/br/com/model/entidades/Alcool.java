package br.com.model.entidades;

public class Alcool extends Combustivel {
	
	public void comprar()
	{
		double Desconto;
		double valorFinal = 0;
		
			setPreco(5.90);
			if(getLitros()<20) {
				Desconto = getLitros() * 0.03;
				valorFinal = getLitros()* getPreco()-Desconto;
				setValorTotal(valorFinal);
			}else {
				Desconto =getLitros() * 0.05;
				valorFinal =getLitros()* getPreco()-Desconto;
				setValorTotal(valorFinal);
			}
			
	}
	
	public String imprimir() {
		return "valor total R$:"+getValorTotal();
	}
}
