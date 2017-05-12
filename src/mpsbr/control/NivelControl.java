/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Nivel;
import mpsbr.model.Processo;
import mpsbr.model.ResultadoEsperado;
import mpsbr.view.MainView;
import mpsbr.view.cadastraNivel.ConsultaNivelView;
import mpsbr.view.cadastraNivel.SelecionaNivelConsultaView;
import mpsbr.view.cadastraNivel.addREProcessoView;
import mpsbr.view.cadastraNivel.cadastraAPView;
import mpsbr.view.cadastraNivel.cadastraProcessoView;
import mpsbr.view.cadastraNivel.cadastraREView;
import mpsbr.view.cadastraNivel.consultaAPView;
import mpsbr.view.cadastraNivel.consultaProcessoView;
import mpsbr.view.cadastraNivel.consultaREView;
import mpsbr.view.cadastraNivel.mainCadastroNivelView;
import mpsbr.view.cadastraNivel.selecionaNivelView;

/**
 *
 * @author gabriela
 */
public class NivelControl {

    //objeto da instancia da classe singleton
    private static NivelControl nc;
    
    //Views do fluxo de cadastro de nivel
    private selecionaNivelView snv;
    private mainCadastroNivelView cnv;
    private cadastraProcessoView cpv;
    private cadastraAPView capv;
    private cadastraREView crev;
    private addREProcessoView arev;
    private consultaProcessoView conspv;
    private consultaREView consrev;
    private SelecionaNivelConsultaView snconsv;
    private ConsultaNivelView consnv;
    private consultaAPView consapv;
    
    //Atributos do nivel sendo cadastrado
    private Nivel nivel;
    private Map<Processo,List<ResultadoEsperado>> processos;
    private List<AtributoDeProcesso> ap;
    
    private String codNovoProcesso;
    private Map<ResultadoEsperado, List<String>> novoProcesso;
    private Processo proprietario;
        
