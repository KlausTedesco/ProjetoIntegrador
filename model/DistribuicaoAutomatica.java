package model;

public class DistribuicaoAutomatica {
	
	private int idDistribuicaoAutomatica;
	private UnidadeCurricular UnidadeCurricular;
	private Professor professor;
	private Sala Sala;
	private CargaHorariaENUM cargaHoraria;
	
	public DistribuicaoAutomatica() {
	}

	public int getIdDistribuicaoAutomatica() {
		return idDistribuicaoAutomatica;
	}

	public void setIdDistribuicaoAutomatica(int idDistribuicaoAutomatica) {
		this.idDistribuicaoAutomatica = idDistribuicaoAutomatica;
	}

	public UnidadeCurricular getUnidadeCurricular() {
		return UnidadeCurricular;
	}

	public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
		UnidadeCurricular = unidadeCurricular;
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

	public CargaHorariaENUM getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHorariaENUM cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
    

}
