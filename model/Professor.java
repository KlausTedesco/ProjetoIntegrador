package model;

public class Professor {
	
	private int idProfessor;
	private String nome;
	private String matricula;
	private Double cargaHorariaContratada;
	private String formacao;
	private ArrayList<DiaSemana> ListaDiaSemana;
	private Horario horario;

	public Professor() {
	}

	public Professor(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getCargaHorariaContratada() {
		return cargaHorariaContratada;
	}

	public void setCargaHorariaContratada(Double cargaHorariaContratada) {
		this.cargaHorariaContratada = cargaHorariaContratada;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	

}
