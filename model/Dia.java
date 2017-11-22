package model;

public enum Dia {

	SEGUNDA("Segunda-feira",1),
	TERCA("terça-feira",2), 
	QUARTA("Quarta-feira",3),
	QUINTA("Quinta-feira",4),
	SEXTA("Sexta-feira",5), 
	SABADO("Sàbado",6),
	DOMINGO("Domingo",0);
	
	private String nome;
	private Integer numero;
	
	private Dia(String nome, Integer numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumero() {
		return numero;
	}
}
