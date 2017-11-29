package dao;

import java.sql.Connection;
import java.util.ArrayList;

import model.DistribuicaoAutomatica;

public class DistribuicaoAutomaticaDAO {
	
	private static DistribuicaoAutomaticaDAO instancia;
	public ArrayList<DistribuicaoAutomatica> listaXXXX;
	private Connection con = ConnectionUtil.getConnection();

	public static DistribuicaoAutomaticaDAO obterInstancia(){
		if (instancia == null){
			instancia = new DistribuicaoAutomaticaDAO();
		}
		return instancia;
	}


}
