/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.DAOImpl.ResultadoEsperadoDAOImpl;
import mpsbr.control.AvaliacaoControl;
import mpsbr.facade.MPSBRFacade;

/**
 *
 * @author gabriela
 */
public class Avaliacao {
    private int id;
    private String dataAval;
    private String status;
    private Nivel nivel;
    
    private List<Projeto> projAvaliados;  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
            this.dataAval = df.format(c.getTime());
            this.status = "";
        }
        this.setNivel(nivel);
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
        
        List<Processo> processos = Processo.getProcessosPorNivel(this.getNivel());    
        return processos;
    }

    public List<AtributoDeProcesso> listAtributosDeProcesso() {
        List<AtributoDeProcesso> aps = AtributoDeProcesso.getAtributoDeProcessoPorNivel(this.getNivel());
        return aps;
    }
    
    public Map<Processo, List<ResultadoEsperado>> mapResultadoEsperado(List<Processo> processos)
    {
        ResultadoEsperadoDAO red  = new ResultadoEsperadoDAOImpl();
        Map<Processo, List<ResultadoEsperado>> result = new HashMap<>();
        for(Processo p : processos)
            result.put(p, red.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p));
        return result;
    }
    
    public void avalia(){
        AvaliacaoControl control = AvaliacaoControl.getInstance();
        HashMap<Processo, List<Implementa<ResultadoEsperado>>> grausImplREProcI = (HashMap<Processo, List<Implementa<ResultadoEsperado>>>) control.getMapImplProjRE();
        HashMap<Processo, List<Implementa<AtributoDeProcesso>>> grausImplAPProcI = (HashMap<Processo, List<Implementa<AtributoDeProcesso>>>) control.getMapImplProjAP();
        Map<String, String> grausImplREUOProcI = new HashMap<>();
        Map<String, String> grausImplAPUOProcI = new HashMap<>();
        for (Processo p : grausImplREProcI.keySet()) {
            ArrayList<Implementa<ResultadoEsperado>> implRE = (ArrayList<Implementa<ResultadoEsperado>>) grausImplREProcI.get(p);
            for (Implementa<ResultadoEsperado> implementa : implRE) {
                grausImplREUOProcI.put(implementa.getCaracteristicaAvaliada().getCodigo(), identificaGrauImpProcUO(implementa.getGrauImplPorProj()));
            }
            ArrayList<Implementa<AtributoDeProcesso>> implAP = (ArrayList<Implementa<AtributoDeProcesso>>) grausImplAPProcI.get(p);
            for (Implementa<AtributoDeProcesso> implementa : implAP) {
                grausImplAPUOProcI.put(implementa.getCaracteristicaAvaliada().getCodigo(), identificaGrauImpProcUO(implementa.getGrauImplPorProj()));
            }
            if(validaApProc(grausImplAPUOProcI)){
                if(validaReProc(grausImplREUOProcI)){
                    p.setStatus("SATISFEITO");
                } else {
                    p.setStatus("NAO SATISFEITO");
                }
            } else {
                p.setStatus("NAO SATISFEITO");
                this.setStatus("NAO PASSOU");
            }
        } if(!this.getStatus().equals("NAO PASSOU")){ //!= n passou
            this.setStatus("PASSOU");
        }            
    }
    
    private String identificaGrauImpProcUO(Map<Projeto, String> implPorProj){
        String result = "";
        boolean different = false;
        boolean isAnyF = false;
        boolean isAnyT = false;
        boolean isAnyL = false;
        boolean isAnyP = false;
        boolean isAnyN = false;
        String[] grauImpl = implPorProj.values().toArray(new String[implPorProj.size()]);
        if(implPorProj.values().contains("N")) //CASO 6
            result = "N";
        else
        {
            for(int i = 0; i < grauImpl.length; i++){
                if(!grauImpl[i].equals("NA") && !different){
                    for(int j = i; j < grauImpl.length; j++)
                    {
                        if(!grauImpl[i].equals(grauImpl[j]) && !grauImpl[j].equals("NA")){
                            different = true;
                            break;
                        }
                        if(j == grauImpl.length-1)
                            result = grauImpl[i]; //Se todos iguais (CASO 1, CASO 2 (todos iguais e existe NA) e CASO 7(todos F))
                    }
                    if(!different)
                        break;
                }
                switch(grauImpl[i])
                {
                    case "F":
                        isAnyF = true;
                        break;
                    case "T":
                        isAnyT = true;
                        break;
                    case "L":
                        isAnyL = true;
                        break;
                    case "P":
                        isAnyP = true;
                        break;
                    case "N":
                        isAnyN = true;
                        break;
                }
            }
            if(((isAnyT || isAnyL)) && !(isAnyF || isAnyP || isAnyN)) //CASOS 3 e 4
                result = "L";
            else if(isAnyP && !isAnyN) //CASO 5
                result = "P";
        }
        return result;
    }
    
    //Verifica se todos os REs do processo para a UO estão caracterizados de forma que o processo pode ser classificado
    // como satisfeito
    public boolean validaReProc(Map<String, String> implREUO) {
        for (String grauImpl : implREUO.values()) {
            if(!grauImpl.equals("T") && !grauImpl.equals("L") && !grauImpl.equals("F"))
                return false;
        }
        return true;
    }

    // Verifica, de acordo com o nível, se os AP do processo estão caracterizados de forma que o processo pode ser classificado 
    // como satisfeito
    public boolean validaApProc(Map<String, String> grausImplAP) {
        switch(this.getNivel().getNome()) {
            case "G":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T;L")) 
                    return false;
                break;
            case "F":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T;L")
                        || !validaAp(grausImplAP, "AP2.2", "T;L"))
                    return false;
                break;
            case "E":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T")
                        || !validaAp(grausImplAP, "AP2.2", "T")
                        || !validaAp(grausImplAP, "AP3.1", "T;L")
                        || !validaAp(grausImplAP, "AP3.2", "T;L"))
                    return false;
                break;
            case "D":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T")
                        || !validaAp(grausImplAP, "AP2.2", "T")
                        || !validaAp(grausImplAP, "AP3.1", "T;L")
                        || !validaAp(grausImplAP, "AP3.2", "T;L"))
                    return false;
                break;
            case "C":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T")
                        || !validaAp(grausImplAP, "AP2.2", "T")
                        || !validaAp(grausImplAP, "AP3.1", "T;L")
                        || !validaAp(grausImplAP, "AP3.2", "T;L"))
                    return false;
                break;
            case "B":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T")
                        || !validaAp(grausImplAP, "AP2.2", "T")
                        || !validaAp(grausImplAP, "AP3.1", "T")
                        || !validaAp(grausImplAP, "AP3.2", "T")
                        || !validaAp(grausImplAP, "AP4.1", "T;L")
                        || !validaAp(grausImplAP, "AP4.2", "T;L"))
                    return false;
                break;
            case "A":
                if (!validaAp(grausImplAP, "AP1.1", "T")
                        || !validaAp(grausImplAP, "AP2.1", "T")
                        || !validaAp(grausImplAP, "AP2.2", "T")
                        || !validaAp(grausImplAP, "AP3.1", "T")
                        || !validaAp(grausImplAP, "AP3.2", "T")
                        || !validaAp(grausImplAP, "AP4.1", "T")
                        || !validaAp(grausImplAP, "AP4.2", "T")
                        || !validaAp(grausImplAP, "AP5.1", "T;L")
                        || !validaAp(grausImplAP, "AP5.2", "T;L"))
                    return false;
                break;
        }
        return true;
    }

    
    //Valida uma AP do processo i, de acordo com o nível escolhido (tabela 10)
    public boolean validaAp(Map<String, String> grausImplAP, String codAp, String valPossiveis) {
        List<String> valsList = Arrays.asList(valPossiveis.split(";"));
        return valsList.contains(grausImplAP.get(codAp));
    }
}