    private NivelControl()
    {
        this.setSnv(new selecionaNivelView());
        this.setCnv(new mainCadastroNivelView());
        this.setCpv(new cadastraProcessoView());
        this.setCrev(new cadastraREView());
        this.setCapv(new cadastraAPView());
        this.setArev(new addREProcessoView());
        this.setArev(new addREProcessoView());
        this.setConspv(new consultaProcessoView());
        this.setConsrev(new consultaREView());
        this.setConsnv(new ConsultaNivelView());
        this.setSnconsv(new SelecionaNivelConsultaView());
        this.setConsapv(new consultaAPView());
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Map<Processo, List<ResultadoEsperado>> getProcessos() {
        return processos;
    }

    public void setProcessos(Map<Processo, List<ResultadoEsperado>> processos) {
        this.processos = processos;
    }    

    public selecionaNivelView getSnv() {
        return snv;
    }

    public void setSnv(selecionaNivelView snv) {
        this.snv = snv;
    }

    public mainCadastroNivelView getCnv() {
        return cnv;
    }

    public void setCnv(mainCadastroNivelView cnv) {
        this.cnv = cnv;
    }

    public cadastraProcessoView getCpv() {
        return cpv;
    }

    public void setCpv(cadastraProcessoView cpv) {
        this.cpv = cpv;
    }

    public cadastraAPView getCapv() {
        return capv;
    }

    public void setCapv(cadastraAPView capv) {
        this.capv = capv;
    }

    public cadastraREView getCrev() {
        return crev;
    }

    public void setCrev(cadastraREView crev) {
        this.crev = crev;
    }

    public addREProcessoView getArev() {
        return arev;
    }

    public void setArev(addREProcessoView arev) {
        this.arev = arev;
    }

    public consultaProcessoView getConspv() {
        return conspv;
    }

    public void setConspv(consultaProcessoView conspv) {
        this.conspv = conspv;
    }

    public void setConsrev(consultaREView consrev) {
        this.consrev = consrev;
    }

    public consultaREView getConsrev() {
        return consrev;
    }

    public ConsultaNivelView getConsnv() {
        return consnv;
    }

    public void setConsnv(ConsultaNivelView consnv) {
        this.consnv = consnv;
    }

    public SelecionaNivelConsultaView getSnconsv() {
        return snconsv;
    }

    public void setSnconsv(SelecionaNivelConsultaView snconsv) {
        this.snconsv = snconsv;
    }

    public consultaAPView getConsapv() {
        return consapv;
    }

    public void setConsapv(consultaAPView consapv) {
        this.consapv = consapv;
    }

    public List<AtributoDeProcesso> getAp() {
        return ap;
    }

    public void setAp(List<AtributoDeProcesso> ap) {
        this.ap = ap;
    }

    public Map<ResultadoEsperado, List<String>> getNovoProcesso() {
        return novoProcesso;
    }

    public void setNovoProcesso(Map<ResultadoEsperado, List<String>> novoProcesso) {
        this.novoProcesso = novoProcesso;
    }
    
    public String getCodNovoProcesso() {
        return codNovoProcesso;
    }

    public void setCodNovoProcesso(String codNovoProcesso) {
        this.codNovoProcesso = codNovoProcesso;
    }

    public Processo getProprietario() {
        return proprietario;
    }

    public void setProprietario(Processo proprietario) {
        this.proprietario = proprietario;
    }
    
    public static NivelControl getInstance()
    {
        if(nc == null)
            nc = new NivelControl();
        return nc;
    }

    public void startCadastroNivel(String nivel) {
        
        Nivel nv = Nivel.getNivelFromDB(nivel.split(" ")[1]);
        this.setNivel(nv);
        
        Map<Processo,List<ResultadoEsperado>> procs = new HashMap<>();
        List<Processo> allProcs = Processo.getProcessosPorNivel(this.getNivel());
        List<ResultadoEsperado> res = null;
        for (Processo p : allProcs) {
            res = ResultadoEsperado.getAllResultadoEsperadoPorProcesso(p);
            if(res == null)
                res = new ArrayList<>();
            procs.put(p, res);
        }
        this.setProcessos(procs);
    
        List<AtributoDeProcesso> aps = AtributoDeProcesso.getAtributoDeProcessoPorNivel(this.getNivel());
        if(aps == null)
            aps = new ArrayList<>();
        this.setAp(aps);
        
        this.cadastroNivel();
    }
    
    public void startConsultaNivel(String nivel) {
        
        Nivel nv = Nivel.getNivelFromDB(nivel.split(" ")[1]);
        this.setNivel(nv);
        
        Map<Processo,List<ResultadoEsperado>> procs = new HashMap<>();
        List<Processo> allProcs = Processo.getProcessosPorNivel(this.getNivel());
        List<ResultadoEsperado> res = null;
        for (Processo p : allProcs) {
            res = ResultadoEsperado.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p);
            if(res == null)
                res = new ArrayList<>();
            procs.put(p, res);
        }
        this.setProcessos(procs);
    
        List<AtributoDeProcesso> aps = AtributoDeProcesso.getAtributoDeProcessoPorNivel(this.getNivel());
        if(aps == null)
            aps = new ArrayList<>();
        this.setAp(aps);
        
        this.consultaNivel();
    }

    public void cadastroProcesso() {
        this.getCpv().loadScreen();
        MainView.showPanel(MainView.CADASTRA_PROC);
    }
    
    public void cadastroProcesso(String codigo, String nome, String descricao){
        Processo p = new Processo(codigo, nome, descricao, this.getNivel().getNome());
        List<ResultadoEsperado> lst = new ArrayList<>();
        if(Processo.createProcessoInDB(p))
            this.processos.put(p, lst);
        if(novoProcesso != null){
            for (ResultadoEsperado re : novoProcesso.keySet()) {
                if(ResultadoEsperado.createREInDB(re, novoProcesso.get(re)))
                    lst.add(re);
            }
        }
        novoProcesso = null;
        codNovoProcesso = null;
        this.getCnv().loadScreen(this.processos, this.ap);
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }
    
