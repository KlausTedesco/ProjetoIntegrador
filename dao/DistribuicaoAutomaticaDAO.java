package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DistribuicaoAutomatica;


public class DistribuicaoAutomaticaDAO {
	
	private static DistribuicaoAutomaticaDAO instancia;
	public ArrayList<DistribuicaoAutomatica> listaDistribuicaoAutomatica;
	private Connection con = ConnectionUtil.getConnection();

	public static DistribuicaoAutomaticaDAO obterInstancia(){
		if (instancia == null){
			instancia = new DistribuicaoAutomaticaDAO();
		}
		return instancia;
		
	}
	public void salvar(List<DistribuicaoAutomatica> listaDistribuicaoAutomatica2){
		try {
			for(int i=0; i<listaDistribuicaoAutomatica2.size(); i++){
				String sql = "INSERT INTO distribuicaoAutomatica "
				+ "(idProfessor, idSala, idUnidadeCurricular) "
				+ "VALUES (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, listaDistribuicaoAutomatica2.get(i).getProfessor().getIdProfessor());
				pstmt.setInt(2, listaDistribuicaoAutomatica2.get(i).getSala().getIdSala());
				pstmt.setInt(3, listaDistribuicaoAutomatica2.get(i).getUnidadeCurricular().getIdUnidadeCurricular());
				pstmt.execute();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void excluir(int id){
		try {
			String sql = "DELETE FROM distribuicaoAutomatica WHERE idDistribuicaoAutomatica = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void editar(DistribuicaoAutomatica distribuicaoAutomatica){
		try {
			String sql = "UPDATE distribuicaoAutomatica SET idProfessor = ?, "
					+ "idSala = ?, idUnidadeCurricular = ? "
					+ "WHERE idDistribuicaoAutomatica = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, distribuicaoAutomatica.getProfessor().getIdProfessor());
			pstmt.setInt(2, distribuicaoAutomatica.getSala().getIdSala());
			pstmt.setInt(3, distribuicaoAutomatica.getUnidadeCurricular().getIdUnidadeCurricular());
			pstmt.setInt(4, distribuicaoAutomatica.getIdDistribuicaoAutomatica());
			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public List<DistribuicaoAutomatica> listarTodos(){
		listaDistribuicaoAutomatica = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM DistribuicaoAutomatica";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				DistribuicaoAutomatica distribuicaoAutomatica = new DistribuicaoAutomatica();
				distribuicaoAutomatica.setIdDistribuicaoAutomatica(rs.getInt("idDistribuicaoAutomatica"));
				distribuicaoAutomatica.getProfessor().setIdProfessor(rs.getInt("idProfessor"));
				distribuicaoAutomatica.getSala().setIdSala(rs.getInt("idSala"));
				distribuicaoAutomatica.getUnidadeCurricular().setIdUnidadeCurricular(rs.getInt("idUnidadeCurricular"));

				listaDistribuicaoAutomatica.add(distribuicaoAutomatica);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listaDistribuicaoAutomatica;
	}

}

