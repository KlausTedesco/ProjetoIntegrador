package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Sala;
import dao.ConnectionUtil;

public class SalaDAO {

	private static SalaDAO instancia;
	public ArrayList<Sala> listaSalas;
	private Connection con = ConnectionUtil.getConnection();

	//Singleton
	public static SalaDAO obterInstancia(){
		if (instancia == null){
			instancia = new SalaDAO();
		}
		return instancia;
	}

	public void salvar(Sala sala){
		try {
			String sql = "INSERT INTO sala (idSala, codigo, capacidade, equipamentos) "
					+ "VALUES (? , ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sala.getIdSala());
			pstmt.setString(2, sala.getCodigo());
			pstmt.setInt(3, sala.getnMaximoAlunos());
			pstmt.setString(4, sala.getEquipamentos());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public List<Sala> listarTodos(){
		listaSalas = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM sala";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				Sala sala = new Sala();
				sala.setIdSala(rs.getInt("idSala"));
				sala.setCodigo(rs.getString("codigo"));
				sala.setnMaximoAlunos(rs.getInt("capacidade"));
				sala.setEquipamentos(rs.getString("equipamentos"));

				listaSalas.add(sala);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return listaSalas;
	}

	public void editar(Sala sala){
		try {
			String sql = "UPDATE sala SET codigo = ?, "
					+ "capacidade = ?, equipamentos = ? "
					+ "WHERE idSala = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sala.getCodigo());
			pstmt.setInt(2, sala.getnMaximoAlunos());
			pstmt.setString(3, sala.getEquipamentos());
			pstmt.setInt(4, sala.getIdSala());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void excluir(int id){
		try {
			String sql = "DELETE FROM sala WHERE idSala = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public List<Sala> pesquisarSala(String codigo){
		try{
			String sql = "SELECT * FROM sala WHERE codigo LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + codigo + "%");
			ResultSet rs = pstmt.executeQuery();
			listaSalas = new ArrayList<>();
			while(rs.next()){
				Sala sala = new Sala();
				sala.setIdSala(rs.getInt("idSala"));
				sala.setCodigo(rs.getString("codigo"));
				sala.setnMaximoAlunos(rs.getInt("capacidade"));
				sala.setEquipamentos(rs.getString("equipamentos"));

				listaSalas.add(sala);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaSalas;
	}

}
