package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DistribuicaoAutomaticaDAO;
import model.DistribuicaoAutomatica;
import model.Sala;
import view.InserirDadosUI;

public class DistribuicaoAutomaticaController {
	
	
	 //REGRA DE COMO FAZER A DISTRIBUICAO AUTOMATICA 
	public void executarDistribuicao(ArrayList <Sala> listaSalas) throws Exception{
		for(int i=0; i<listaSalas.size(); i++){
			for(int ii=0; ii<listadistribuicaoAutomatica; ii++){
			
				/*	buscar lista de salas na SalaDAO 
				
					for da lista de salas 
					dentro fazer outro for que percorra a lista de distribuicaoAuto{
					utilizar somente as distribuicaoAuto que nao possuem sala selecionada
				
			
					if(distribuicaoAutomatica.getSala().getnMaximoAlunos() < distribuicaoAutomatica.getUnidadeCurricular().getnAlunos()){
						throw new Exception("Numero de alunos maior que capacidade da sala");
					}
					if(distribuicaoAutomatica.){
						throw new Exception("Capacidade inválida");
					}
					if(!(distribuicaoAutomatica.getIdDistribuicaoAutomatica() > 0)){
						throw new Exception("Selecione uma distribuicao Automatica");
					}
					if(distribuicaoAutomatica.getCodigo().trim().equals("")distribuicaoAutomatica.getCodigo().length() < 2){
						throw new Exception("Código inválido");
					}
					if(distribuicaoAutomatica.getnMaximoAlunos() <= 0 ){
						throw new Exception("Capacidade inválida");
					}
					DistribuicaoAutomaticaDAO.obterInstancia().editar(distribuicaoAutomatica);				
				*/
			}
		}
	}
	public void remover(DistribuicaoAutomatica distribuicaoAutomatica) throws Exception{
		if(!(distribuicaoAutomatica.getIdDistribuicaoAutomatica() > 0)){
			throw new Exception("Selecione uma associação");
		}
		DistribuicaoAutomaticaDAO.obterInstancia().excluir(distribuicaoAutomatica.getIdDistribuicaoAutomatica());
	}

}
