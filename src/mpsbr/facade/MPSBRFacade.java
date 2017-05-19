/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.facade;

import mpsbr.DAO.AtributoDeProcessoDAO;
import mpsbr.DAO.NivelDAO;
import mpsbr.DAO.ProcessoDAO;
import mpsbr.DAO.ProjetoDAO;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.DAOImpl.AtributoDeProcessoDAOImpl;
import mpsbr.DAOImpl.NivelDAOImpl;
import mpsbr.DAOImpl.ProcessoDAOImpl;
import mpsbr.DAOImpl.ProjetoDAOImpl;
import mpsbr.DAOImpl.ResultadoEsperadoDAOImpl;

/**
 *
 * @author gabriela
 */
public class MPSBRFacade {

    public static final AtributoDeProcessoDAO apd = new AtributoDeProcessoDAOImpl();
    public static final ProjetoDAO pjd = new ProjetoDAOImpl();
    public static final ProcessoDAO pd = new ProcessoDAOImpl();
    public static final ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();
    public static final NivelDAO nd = new NivelDAOImpl();
    
}
