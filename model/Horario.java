package model;

public enum Horario {
	
	AULA1(1,"Aula 1","8:00 - 9:00"),
	AULA2(2,"Aula 2","8:00 - 9:00"),
	AULA3(3,"Aula 3","8:00 - 9:00"),
	AULA4(4,"Aula 4","8:00 - 9:00"),
	AULA5(5,"Aula 5","8:00 - 9:00"),
	AULA6(6,"Aula 6","8:00 - 9:00"),
	AULA7(7,"Aula 7","8:00 - 9:00"),
	AULA8(8,"Aula 8","8:00 - 9:00"),
	AULA9(9,"Aula 9","8:00 - 9:00"),
	AULA10(10,"Aula 10","8:00 - 9:00"),
	AULA11(11,"Aula 11","8:00 - 9:00"),
	AULA12(12,"Aula 12","8:00 - 9:00");
	
	private String nome;
	private String horario;
	private Integer numero;
	
	private Horario(Integer numero,String nome, String horario) {
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
	
	public static Horario getHorario(int n){
	    switch (n) {
		case 1: return Horario.AULA1;
	    case 2: return Horario.AULA2;
	    case 3: return Horario.AULA3;
	    case 4: return Horario.AULA4;
	    case 5: return Horario.AULA5;
	    case 6: return Horario.AULA6;
	    case 7: return Horario.AULA7;
	    case 8: return Horario.AULA8;
	    case 9: return Horario.AULA9;
	    case 10: return Horario.AULA10;
	    case 11: return Horario.AULA11;
	    case 12: return Horario.AULA12;
	    default: return null;
	    }
	}
	
	public boolean equal(Horario horario) {
		return this.getNumero() == horario.numero;
	}
}
