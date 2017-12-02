package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Dia;
import model.DiaSemana;
import model.Horario;
import model.Professor;
import model.Sala;
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
	 printAll(professor);
		try {
			String sql = "insert into professor (idProfessor, nome, matricula, cargaContratada, formacao) "
					+ "values (? , ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, professor.getIdProfessor());
			pstmt.setString(2, professor.getNome());
			pstmt.setString(3, professor.getMatricula());
			pstmt.setDouble(4, professor.getCargaHorariaContratada());
			pstmt.setString(5, professor.getFormacao());

			pstmt.execute();
			
			listaProfessores = new ArrayList<>();
			Statement stmt = con.createStatement();
			String sqlpr = "select * from professor";
			ResultSet rs = stmt.executeQuery(sqlpr);
			rs.last();
			Professor prof = new Professor();
			prof.setIdProfessor(rs.getInt("idProfessor"));
			System.out.println("ID PROFESSOR" + prof.getIdProfessor());
			
			for(DiaSemana ds:professor.getListaDiaSemana()) {
				for(Horario h:ds.getHorarios()) {
					String st = "insert into horario (idProfessor, idDia, idAula) "
							+ "values(? , ? , ?)";
					PreparedStatement statement = con.prepareStatement(st);
					statement.setInt(1, prof.getIdProfessor());
					statement.setInt(2, ds.getDia().getNumero());
					statement.setInt(3, h.getNumero());
					
					statement.execute();
				}
			}
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
				professor.setCargaHorariaContratada(rs.getDouble("cargaContratada"));
				professor.setFormacao(rs.getString("formacao"));
				
				Statement statement = con.createStatement();
				String str = "select * from horario where idProfessor='"+professor.getIdProfessor()+"'";
				ResultSet result = statement.executeQuery(str);
				
				while(result.next()) {
					professor.setListaDiaSemana(new DiaSemana(
							Dia.getDia(result.getInt("idDia")).getNome(),
							Dia.getDia(result.getInt("idDia")),
							Horario.getHorario(result.getInt("idAula"))));
				}
				
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
					+ "matricula = ?, cargaContratada = ?, formacao = ?"
					+ "where idProfessor = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, professor.getNome());
			pstmt.setString(2, professor.getMatricula());
			pstmt.setDouble(3, professor.getCargaHorariaContratada());
			pstmt.setString(4, professor.getFormacao());
			pstmt.setInt(5, professor.getIdProfessor());

			pstmt.execute();
			
			String delteSql = "delete from horario where idProfessor = ? ";
			PreparedStatement dleteStat = con.prepareStatement( delteSql);
			dleteStat.setInt(1, professor.getIdProfessor());

			dleteStat.execute();
			
			for(DiaSemana ds:professor.getListaDiaSemana()) {
				for(Horario h:ds.getHorarios()) {
					String st = "insert into horario (idProfessor, idDia, idAula) "
							+ "values(? , ? , ?)";
					PreparedStatement statement = con.prepareStatement(st);
					statement.setInt(1, professor.getIdProfessor());
					statement.setInt(2, ds.getDia().getNumero());
					statement.setInt(3, h.getNumero());
					
					statement.execute();
				}
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void excluir(int id){
		try {
			String delteSql = "delete from horario where idProfessor = ? ";
			PreparedStatement dleteStat = con.prepareStatement( delteSql);
			dleteStat.setInt(1, id);
			
			dleteStat.execute();
			
			String sql = "delete from professor where idProfessor = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.execute();

		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public List<Professor> pesquisarProfessor(String codigo){
		try{
			String sql = "SELECT * FROM professor WHERE nome LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + codigo + "%");
			ResultSet rs = pstmt.executeQuery();
			listaProfessores = new ArrayList<>();
			while(rs.next()){
				Professor professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setCargaHorariaContratada(rs.getDouble("cargaContratada"));

				listaProfessores.add(professor);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaProfessores;
	}
	public void printAll(Professor professor) {
		
		System.out.println(professor.getIdProfessor());
		System.out.println(professor.getNome());
		System.out.println(professor.getMatricula());
		System.out.println("FIREDED");
		for(DiaSemana ds: professor.getListaDiaSemana()){
			for(Horario h: ds.getHorarios()){
				System.out.println("DIA: "+ ds.getNome() +", horario: "+ h.getNome());
			}
		}
	}
}