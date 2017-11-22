package controller;

import java.util.InputMismatchException;
import java.util.List;
import dao.SalaDAO;
import model.Sala;

public class SalaController {

	public void salvar(Sala sala) throws Exception{
		if(sala.getCodigo().trim().equals("") || 
				sala.getCodigo().length() < 2){
			throw new Exception("Código inválido");
		}
		if(sala.getnMaximoAlunos() <= 0){
			throw new Exception("Capacidade inválida");
		}
		SalaDAO.obterInstancia().salvar(sala);
	}

	public void editar(Sala sala) throws Exception{
		if(!(sala.getIdSala() > 0)){
			throw new Exception("Selecione uma sala");
		}
		if(sala.getCodigo().trim().equals("") || 
				sala.getCodigo().length() < 2){
			throw new Exception("Código inválido");
		}
		if(sala.getnMaximoAlunos() <= 0 ){
			throw new Exception("Capacidade inválida");
		}
		SalaDAO.obterInstancia().editar(sala);
	}

	public void remover(Sala sala) throws Exception{
		if(!(sala.getIdSala() > 0)){
			throw new Exception("Selecione uma sala");
		}
		SalaDAO.obterInstancia().excluir(sala.getIdSala());
	}

	public List<Sala> listarTodos(){
		return SalaDAO.obterInstancia().listarTodos();
	}
	
	public List<Sala> pesquisarSalaPorNome(String codigo){
		return SalaDAO.obterInstancia().pesquisarSala(codigo.trim());
	}

}
