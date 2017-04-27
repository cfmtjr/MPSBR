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
import java.util.logging.Level;
import java.util.logging.Logger;
import mpsbr.DAO.ProcessoDAO;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Nivel;
import mpsbr.model.Processo;

/**
 *
 * @author gabriela
 */
public class ProcessoDAOImpl implements ProcessoDAO{

    @Override
    public boolean create(Processo processo) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO processo(nome, descricao, nivel_id) VALUES (?,?,(SELECT id FROM nivel WHERE nome=?))";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, processo.getNome());
            prepStatement.setString(2, processo.getDescricao());
            prepStatement.setString(3, processo.getNomeNivel());
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Processo> getAllProcesso() {
        ArrayList<Processo> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT p.nome, p.descricao, n.nome FROM processo AS p JOIN nivel n ON p.nivel_id=n.id";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                result.add(new Processo(rs.getString("p.nome"), rs.getString("p.descricao"), rs.getString("n.nome")));
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Processo> getAllProcessoPorNivel(Nivel nivel) {
        ArrayList<Processo> result = new ArrayList<>();
        Nivel currNivel = nivel;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String selectSQL = "SELECT p.nome, p.descricao, n.nome FROM processo AS p JOIN nivel n ON p.nivel_id=n.id where n.nome=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            while (null != currNivel) {
                prepStatement.setString(1, currNivel.getNome());
                ResultSet rs = prepStatement.executeQuery();
                while (rs.next())
                    result.add(new Processo(rs.getString("p.nome"), rs.getString("p.descricao"), rs.getString("n.nome")));
                currNivel = currNivel.getNivelAnterior();
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Processo findByNome(String nome) {
        Processo result = null;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT p.nome, p.descricao, n.nome FROM processo AS p JOIN nivel n ON p.nivel_id=n.id WHERE p.nome=?";

            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, nome);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next())
                result = new Processo(rs.getString("p.nome"), rs.getString("p.descricao"), rs.getString("n.nome"));
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

    
}
