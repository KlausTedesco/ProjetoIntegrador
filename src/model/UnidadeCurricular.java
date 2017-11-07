package model;

import java.time.LocalDate;

public class UnidadeCurricular {
	
	private int idUnidadeCurricular;
	private String codigoUnidade;
	private String nomeCurso;
	private int faseCurso;
	private int nAlunos;
	private String equipamentos;
	private Professor professor;
	private Double cargaHorariaMateria;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	
	public UnidadeCurricular() {
	}

	public UnidadeCurricular(String codigoUnidade, String nomeCurso, int faseCurso) {
		super();
		this.codigoUnidade = codigoUnidade;
		this.nomeCurso = nomeCurso;
		this.faseCurso = faseCurso;
	}

	public int getIdUnidadeCurricular() {
		return idUnidadeCurricular;
	}

	public void setIdUnidadeCurricular(int idUnidadeCurricular) {
		this.idUnidadeCurricular = idUnidadeCurricular;
	}

	public String getCodigoUnidade() {
		return codigoUnidade;
	}

	public void setCodigoUnidade(String codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getFaseCurso() {
		return faseCurso;
	}

	public void setFaseCurso(int faseCurso) {
		this.faseCurso = faseCurso;
	}

	public int getnAlunos() {
		return nAlunos;
	}

	public void setnAlunos(int nAlunos) {
		this.nAlunos = nAlunos;
	}

	public String getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Double getCargaHorariaMateria() {
		return cargaHorariaMateria;
	}

	public void setCargaHorariaMateria(Double cargaHorariaMateria) {
		this.cargaHorariaMateria = cargaHorariaMateria;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return codigoUnidade;
	}
	
	
	
	

}
