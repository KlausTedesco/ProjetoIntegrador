package controller;

import java.util.List;
import dao.UnidadeCurricularDAO;
import model.UnidadeCurricular;

public class UnidadeCurricularController {

	public void salvar(UnidadeCurricular unidadeCurricular) throws Exception{
		if(unidadeCurricular.getCodigoUnidade().trim().equals("") || 
				unidadeCurricular.getCodigoUnidade().length() < 2){
			throw new Exception("Unidade inválida");
		}
		if(unidadeCurricular.getNomeCurso().trim().equals("") || 
				unidadeCurricular.getNomeCurso().length() < 2){
			throw new Exception("Curso inválido");
		}
		UnidadeCurricularDAO.obterInstancia().salvar(unidadeCurricular);
	}

	public void editar(UnidadeCurricular unidadeCurricular) throws Exception{
		if(unidadeCurricular.getCodigoUnidade().trim().equals("") || 
				unidadeCurricular.getCodigoUnidade().length() < 2){
			throw new Exception("Unidade inválida");
		}
		if(unidadeCurricular.getNomeCurso().trim().equals("") || 
				unidadeCurricular.getNomeCurso().length() < 2){
			throw new Exception("Curso inválido");
		}
		UnidadeCurricularDAO.obterInstancia().editar(unidadeCurricular);
	}

	public void remover(UnidadeCurricular unidadeCurricular) throws Exception{
		if(!(unidadeCurricular.getIdUnidadeCurricular() > 0)){
			throw new Exception("Selecione uma unidade curricular");
		}
		UnidadeCurricularDAO.obterInstancia().excluir(unidadeCurricular.getIdUnidadeCurricular());
	}

	public List<UnidadeCurricular> listarTodos(){
		return UnidadeCurricularDAO.obterInstancia().listarTodos();
	}
	
	public List<UnidadeCurricular> pesquisarUnidadeCurricularPorNome(String codigo){
		return UnidadeCurricularDAO.obterInstancia().pesquisarUnidadeCurricular(codigo.trim());
	}
	
}