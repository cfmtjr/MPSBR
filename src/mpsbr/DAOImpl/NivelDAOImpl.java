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
import mpsbr.DAO.NivelDAO;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Nivel;

/**
 *
 * @author gabriela
 */
public class NivelDAOImpl implements NivelDAO{

    @Override
    public boolean create(Nivel nivel) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";
                    
            if (nivel.getNivelAnterior() != null)
                createSQL = "INSERT INTO nivel(nome, status, nivel_anterior) VALUES (?, ?,(SELECT id FROM nivel as t WHERE t.nome=?))";
            else
                createSQL = "INSERT INTO nivel(nome, status, nivel_anterior) VALUES (?,?,?)";
            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, nivel.getNome());
            prepStatement.setString(2, nivel.getStatus());
            if(nivel.getNivelAnterior() != null)
                prepStatement.setString(3, nivel.getNivelAnterior().getNome());
            else
                prepStatement.setNull(3, java.sql.Types.INTEGER);
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean createAllNivel(){
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";
            String[] niveis = new String[] {"G","F","E","D","C","B","A"};
            PreparedStatement prepStatement = null;
            for(int i = 0; i < niveis.length; i++){
                if(i == 0){
                    createSQL = "insert into nivel(nome, status, nivel_anterior) values (?, ?, ?)";
                    prepStatement = conexao.prepareStatement(createSQL);
                    prepStatement.setString(1, niveis[i]);
                    prepStatement.setString(2, "NÃO HABILITADO");
                    prepStatement.setNull(3, java.sql.Types.VARCHAR);
                } else {
                    createSQL = "insert into nivel(nome, status, nivel_anterior) values (?, ?, (SELECT id FROM nivel as n WHERE n.nome= ?))";
                    prepStatement = conexao.prepareStatement(createSQL);
                    prepStatement.setString(1, niveis[i]);
                    prepStatement.setString(2, "NÃO HABILITADO");
                    prepStatement.setString(3, niveis[i-1]);
                }
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
    public ArrayList<Nivel> getAllNivel() {
        ArrayList<Nivel> result = new ArrayList<>();
        Nivel nivelAnterior = null;
        int idNivelAnterior = 0;
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String selectSQL = "SELECT * FROM nivel ORDER BY nome DESC";
            PreparedStatement prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                idNivelAnterior = rs.getInt("nivel_anterior");
                if(rs.wasNull())
                    result.add(0, new Nivel(rs.getString("nome"), rs.getString("status"), null));
                else
                    result.add(0, new Nivel(rs.getString("nome"), rs.getString("status"), nivelAnterior));
                nivelAnterior = result.get(0);
            }
            conexao.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Nivel findByName(String name) {
        ArrayList<Nivel> allNivel = getAllNivel();
        
        for (Nivel nivel : allNivel) {
            if(nivel.getNome().equals(name)){
                return nivel;
            }
        }
        return null;
    }

    @Override
    public boolean habilitaNivel(String name) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String updateSQL = "";
            PreparedStatement prepStatement = null;
            updateSQL = "UPDATE nivel SET status='HABILITADO' WHERE nome=?";
            prepStatement = conexao.prepareStatement(updateSQL);
            prepStatement.setString(1, name);
            prepStatement.executeUpdate();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Nivel nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
