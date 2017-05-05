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
import mpsbr.model.AtributoDeProcesso;
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

            createSQL = "INSERT INTO projeto(nome, descricao, fase_desenv) VALUES (?,?,?)";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, projeto.getNome());
            prepStatement.setString(2, projeto.getDescricao());
            prepStatement.setString(3, projeto.getFaseDesenv());
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
                result.add(new Projeto(rs.getString("nome"), rs.getString("descricao"), rs.getString("fase_desenv")));
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
                result = new Projeto(rs.getString("nome"), rs.getString("descricao"), rs.getString("fase_desenv"));
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
    public List<Projeto> getAllByAtributoDeProcesso(String atributoProcessoID) {
        try 
        {
            List<Projeto> projects = new ArrayList<Projeto>();
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "SELECT DISTINCT * FROM projeto, proj_implementa_ap, ap WHERE projeto.id = proj_implementa_ap.projeto AND proj_implementa_ap.ap_id = ?";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, atributoProcessoID);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next())
                projects.add(new Projeto(rs.getString("projeto.nome"),rs.getString("projeto.descricao"),rs.getString("projeto.fase_desenv")));
            conexao.close();
            return projects;
            
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    @Override
    public List<Projeto> getAllByResultadoEsperado(String resultadoEsperadoID) {
        try 
        {
            List<Projeto> projects = new ArrayList<Projeto>();
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "SELECT DISTINCT * FROM projeto, proj_implementa_re, re WHERE projeto.id = proj_implementa_re.projeto AND proj_implementa_re.re_id = ?";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, resultadoEsperadoID);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next())
                projects.add(new Projeto(rs.getString("projeto.nome"),rs.getString("projeto.descricao"),rs.getString("projeto.fase_desenv")));
            conexao.close();
            return projects;
            
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
