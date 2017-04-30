/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Nivel;
import mpsbr.model.Processo;
import mpsbr.model.ResultadoEsperado;

/**
 *
 * @author gabriela
 */
public class ResultadoEsperadoDAOImpl implements ResultadoEsperadoDAO{

    @Override
    public boolean create(ResultadoEsperado re) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO re(nome, descricao, processo_id) VALUES (?,?,(SELECT id FROM processo WHERE nome=?))";
            
            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, re.getNome());
            prepStatement.setString(2, re.getDescricao());
            prepStatement.setString(3, re.getProcessoNome());
            prepStatement.executeUpdate();

            createSQL = "INSERT INTO re_valido_para(re_id, nivel_id) VALUES ((SELECT id FROM re WHERE nome=?),(SELECT nivel_id FROM processo WHERE nome=?))";
            
            prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, re.getNome());
            prepStatement.setString(2, re.getProcessoNome());
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<ResultadoEsperado> getAllResultadoEsperado() {
        ArrayList<ResultadoEsperado> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.nome, re.descricao, p.nome FROM re JOIN processo p ON re.processo_id=p.id";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new ResultadoEsperado(Integer.parseInt(rs.getString("re.id")),rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<ResultadoEsperado> getAllResultadoEsperadoPorNivel(Nivel nivel) {
        ArrayList<ResultadoEsperado> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.nome, re.descricao, p.nome "
                             + "FROM re JOIN processo p ON re.processo_id=p.id "
                             + " WHERE re.id IN "
                                + "(SELECT re.id "
                                + "FROM re JOIN re_valido_para val ON re.id=val.re_id "
                                + "JOIN nivel n ON val.nivel_id=n.id "
                                + "WHERE n.nome=?)";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, nivel.getNome());
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new ResultadoEsperado(Integer.parseInt(rs.getString("re.id")),rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ResultadoEsperado findByNome(String nome) {
        ResultadoEsperado result = null;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.nome, re.descricao, p.nome FROM re JOIN processo p ON re.processo_id=p.id WHERE nome=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next())
                result = new ResultadoEsperado(Integer.parseInt(rs.getString("re.id")),rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome"));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    @Override
    public boolean update(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ResultadoEsperado> getAllResultadoEsperado(Nivel nivel, Processo p) {
        ArrayList<ResultadoEsperado> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.id, re.nome, re.descricao, p.nome "
                             + "FROM re,processo"
                             + " WHERE re.processo_id=?"
                                + "AND re_valido_para.re_id = re.id"
                                + "AND re_valido_para.nivel_id = ?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, Integer.toString(p.getId()));
            prepStatement.setString(2, Integer.toString(nivel.getId()));
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new ResultadoEsperado(Integer.parseInt(rs.getString("re.id")),rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
}
