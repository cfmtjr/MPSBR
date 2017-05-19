/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.List;
import mpsbr.model.Projeto;

/**
 *
 * @author gabriela
 */
public interface ProjetoDAO {
    public boolean create(Projeto projeto);
    public List<Projeto> getAllProjeto();
    public Projeto findByNome(String nome);
    public boolean update(String nome);        
}
