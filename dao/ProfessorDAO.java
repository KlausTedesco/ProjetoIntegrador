package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Professor;
import dao.ConnectionUtil;

public class ProfessorDAO {

	private static ProfessorDAO instancia;
	public ArrayList<Professor> listaProfessores;
	private Connection con = ConnectionUtil.getConnection();

	//Singleton
	public static ProfessorDAO obterInstancia(){
		if (instancia == null){
			instancia = new ProfessorDAO();
		}
		return instancia;
	}

	public void salvar(Professor professor){
		try {
			String sql = "insert into professor (idProfessor, nome, matricula, cargaHorariaContratada) "
					+ "values (? , ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, professor.getIdProfessor());
			pstmt.setString(2, professor.getNome());
			pstmt.setString(3, professor.getMatricula());
			pstmt.setDouble(4, professor.getCargaHorariaContratada());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public List<Professor> listarTodos(){
		listaProfessores = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from professor";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				Professor professor = new Professor();
				professor.setIdProfessor(rs.getInt("idProfessor"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setCargaHorariaContratada(rs.getDouble("cargaHorariaContratada"));

				listaProfessores.add(professor);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return listaProfessores;
	}

	public void editar(Professor professor){
		try {
			String sql = "update professor set nome = ?, "
					+ "matricula = ?, cargaHorariaContratada = ?"
					+ "where idProfessor = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, professor.getIdProfessor());
			pstmt.setString(2, professor.getNome());
			pstmt.setString(3, professor.getMatricula());
			pstmt.setDouble(4, professor.getCargaHorariaContratada());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void excluir(int id){
		try {
			String sql = "delete from professor where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}