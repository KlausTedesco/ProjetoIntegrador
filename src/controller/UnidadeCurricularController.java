package controller;

import java.util.List;

import dao.UnidadeCurricularDAO;
import model.UnidadeCurricular;

public class UnidadeCurricularController {

	public void salvar(UnidadeCurricular unidadeCurricular){
		UnidadeCurricularDAO.obterInstancia().salvar(unidadeCurricular);
	}
	
	public void editar(UnidadeCurricular unidadeCurricular){
		UnidadeCurricularDAO.obterInstancia().editar(unidadeCurricular);
	}
	
	public void remover(UnidadeCurricular unidadeCurricular){
		UnidadeCurricularDAO.obterInstancia().excluir(unidadeCurricular.getIdUnidadeCurricular());
	}
	
	public List<UnidadeCurricular> listarTodos(){
		return UnidadeCurricularDAO.obterInstancia().listarTodos();
	}
	
}