package model;

public class DistribuicaoAutomatica implements Comparable {
	
	private int idDistribuicaoAutomatica;
	private UnidadeCurricular unidadeCurricular;
	private Professor professor;
	private Horario horario;
	private Dia dia;
	private Sala Sala;
	
	public DistribuicaoAutomatica() {
	}

	public int getIdDistribuicaoAutomatica() {
		return idDistribuicaoAutomatica;
	}

	public void setIdDistribuicaoAutomatica(int idDistribuicaoAutomatica) {
		this.idDistribuicaoAutomatica = idDistribuicaoAutomatica;
	}

	public UnidadeCurricular getUnidadeCurricular() {
		return unidadeCurricular;
	}

	public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
		this.unidadeCurricular = unidadeCurricular;
	}

	public Sala getSala() {
		return Sala;
	}

	public void setSala(Sala sala) {
		Sala = sala;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}
	
	@Override
	public int compareTo(Object o) {
		int nAlunos = this.unidadeCurricular.getnAlunos();
		int othersNAlunos = ((DistribuicaoAutomatica) o).getUnidadeCurricular().getnAlunos();
		
		if(nAlunos > othersNAlunos) {
			return 1;
		}else if(nAlunos < othersNAlunos) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		int diaNumero = this.dia.getNumero();
		int horarioNumero = this.horario.getNumero();
		
		int otherDiaNumero = ((Dia)obj).getNumero();
		int otherHorarioNumero = ((Horario)obj).getNumero();
		
		if(diaNumero == otherDiaNumero && horarioNumero == otherHorarioNumero) {
			return true;
		} else {
			return false;
		}
	}

}
