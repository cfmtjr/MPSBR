/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import mpsbr.model.Avaliacao;

/**
 *
 * @author gabriela
 */
public interface AvaliacaoDAO {
    public boolean create(Avaliacao av);
    public ArrayList<Avaliacao> getAllAvaliacao();
    public boolean update(String nome);    
}
