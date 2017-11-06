package controller;

import java.util.List;

import dao.SalaDAO;
import model.Sala;

public class SalaController {

	public void salvar(Sala sala){
		SalaDAO.obterInstancia().salvar(sala);
	}
	
	public void editar(Sala sala){
		SalaDAO.obterInstancia().editar(sala);
	}
	
	public void remover(Sala sala){
		SalaDAO.obterInstancia().excluir(sala.getIdSala());
	}
	
	public List<Sala> listarTodos(){
		return SalaDAO.obterInstancia().listarTodos();
	}
	
}
