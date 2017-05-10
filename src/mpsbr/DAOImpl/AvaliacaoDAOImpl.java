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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mpsbr.DAO.AvaliacaoDAO;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Avaliacao;
import mpsbr.model.ConnectionDB;
import mpsbr.model.Implementa;
import mpsbr.model.Processo;
import mpsbr.model.Projeto;
import mpsbr.model.ResultadoEsperado;

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
            String selectSQL = "";
            createSQL = "INSERT INTO avaliacao(nivel_id, data, status) VALUES ((SELECT id FROM nivel WHERE nome=?),?,?)";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            prepStatement.setString(1, av.getNivel().getNome());
            prepStatement.setString(2, av.getDataAval());
            prepStatement.setString(3, av.getStatus());
            prepStatement.executeUpdate();
            
            selectSQL = "SELECT id FROM avaliacao ORDER BY id DESC LIMIT 1";
            prepStatement = conexao.prepareStatement(selectSQL);
            ResultSet rs = prepStatement.executeQuery();
            if(rs.next())
                av.setId(rs.getInt("id"));
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean saveResultAvaliacaoRE(Avaliacao av, Map<Processo, List<Implementa<ResultadoEsperado>>> grauImplPorProc) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            List<Implementa<ResultadoEsperado>> implementaList = new ArrayList<>();
            Map<Projeto, String> grauImplProj = new HashMap<>();
            String createSQL = "";

            createSQL = "INSERT INTO avalia(avaliacao_id, projeto_id, re_id, grau_implementacao) VALUES (?,?,?,?)";
            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            
            for (Processo processo : grauImplPorProc.keySet()) {
                implementaList = grauImplPorProc.get(processo);
                for (Implementa<ResultadoEsperado> implementa : implementaList) {
                    grauImplProj = implementa.getGrauImplPorProj();
                    for (Projeto projeto : grauImplProj.keySet()) {
                        prepStatement.setInt(1, av.getId());
                        prepStatement.setInt(2, projeto.getId());
                        prepStatement.setInt(3, implementa.getCaracteristicaAvaliada().getId());
                        prepStatement.setString(4, grauImplProj.get(projeto));
                        prepStatement.executeUpdate();
                    }
                }                    
            }
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean saveResultAvaliacaoAP(Avaliacao av, Map<Processo, List<Implementa<AtributoDeProcesso>>> grauImplPorProc) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();
            List<Implementa<AtributoDeProcesso>> implementaList = new ArrayList<>();
            Map<Projeto, String> grauImplProj = new HashMap<>();
            String createSQL = "";

            createSQL = "INSERT INTO avalia(avaliacao_id, projeto_id, proc_possui_ap_id, grau_implementacao) "
                    + "VALUES (?,?,(SELECT id FROM proc_possui_ap WHERE ap_id=? AND processo_id=?),?)";
            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);

            for (Processo processo : grauImplPorProc.keySet()) {
                implementaList = grauImplPorProc.get(processo);
                for (Implementa<AtributoDeProcesso> implementa : implementaList) {
                    grauImplProj = implementa.getGrauImplPorProj();
                    for (Projeto projeto : grauImplProj.keySet()) {
                        prepStatement.setInt(1, av.getId());
                        prepStatement.setInt(2, projeto.getId());
                        prepStatement.setInt(3, implementa.getCaracteristicaAvaliada().getId());
                        prepStatement.setInt(4, processo.getId());
                        prepStatement.setString(5, grauImplProj.get(projeto));
                        prepStatement.executeUpdate();
                    }
                }
            }
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Avaliacao av) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String updateSQL = "";

            updateSQL = "UPDATE avaliacao SET status=? WHERE id=?";
            
            PreparedStatement prepStatement = conexao.prepareStatement(updateSQL);
            prepStatement.setString(1, av.getStatus());
            prepStatement.setInt(2, av.getId());
            prepStatement.executeUpdate();

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean saveProcessoSatisfazAvaliacao(Avaliacao av, List<Processo> processos) {
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection conexao = conn.getConnection();

            String createSQL = "";

            createSQL = "INSERT INTO proc_satisfaz_avaliacao(avaliacao_id, processo_id, status) VALUES (?,?,?)";

            PreparedStatement prepStatement = conexao.prepareStatement(createSQL);
            for (Processo processo : processos) {
                prepStatement.setInt(1, av.getId());
                prepStatement.setInt(2, processo.getId());
                prepStatement.setString(3, processo.getStatus());
                prepStatement.executeUpdate();
            }

            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NivelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
