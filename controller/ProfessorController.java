package controller;

import java.util.List;

import dao.ProfessorDAO;
import model.Professor;

public class ProfessorController {

	public void salvar(Professor professor){
		ProfessorDAO.obterInstancia().salvar(professor);
	}
	
	public void editar(Professor professor){
		ProfessorDAO.obterInstancia().editar(professor);
	}
	
	public void remover(Professor professor){
		ProfessorDAO.obterInstancia().excluir(professor.getIdProfessor());
	}
	
	public List<Professor> listarTodos(){
		return ProfessorDAO.obterInstancia().listarTodos();
	}
	
}