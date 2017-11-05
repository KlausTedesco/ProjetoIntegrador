package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import model.UnidadeCurricular;
import util.ConnectionUtil;

public class UnidadeCurricularDAO {

    private static UnidadeCurricularDAO instancia;
    public List<UnidadeCurricular> listaUnidadeCurriculares = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();

    public static UnidadeCurricularDAO obterInstancia(){
        if (instancia == null){
            instancia = new UnidadeCurricularDAO();
        }
        return instancia;
    }

    public void salvar(UnidadeCurricular unidadeCurricular){
        try {
            String sql = "insert into unidadeCurricular (nome, cpf, endereco, telefone) "
                    + "values (? , ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, unidadeCurricular.getNome());
            pstmt.setString(2, unidadeCurricular.getCpf());
            pstmt.setString(3, unidadeCurricular.getEndereco());
            pstmt.setString(4, unidadeCurricular.getTelefone());

            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<UnidadeCurricular> listarTodos(){
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from UnidadeCurricular";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                UnidadeCurricular UnidadeCurricular = new UnidadeCurricular();
                UnidadeCurricular.setId(rs.getInt("id"));
                UnidadeCurricular.setNome(rs.getString("nome"));
                UnidadeCurricular.setCpf(rs.getString("cpf"));
                UnidadeCurricular.setEndereco(rs.getString("endereco"));
                UnidadeCurricular.setTelefone(rs.getString("telefone"));

                listaUnidadeCurriculares.add(UnidadeCurricular);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return listaUnidadeCurriculares;
    }

    public void editar(UnidadeCurricular unidadeCurricular){
        try {
            String sql = "update unidadeCurricular set nome = ?, "
                    + "cpf = ?, endereco = ?, telefone = ? "
                    + "where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, unidadeCurricular.getNome());
            pstmt.setString(2, unidadeCurricular.getCpf());
            pstmt.setString(3, unidadeCurricular.getEndereco());
            pstmt.setString(4, unidadeCurricular.getTelefone());
            pstmt.setInt(5, unidadeCurricular.getId());

            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir(int id){
        try {
            String sql = "delete from unidadeCurricular where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}