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
import javax.swing.JOptionPane;
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
    public boolean create(ResultadoEsperado re, List<String> validoPara) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO re(codigo, nome, descricao, processo_id) VALUES (?,?,?,(SELECT id FROM processo WHERE codigo=?))";
            
            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, re.getCodigo());
            prepStatement.setString(2, re.getNome());
            prepStatement.setString(3, re.getDescricao());
            prepStatement.setString(4, re.getProcessoCodigo());
            prepStatement.executeUpdate();
            
            for (String nomeNivel : validoPara) {
                createSQL = "INSERT INTO re_valido_para(re_id, nivel_id) VALUES ((SELECT id FROM re WHERE codigo=? ORDER BY id DESC LIMIT 1),(SELECT id FROM nivel WHERE nome=?))";
                prepStatement = conexao.prepareStatement(createSQL);
                prepStatement.setString(1, re.getCodigo());
                prepStatement.setString(2, nomeNivel);
                prepStatement.executeUpdate();
            }
            
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

            String selectSQL = "SELECT re.id, rs.codigo, re.nome, re.descricao, p.nome FROM re JOIN processo p ON re.processo_id=p.id";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new ResultadoEsperado(rs.getInt("re.id"), rs.getString("re.codigo"), rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
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

            String selectSQL = "SELECT re.id, re.codigo, re.nome, re.descricao, p.nome "
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
                result.add(new ResultadoEsperado(rs.getInt("re.id"), rs.getString("re.codigo"), rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ResultadoEsperado findByCodigo(String codigo) {
        ResultadoEsperado result = null;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.id, re.codigo, re.nome, re.descricao, p.nome FROM re JOIN processo p ON re.processo_id=p.id WHERE codigo=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, codigo);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next())
                result = new ResultadoEsperado(rs.getInt("re.id"), rs.getString("re.codigo"), rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome"));
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
    public ArrayList<ResultadoEsperado> getAllResultadoEsperadoPorNivelEProcesso(Nivel nivel, Processo processo) {
        ArrayList<ResultadoEsperado> result = new ArrayList<>();

        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.id, re.codigo, re.nome, re.descricao, p.nome "
                    + "FROM re JOIN processo p ON re.processo_id=p.id "
                    + "WHERE re.id IN "
                    + "(SELECT re.id "
                    + "FROM re JOIN re_valido_para val ON re.id=val.re_id "
                    + "JOIN nivel n ON val.nivel_id=n.id "
                    + "WHERE n.nome=?) "
                    + "AND p.codigo=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, nivel.getNome());
            prepStatement.setString(2, processo.getCodigo());
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                result.add(new ResultadoEsperado(rs.getInt("re.id"), rs.getString("re.codigo"), rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<ResultadoEsperado> getAllResultadoEsperadoPorProcesso(Processo processo) {
        ArrayList<ResultadoEsperado> result = new ArrayList<>();

        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT re.id, re.codigo, re.nome, re.descricao, p.nome FROM re JOIN processo p ON re.processo_id=p.id WHERE p.codigo=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, processo.getCodigo());
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                result.add(new ResultadoEsperado(rs.getInt("re.id"), rs.getString("re.codigo"), rs.getString("re.nome"), rs.getString("re.descricao"), rs.getString("p.nome")));
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public ArrayList<String> getAllNivelValidoParaRE(ResultadoEsperado re) {
        ArrayList<String> result = new ArrayList<>();

        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT n.nome FROM nivel n JOIN re_valido_para val ON n.id=val.nivel_id WHERE re_id in (SELECT id FROM re WHERE codigo=?)";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, re.getCodigo());
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                result.add(rs.getString("n.nome"));
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public ArrayList<String> queryAllNivelValidoParaRE(ResultadoEsperado re, String nomeNivel) {
        int reID = 0;
        ArrayList<String> result = new ArrayList<>();

        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            
            String selectSQL = "SELECT re.id FROM re JOIN re_valido_para val ON re.id=val.re_id JOIN nivel n ON n.id=val.nivel_id WHERE re.codigo=? AND n.nome=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, re.getCodigo());
            prepStatement.setString(2, nomeNivel);
            ResultSet rs = prepStatement.executeQuery();
            
            if(rs.next())
                reID = rs.getInt("re.id");
            
            if(reID != 0)
            {
                selectSQL = "SELECT n.nome FROM nivel n JOIN re_valido_para val ON n.id=val.nivel_id WHERE re_id=?";
                prepStatement = conexao.prepareStatement(selectSQL);
                prepStatement.setInt(1, reID);
                rs = prepStatement.executeQuery();

                while (rs.next()) {
                    result.add(rs.getString("n.nome"));
                }
                conexao.close();
                return result;
            }
            else
            {
                conexao.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
