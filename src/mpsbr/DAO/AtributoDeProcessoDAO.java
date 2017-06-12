/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Nivel;

/**
 *
 * @author gabriela
 */
public interface AtributoDeProcessoDAO {
    public boolean create(AtributoDeProcesso ap);
    public ArrayList<AtributoDeProcesso> getAllAtributoDeProcesso();
    public List<AtributoDeProcesso> getAllAtributoDeProcessoPorNivel(Nivel nivel);
    public AtributoDeProcesso findByCodigo(String codigo);
    public Map<String, List<String>> getAllNotasPorNivelEAP(String nomeNivel);
    public boolean update(String nome);    
}
