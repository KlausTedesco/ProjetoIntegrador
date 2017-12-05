package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import dao.DistribuicaoAutomaticaDAO;
import dao.SalaDAO;
import jdk.nashorn.internal.runtime.ListAdapter;
import model.DiaSemana;
import model.DistribuicaoAutomatica;
import model.Horario;
import model.Sala;
import view.InserirDadosUI;

public class DistribuicaoAutomaticaController {
	private ArrayList<DistribuicaoAutomatica> listaHorarioSalaOcupada;
	private DistribuicaoAutomaticaDAO daoDistribuicaoAutomatica;
	private SalaDAO daoSalas;
	private InserirDadosUI dados;

	public DistribuicaoAutomaticaController() {
		this.daoDistribuicaoAutomatica = DistribuicaoAutomaticaDAO.obterInstancia();
		this.daoSalas = SalaDAO.obterInstancia();
	}

	// REGRA DE COMO FAZER A DISTRIBUICAO AUTOMATICA
	public void executarDistribuicao() throws Exception{
		listaHorarioSalaOcupada = new ArrayList <>();
		
		List<DistribuicaoAutomatica> listaDistribuicaoAutomatica = daoDistribuicaoAutomatica.listarTodos();
		Collections.sort(listaDistribuicaoAutomatica);
		
		List<Sala> listaSala = daoSalas.listarTodos();
		
		
		for(int i=0; i<listaSala.size(); i++){
			for(int ii=0; ii<listaDistribuicaoAutomatica.size(); ii++){
				
				List<DiaSemana> dsList = listaDistribuicaoAutomatica.get(ii).getProfessor().getListaDiaSemana();
				
				for(DiaSemana ds: dsList) {
					for(Horario h: ds.getHorarios()) {
						
					DistribuicaoAutomatica da = listaDistribuicaoAutomatica.get(ii);
					int nAlunoMax = listaSala.get(i).getnMaximoAlunos();
					int nAlunoDis = listaDistribuicaoAutomatica.get(ii).getUnidadeCurricular().getnAlunos();
					
					
					if(nAlunoDis <= nAlunoMax && !listaHorarioSalaOcupada.contains(da)) {
						
						listaDistribuicaoAutomatica.get(ii).setSala(listaSala.get(i));
						listaDistribuicaoAutomatica.get(ii).setDia(ds.getDia());
						listaDistribuicaoAutomatica.get(ii).setHorario(h);
						
						listaHorarioSalaOcupada.add(listaDistribuicaoAutomatica.get(ii));
					}
				}
				
	
				}
				
				DistribuicaoAutomaticaDAO daoDistribuicaoAutomatica = DistribuicaoAutomaticaDAO.obterInstancia();
				daoDistribuicaoAutomatica.salvar(listaDistribuicaoAutomatica);
				
				/*	buscar lista de salas na SalaDAO 
				
					for da lista de salas 
					dentro fazer outro for que percorra a lista de distribuicaoAuto{
					utilizar somente as distribuicaoAuto que nao possuem sala selecionada
								
				*/
			}
		}
	}

	public void remover(DistribuicaoAutomatica distribuicaoAutomatica) throws Exception {
		if (!(distribuicaoAutomatica.getIdDistribuicaoAutomatica() > 0)) {
			throw new Exception("Selecione uma associação");
		}
		DistribuicaoAutomaticaDAO.obterInstancia().excluir(distribuicaoAutomatica.getIdDistribuicaoAutomatica());
	}

}
