package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {

	private int idProfessor;
	private String nome;
	private String matricula;
	private Double cargaHorariaContratada;
	private String formacao;
	private List<DiaSemana> ListaDiaSemana;
	private List<UnidadeCurricular> unidadeCurriculares;

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

	public List<DiaSemana> getListaDiaSemana() {
		return ListaDiaSemana;
	}

	public void setListaDiaSemana(List<DiaSemana> listaDiaSemana) {
		ListaDiaSemana = listaDiaSemana;
	}

	public void setListaDiaSemana(DiaSemana diaSemana) {
		if (ListaDiaSemana == null) ListaDiaSemana = new ArrayList<DiaSemana>();
		ListaDiaSemana.add(diaSemana);
	}

	public List<UnidadeCurricular> getUnidadeCurriculares() {
		return unidadeCurriculares;
	}

	public void setUnidadeCurriculares(List<UnidadeCurricular> uni) {
		this.unidadeCurriculares = uni;
	}
}
