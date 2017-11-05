package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import model.Professor;
import util.ConnectionUtil;

public class ProfessorDAO {

    private static ProfessorDAO instancia;
    public List<Professor> listaProfessores = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();

    public static ProfessorDAO obterInstancia(){
        if (instancia == null){
            instancia = new ProfessorDAO();
        }
        return instancia;
    }

    public void salvar(Professor professor){
        try {
            String sql = "insert into professor (nome, cpf, endereco, telefone) "
                    + "values (? , ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getCpf());
            pstmt.setString(3, professor.getEndereco());
            pstmt.setString(4, professor.getTelefone());

            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Professor> listarTodos(){
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from professor";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setTelefone(rs.getString("telefone"));

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
                    + "cpf = ?, endereco = ?, telefone = ? "
                    + "where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getCpf());
            pstmt.setString(3, professor.getEndereco());
            pstmt.setString(4, professor.getTelefone());
            pstmt.setInt(5, professor.getId());

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