    public void cadastroAP() {
        this.getCapv().loadScreen();
        MainView.showPanel(MainView.CADASTRA_AP);
    }

    public void cadastroAP(String codigo, String nome, String descricao) {
        AtributoDeProcesso ap = new AtributoDeProcesso(codigo, nome, descricao, this.getNivel().getNome());
        if (AtributoDeProcesso.createAPInDB(ap))
            this.ap.add(ap);
        this.getCnv().loadScreen(this.processos, this.ap);
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }

    public void cadastroRE(String codProcesso)
    {
        if(this.codNovoProcesso == null)
            codNovoProcesso = codProcesso;
        this.getCrev().loadScreen();
        MainView.showPanel(MainView.CADASTRA_RE);
    }

    public void cadastroRE(String codigo, String nome, String desc, List<String> niveis) 
    {   
        ResultadoEsperado re = null;
        if(codNovoProcesso != null){
            if(novoProcesso == null)
                novoProcesso = new HashMap<>();
            re = new ResultadoEsperado(codigo, nome, desc, codNovoProcesso);
            novoProcesso.put(re, niveis);
            this.getCpv().getResultados().add(re.getCodigo());
            this.getCpv().setREList(this.getCpv().getResultados());
            MainView.showPanel(MainView.CADASTRA_PROC);
        } else {
            re = new ResultadoEsperado(codigo, nome, desc, getProprietario().getCodigo());
            if(ResultadoEsperado.createREInDB(re, niveis))
                processos.get(proprietario).add(re);
            setProprietario(null);
            this.getArev().loadScreen(processos);
            MainView.showPanel(MainView.ADD_RE);
        }
    }

    /**
     *  Adiciona Resultado Esperado para um pro
     */
    public void addREProcess() {
//        int i;    
//        Map<String,List<String>> procs = new HashMap<>();
//        List<Processo> processos = Processo.getProcessosPorNivel(this.getNivel());
//        
//        for(Processo p : processos){
//            List<ResultadoEsperado> lst = ResultadoEsperado.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p);
//            List<String> res = new ArrayList<String>();
//            for(ResultadoEsperado r : lst){
//                res.add(r.getCodigo());
//            }
//            procs.put(p.getCodigo(),res);
//        }        
//        
        this.getArev().loadScreen(processos);
        MainView.showPanel(MainView.ADD_RE);
    }

    public void addREProcess(String codProcesso) {
        
        for(Processo p : this.getProcessos().keySet())
        {
            if(p.getCodigo().equals(codProcesso)){
                this.setProprietario(p);
            }
        }
        this.getCrev().loadScreen();
        MainView.showPanel(MainView.CADASTRA_RE);
    }
    
    public void consultaProc(Processo processo, List<ResultadoEsperado> lst){
        this.getConspv().loadScreen(processo, lst);
        MainView.showPanel(MainView.CONSULTA_PROC);
    }
    
    public void consultaRe(ResultadoEsperado re){
        this.getConsrev().loadScreen(re);
        MainView.showPanel(MainView.CONSULTA_RE);
    }
    
    public void consultaAp(AtributoDeProcesso ap){
        this.getConsapv().loadScreen(ap);
        MainView.showPanel(MainView.CONSULTA_AP);
    }
    
    /**
     * Carrega os valores para serem exibidos na tela de cadastro de nivel
     */
    private void cadastroNivel() {
        this.getCnv().loadScreen(this.getProcessos(), this.getAp());
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }
    
    private void consultaNivel() {
        this.getConsnv().loadScreen();
        MainView.showPanel(MainView.CONSULTA_NIVEL);
    }
    
    public boolean checaCadastroNivel(String nivel){
        return (Nivel.getNivelFromDB(nivel) != null);
    }
    
    public boolean cadastraNiveis(){
        return Nivel.cadastraAllNivel();
    }
}
