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
import mpsbr.DAO.AtributoDeProcessoDAO;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Nivel;

/**
 *
 * @author gabriela
 */
public class AtributoDeProcessoDAOImpl implements AtributoDeProcessoDAO{

    @Override
    public boolean create(AtributoDeProcesso ap) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO ap(nome, descricao, nivel_id) VALUES (?,?,(SELECT id FROM nivel WHERE nome=?))";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, ap.getNome());
            prepStatement.setString(2, ap.getDescricao());
            prepStatement.setString(3, ap.getNomeNivel());
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<AtributoDeProcesso> getAllAtributoDeProcesso() {
        ArrayList<AtributoDeProcesso> result = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT ap.nome, ap.descricao, n.nome FROM ap JOIN nivel n ON ap.nivel_id=n.id";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next())
                result.add(new AtributoDeProcesso(Integer.parseInt(rs.getString("ap.id")),rs.getString("ap.nome"), rs.getString("ap.descricao"), rs.getString("n.nome")));
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<AtributoDeProcesso> getAllAtributoDeProcessoPorNivel(Nivel nivel) {
        ArrayList<AtributoDeProcesso> result = new ArrayList<>();
        Nivel currNivel = nivel;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String selectSQL = "SELECT ap.nome, ap.descricao, n.nome FROM ap JOIN nivel n ON ap.nivel_id=n.id where n.nome=?";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            while (null != currNivel){
                prepStatement.setString(1, currNivel.getNome());
                ResultSet rs = prepStatement.executeQuery();
                
                while (rs.next())
                    result.add(new AtributoDeProcesso(Integer.parseInt(rs.getString("ap.id")),rs.getString("ap.nome"), rs.getString("ap.descricao"), rs.getString("n.nome")));
                currNivel = currNivel.getNivelAnteriorId();
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public AtributoDeProcesso findByNome(String nome) {
        AtributoDeProcesso result = null;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT ap.nome, ap.descricao, n.nome FROM ap JOIN nivel n ON ap.nivel_id=n.id WHERE ap.nome=?";

            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            prepStatement.setString(1, nome);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next())
                result = new AtributoDeProcesso(Integer.parseInt(rs.getString("p.id")),rs.getString("p.nome"), rs.getString("p.descricao"), rs.getString("n.nome"));
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
