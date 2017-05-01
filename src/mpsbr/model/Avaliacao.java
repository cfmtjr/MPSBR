/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.DAOImpl.ResultadoEsperadoDAOImpl;
import mpsbr.facade.MPSBRFacade;

/**
 *
 * @author gabriela
 */
public class Avaliacao {
    private String dataAval;
    private Boolean status;
    private Nivel nivel;
    
    private List<Projeto> projAvaliados;  
    
    public String getDataAval() {
        return dataAval;
    }

    public void setDataAval(String dataAval) {
        this.dataAval = dataAval;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = MPSBRFacade.nd.findByName(nivel);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Projeto> getProjAvaliados() {
        return projAvaliados;
    }

    public void setProjAvaliados(List<Projeto> projAvaliados) {
        this.projAvaliados = projAvaliados;
    }
    
    public void addProjAvaliados(Projeto proj){
        this.projAvaliados.add(proj);
    }
    
    public Projeto getProjeto(int index){
        if(index<0){
            return null;
        }
        if(index+1>this.projAvaliados.size()){
            return null;
        }
        return this.projAvaliados.get(index);
    }
    
    public Avaliacao(String nivel, boolean isNew){
        if(isNew)
        {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Calendar c = Calendar.getInstance();
            this.setDataAval(df.format(c.getTime()));
            this.setStatus(false);
        }
        this.setNivel(nivel);
    }

    /**
     * Retorna uma lista com os nomes dos projetos utilizados
     * @return 
     */
    public List<String> getProjectNames() 
    {
        List<Projeto> prjAval = this.getProjAvaliados(); 
        if(prjAval==null)
            prjAval = MPSBRFacade.getProjectsByNivel(this.getNivel());
        
        List<String> lst = new ArrayList<String>();
        for(Projeto p : prjAval)
            lst.add(p.getNome());
        return lst;
    }

    public void updateProjAvaliados(List<String> projetos) 
    {    
        List<Projeto> evalProjects = new ArrayList<Projeto>();
        for(Projeto p : this.getProjAvaliados())
        {
            if(projetos.contains(p.getNome()))
            {
                evalProjects.add(p);
            }
        }
        this.setProjAvaliados(evalProjects);
    }

    public List<Processo> listProcessos() {
        
        List<Processo> processos = new ArrayList<Processo>();    
        Nivel n = this.getNivel();
        while(n.getNivelAnterior()!=null)
        {
            List<Processo> procsNivel = Processo.getProcessosPorNivel(n);
            for(Processo p : procsNivel )
                processos.add(p);
            n = n.getNivelAnterior();
        }
        return processos;
    }

    public List<AtributoDeProcesso> listAtributosDeProcesso() {
        List<AtributoDeProcesso> aps = AtributoDeProcesso.getAtributoDeProcessoPorNivel(this.getNivel());
        return aps;
    }
    
    public Map<Processo, List<ResultadoEsperado>> mapResultadoEsperado(List<Processo> processos)
    {
        ResultadoEsperadoDAO red  = new ResultadoEsperadoDAOImpl();
        Map<Processo, List<ResultadoEsperado>> result = new HashMap<Processo, List<ResultadoEsperado>>();
        for(Processo p : processos)
            result.put(p, red.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p));
        return result;
    }
    
    public void avalia(){
        ArrayList<Processo> processos = MPSBRFacade.pd.getAllProcessoPorNivel(this.getNivel());
        ArrayList<ResultadoEsperado> REsPorNivel = MPSBRFacade.red.getAllResultadoEsperadoPorNivel(this.getNivel());
        
        for(int i = 0; i < processos.size(); i++){
            
        }
    }
    
    private ArrayList<ResultadoEsperado> 
}
