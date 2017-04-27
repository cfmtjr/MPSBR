/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.facade;

import java.util.ArrayList;
import java.util.List;
import mpsbr.DAO.AtributoDeProcessoDAO;
import mpsbr.DAO.ProjetoDAO;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.DAOImpl.AtributoDeProcessoDAOImpl;
import mpsbr.DAOImpl.ProjetoDAOImpl;
import mpsbr.DAOImpl.ResultadoEsperadoDAOImpl;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Nivel;
import mpsbr.model.Projeto;
import mpsbr.model.ResultadoEsperado;

/**
 *
 * @author gabriela
 */
public class MPSBRFacade {

    public static final AtributoDeProcessoDAO apd = new AtributoDeProcessoDAOImpl();
    public static final ProjetoDAO pd = new ProjetoDAOImpl();
    public static final ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();
    
    /**
     * Retorna todos os projetos em  um determinado nivel
     * @param nivel
     * @return
     */
    public static List<Projeto> getProjectsByNivel(Nivel nivel)
    {
        List<AtributoDeProcesso> adpList = MPSBRFacade.apd.getAllAtributoDeProcessoPorNivel(nivel);
        List<ResultadoEsperado> reList = MPSBRFacade.red.getAllResultadoEsperadoPorNivel(nivel);
        
        List<Projeto> projetos = new ArrayList<Projeto>();
        for(AtributoDeProcesso adp : adpList)
            projetos.addAll(MPSBRFacade.pd.getAllByAtributoDeProcesso(Integer.toString(adp.getId())));
        
        for(ResultadoEsperado re : reList)
            projetos.addAll(MPSBRFacade.pd.getAllByAtributoDeProcesso(Integer.toString(re.getId())));
        
        return MPSBRFacade.removeDuplicate(projetos);
    }
    
    public static List<Projeto> removeDuplicate(List<Projeto> lst){
        List<Projeto> lstNoCopy = new ArrayList<Projeto>();
        for(Projeto p : lst){
            boolean isCopia = false;
            for(Projeto p2 : lstNoCopy){
                if(p.getId()==p2.getId())
                {
                   isCopia=true;
                    break;
                }
            }
            if(!isCopia)
            {
                lstNoCopy.add(p);
            }
        }
        return lstNoCopy;
    }
}
