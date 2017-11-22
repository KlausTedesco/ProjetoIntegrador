package model;

public enum Horario {
	
	AULA1("Aula 1","8:00 - 9:00",0),
	AULA2("Aula 2","8:00 - 9:00",1),
	AULA3("Aula 3","8:00 - 9:00",2),
	AULA4("Aula 4","8:00 - 9:00",3),
	AULA5("Aula 5","8:00 - 9:00",4),
	AULA6("Aula 6","8:00 - 9:00",5),
	AULA7("Aula 7","8:00 - 9:00",6),
	AULA8("Aula 8","8:00 - 9:00",7),
	AULA9("Aula 9","8:00 - 9:00",8),
	AULA10("Aula 10","8:00 - 9:00",9),
	AULA11("Aula 11","8:00 - 9:00",10),
	AULA12("Aula 12","8:00 - 9:00",11);
	
	private String nome;
	private String horario;
	private Integer numero;
	
	private Horario(String nome, String horario, Integer numero) {
		this.nome = nome;
		this.horario = horario;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public String getHorario() {
		return horario;
	}
	
	public Integer getNumero() {
		return numero;
	}
}
