package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiaSemana {

	private String nome;
	private Dia dia;
	private List<Horario> horarios;
	
	public DiaSemana(String nome, Dia dia, List<Horario> horarios) {
		this(nome,dia);
		this.horarios = setHorarios(horarios);
	}
	
	public DiaSemana(String nome, Dia dia, Horario horario) {
		this.nome = nome;
		this.dia = dia;
		this.horarios = setHorarios(horario);
	}
	
	public DiaSemana(String nome, Dia dia) {
		this.nome = nome;
		this.dia = dia;
	}
	
	public List<Horario> setHorarios(List<Horario> horarios) {
		return horarios.stream().distinct().collect(Collectors.toList());
	}
	
	public List<Horario> setHorarios(Horario horario) {
		if(horarios == null) horarios = new ArrayList<Horario>();
		horarios.add(horario);
		return horarios;
	}

	public String getNome() {
		return nome;
	}

	public Dia getDia() {
		return dia;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}
	
	
	
}
