package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public void removeHorariosEquals(DiaSemana ds) {

		Map<Integer,Horario> map = new HashMap<Integer,Horario>();
		for (Horario h : this.horarios) map.put(h.getNumero(),h);
		
		ds.getHorarios().forEach( hor -> {
			if(map.remove(hor.getNumero()) == null){
				map.put(hor.getNumero(), hor);
			}
		});
		
		this.horarios = new ArrayList<Horario>(map.values());
	}
	
	
	
}
