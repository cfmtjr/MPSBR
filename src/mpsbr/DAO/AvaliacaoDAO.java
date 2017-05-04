/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Avaliacao;
import mpsbr.model.Implementa;
import mpsbr.model.Processo;
import mpsbr.model.ResultadoEsperado;

/**
 *
 * @author gabriela
 */
public interface AvaliacaoDAO {
    public boolean create(Avaliacao av);
    public boolean saveResultAvaliacaoRE(Avaliacao av, Map<Processo, List<Implementa<ResultadoEsperado>>> grauImplPorProc);
    public boolean saveResultAvaliacaoAP(Avaliacao av, Map<Processo, List<Implementa<AtributoDeProcesso>>> grauImplPorProc);
    public boolean saveProcessoSatisfazAvaliacao(Avaliacao av, List<Processo> processos);    
    public boolean update(Avaliacao av);    
}
