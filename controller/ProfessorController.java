package controller;

import java.util.List;

import dao.ProfessorDAO;
import dao.SalaDAO;
import exeptions.HorarioExeption;
import model.Professor;
import model.Sala;

public class ProfessorController {

	public void salvar(Professor professor) throws HorarioExeption, Exception{
		checkProfessor(professor);
		ProfessorDAO.obterInstancia().salvar(professor);
	}
	
	public void editar(Professor professor) throws  HorarioExeption, Exception{
		checkProfessor(professor);
		ProfessorDAO.obterInstancia().editar(professor);
	}
	
	public void remover(Professor professor){
		ProfessorDAO.obterInstancia().excluir(professor.getIdProfessor());
	}
	
	public List<Professor> listarTodos(){
		return ProfessorDAO.obterInstancia().listarTodos();
	}
	
	public void checkProfessor(Professor professor) throws HorarioExeption, Exception {
		this.chekMatricula(professor);
		this.chekName(professor);
		this.chekCargaHraria(professor);
		this.chekHorarios(professor);
	}
	
	public List<Professor> pesquisarProfessorPorNome(String codigo){
		return ProfessorDAO.obterInstancia().pesquisarProfessor(codigo.trim());
	}
	
	
	public void chekName(Professor professor) throws Exception {		
		if(professor.getNome().trim().equals("") || 
				professor.getNome().length() < 2){
			throw new Exception("Nome invalido");
		}
	}
	
	public void chekMatricula(Professor professor) throws Exception {		
		if(professor.getMatricula().trim().equals("") || 
				professor.getMatricula().length() < 2){
			throw new Exception("Matricula invalida");
		}
	}
	
	public void chekHorarios(Professor professor) throws  HorarioExeption, Exception {		
		if(professor.getListaDiaSemana() == null || professor.getListaDiaSemana().size() == 0){
			throw new HorarioExeption("Horarios invaidos");
		}
	}
	
	public void chekCargaHraria(Professor professor) throws Exception {		
		if(professor.getCargaHorariaContratada() < 0){
			throw new Exception("Carga horaria invalida");
		}
	}
	
}