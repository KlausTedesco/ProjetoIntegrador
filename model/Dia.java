package model;

public enum Dia {

	SEGUNDA(1,"Segunda-feira"),
	TERCA(2,"terça-feira"), 
	QUARTA(3,"Quarta-feira"),
	QUINTA(4,"Quinta-feira"),
	SEXTA(5,"Sexta-feira"), 
	SABADO(6,"Sàbado"),
	DOMINGO(7,"Domingo");
	
	private String nome;
	private Integer numero;
	
	private Dia(Integer numero, String nome) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public static Dia getDia(int n){
	    switch (n) {
			case 1: return Dia.SEGUNDA;
		    case 2: return Dia.TERCA;
		    case 3: return Dia.QUARTA;
		    case 4: return Dia.QUINTA;
		    case 5: return Dia.SEXTA;
		    case 6: return Dia.SABADO;
		    case 7: return Dia.DOMINGO;
	    default: return null;
	    }
	}
}
