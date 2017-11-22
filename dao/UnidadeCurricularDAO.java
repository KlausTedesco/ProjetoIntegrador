package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.UnidadeCurricular;
import dao.ConnectionUtil;

public class UnidadeCurricularDAO {

	private static UnidadeCurricularDAO instancia;
	public ArrayList<UnidadeCurricular> listaUnidadeCurriculares;
	private Connection con = ConnectionUtil.getConnection();

	//Singleton
	public static UnidadeCurricularDAO obterInstancia(){
		if (instancia == null){
			instancia = new UnidadeCurricularDAO();
		}
		return instancia;
	}

	public void salvar(UnidadeCurricular unidadeCurricular){
		try {
			String sql = "INSERT INTO unidadeCurricular (codigoUnidade, nomeCurso, faseCurso, nAlunos,"
					+ "equipamentos, professor, cargaHorariaMateria, dataInicio, dataFinal) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, unidadeCurricular.getCodigoUnidade());
			pstmt.setString(2, unidadeCurricular.getNomeCurso());
			pstmt.setInt(3, unidadeCurricular.getFaseCurso());
			pstmt.setInt(4, unidadeCurricular.getnAlunos());
			pstmt.setString(5, unidadeCurricular.getEquipamentos());
			pstmt.setString(6, unidadeCurricular.getProfessor().getNome());
			pstmt.setDouble(7, unidadeCurricular.getCargaHorariaMateria());
			pstmt.setDate(8, unidadeCurricular.getDataInicio());
			pstmt.setDate(9, unidadeCurricular.getDataFinal());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public List<UnidadeCurricular> listarTodos(){
		listaUnidadeCurriculares = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM unidadeCurricular";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				UnidadeCurricular unidadeCurricular = new UnidadeCurricular();
				unidadeCurricular.setIdUnidadeCurricular(rs.getInt("idUnidadeCurricular"));
				unidadeCurricular.setCodigoUnidade(rs.getString("codigoUnidade"));
				unidadeCurricular.setNomeCurso(rs.getString("nomeCurso"));
				unidadeCurricular.setFaseCurso(rs.getInt("faseCurso"));
				unidadeCurricular.setnAlunos(rs.getInt("nAlunos"));
				unidadeCurricular.setEquipamentos(rs.getString("equipamentos"));
				unidadeCurricular.getProfessor().setNome(rs.getString("professor"));
				unidadeCurricular.setCargaHorariaMateria(rs.getDouble("cargaHorariaMateria"));
				unidadeCurricular.setDataInicio(rs.getDate("dataInicio"));
				unidadeCurricular.setDataFinal(rs.getDate("dataFinal"));

				listaUnidadeCurriculares.add(unidadeCurricular);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return listaUnidadeCurriculares;
	}

	public void editar(UnidadeCurricular unidadeCurricular){
		try {
			String sql = "UPDATE unidadeCurricular SET codigoUnidade = ?, "
					+ "nomeCurso = ?, faseCurso = ?, nAlunos = ?, equipamentos = ?, idProfessor = ?, cargaHorariaMateria = ?"
					+ "dataInicio = ?, dataFinal = ? WHERE idUnidadeCurricular = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, unidadeCurricular.getCodigoUnidade());
			pstmt.setString(2, unidadeCurricular.getNomeCurso());
			pstmt.setInt(3, unidadeCurricular.getFaseCurso());
			pstmt.setInt(4, unidadeCurricular.getnAlunos());
			pstmt.setString(5, unidadeCurricular.getEquipamentos());
			pstmt.setString(6, unidadeCurricular.getProfessor().getNome());
			pstmt.setDouble(7, unidadeCurricular.getCargaHorariaMateria());
			pstmt.setDate(8, unidadeCurricular.getDataInicio());
			pstmt.setDate(9, unidadeCurricular.getDataFinal());
			pstmt.setInt(10, unidadeCurricular.getIdUnidadeCurricular());

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void excluir(int id){
		try {
			String sql = "DELETE FROM unidadeCurricular WHERE idUnidadeCurricular = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<UnidadeCurricular> pesquisarUnidadeCurricular(String codigoUnidade){
		try{
			String sql = "SELECT * FROM unidadeCurricular WHERE codigoUnidade LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + codigoUnidade + "%");
			ResultSet rs = pstmt.executeQuery();
			listaUnidadeCurriculares = new ArrayList<>();
			while(rs.next()){
				UnidadeCurricular unidadeCurricular = new UnidadeCurricular();
				unidadeCurricular.setIdUnidadeCurricular(rs.getInt("idUnidadeCurricular"));
				unidadeCurricular.setCodigoUnidade(rs.getString("codigoUnidade"));
				unidadeCurricular.setNomeCurso(rs.getString("nomeCurso"));
				unidadeCurricular.setFaseCurso(rs.getInt("faseCurso"));
				unidadeCurricular.setnAlunos(rs.getInt("nAlunos"));
				unidadeCurricular.setEquipamentos(rs.getString("equipamentos"));
				unidadeCurricular.getProfessor().setNome(rs.getString("professor"));
				unidadeCurricular.setCargaHorariaMateria(rs.getDouble("cargaHorariaMateria"));
				unidadeCurricular.setDataInicio(rs.getDate("dataInicio"));
				unidadeCurricular.setDataFinal(rs.getDate("dataFinal"));

				listaUnidadeCurriculares.add(unidadeCurricular);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaUnidadeCurriculares;
	}

}