/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import mpsbr.model.Nivel;
import mpsbr.model.Processo;

/**
 *
 * @author gabriela
 */
public interface ProcessoDAO {
    public boolean create(Processo processo);
    public ArrayList<Processo> getAllProcesso();
    public ArrayList<Processo> getAllProcessoPorNivel(Nivel nivel);
    public Processo findByCodigo(String codigo);
    public boolean update(String nome);    
}
