/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mpsbr.DAO.AvaliacaoDAO;
import mpsbr.model.Avaliacao;
import mpsbr.model.ConnectionDB;

/**
 *
 * @author gabriela
 */
public class AvaliacaoDAOImpl implements AvaliacaoDAO{

    @Override
    public boolean create(Avaliacao av) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            String createSQL = "";

            createSQL = "INSERT INTO avalicao(nivel_id, data, status) VALUES ((SELECT id FROM nivel WHERE nome=?),?,?)";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, av.getNivel().getNome());
            prepStatement.setString(2, av.getDataAval());
            prepStatement.setNull(3, java.sql.Types.VARCHAR);
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Avaliacao> getAllAvaliacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
