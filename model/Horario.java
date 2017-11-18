package model;

public enum Horario {
	
	AULA1("Aula 1","8:00 - 9:00"),
	AULA2("Aula 2","8:00 - 9:00"),
	AULA3("Aula 3","8:00 - 9:00"),
	AULA4("Aula 4","8:00 - 9:00"),
	AULA5("Aula 5","8:00 - 9:00"),
	AULA6("Aula 6","8:00 - 9:00"),
	AULA7("Aula 7","8:00 - 9:00"),
	AULA8("Aula 8","8:00 - 9:00"),
	AULA9("Aula 9","8:00 - 9:00"),
	AULA10("Aula 10","8:00 - 9:00"),
	AULA11("Aula 11","8:00 - 9:00"),
	AULA12("Aula 12","8:00 - 9:00");
	
	private String nome;
	private String horario;
	
	private Horario(String nome, String horario) {
		this.nome = nome;
		this.horario = horario;
	}

	public String getNome() {
		return nome;
	}

	public String getHorario() {
		return horario;
	}
	
	

}
