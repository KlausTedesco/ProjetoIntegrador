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
			String sql = "insert into sala (idSala, codigo, nMaximoAlunos, equipamentos) "
					+ "values (? , ?, ?, ?)";
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
			String sql = "select * from sala";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				Sala sala = new Sala();
				sala.setIdSala(rs.getInt("idSala"));
				sala.setCodigo(rs.getString("codigo"));
				sala.setnMaximoAlunos(rs.getInt("nMaximoAlunos"));
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
			String sql = "update sala set codigo = ?, "
					+ "nMaximoAlunos = ?, equipamentos = ? "
					+ "where idSala = ?";
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

	public void excluir(int id){
		try {
			String sql = "delete from sala where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}




}
