package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import model.Sala;
import util.ConnectionUtil;

public class SalaDAO {

    private static SalaDAO instancia;
    public List<Sala> listaSalas = new ArrayList<>();
    private Connection con = ConnectionUtil.getConnection();

    public static SalaDAO obterInstancia(){
        if (instancia == null){
            instancia = new SalaDAO();
        }
        return instancia;
    }

    public void salvar(Sala sala){
        try {
            String sql = "insert into sala (nome, cpf, endereco, telefone) "
                    + "values (? , ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sala.getNome());
            pstmt.setString(2, sala.getCpf());
            pstmt.setString(3, sala.getEndereco());
            pstmt.setString(4, sala.getTelefone());

            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Sala> listarTodos(){
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from Sala";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Sala sala = new Sala();
                sala.setId(rs.getInt("id"));
                sala.setNome(rs.getString("nome"));
                sala.setCpf(rs.getString("cpf"));
                sala.setEndereco(rs.getString("endereco"));
                sala.setTelefone(rs.getString("telefone"));

                listaSalas.add(sala);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return listaSalas;
    }

    public void editar(Sala sala){
        try {
            String sql = "update sala set nome = ?, "
                    + "cpf = ?, endereco = ?, telefone = ? "
                    + "where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sala.getNome());
            pstmt.setString(2, sala.getCpf());
            pstmt.setString(3, sala.getEndereco());
            pstmt.setString(4, sala.getTelefone());
            pstmt.setInt(5, sala.getId());

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