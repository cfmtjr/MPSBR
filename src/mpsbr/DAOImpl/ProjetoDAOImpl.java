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
import mpsbr.DAO.ProjetoDAO;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Projeto;

/**
 *
 * @author gabriela
 */
public class ProjetoDAOImpl implements ProjetoDAO {
    
    @Override
    public boolean create(Projeto projeto) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO projeto(nome, descricao, fase_desenv, cliente, gerente) VALUES (?,?,?,?,?)";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, projeto.getNome());
            prepStatement.setString(2, projeto.getDescricao());
            prepStatement.setString(3, projeto.getFaseDesenv());
            prepStatement.setString(4, projeto.getCliente());
            prepStatement.setString(5, projeto.getGerente());
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Projeto> getAllProjeto() {
        ArrayList<Projeto> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT * FROM projeto";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new Projeto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("fase_desenv"), rs.getString("cliente"), rs.getString("gerente")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public Projeto findByNome(String nome) {
        Projeto result = null;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT * FROM projeto WHERE nome=?";

            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, nome);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next())
                result = new Projeto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("fase_desenv"), rs.getString("cliente"), rs.getString("gerente"));
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
