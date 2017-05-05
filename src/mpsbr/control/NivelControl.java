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
import mpsbr.view.cadastraNivel.addREProcessoView;
import mpsbr.view.cadastraNivel.cadastraAPView;
import mpsbr.view.cadastraNivel.cadastraProcessoView;
import mpsbr.view.cadastraNivel.cadastraREView;
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
    
    //Atributos do nivel sendo cadastrado
    private Nivel nivel;
    private Map<Processo,List<ResultadoEsperado>> processos;
    private List<AtributoDeProcesso> ap;
    
    private Processo proprietaria;
    
    private NivelControl()
    {
        this.setSnv(new selecionaNivelView());
        this.setCnv(new mainCadastroNivelView());
        this.setCpv(new cadastraProcessoView());
        this.setCrev(new cadastraREView());
        this.setCapv(new cadastraAPView());
        this.setArev(new addREProcessoView());
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

    public List<AtributoDeProcesso> getAp() {
        return ap;
    }

    public void setAp(List<AtributoDeProcesso> ap) {
        this.ap = ap;
    }

    public Processo getProprietaria() {
        return proprietaria;
    }

    public void setProprietaria(Processo proprietaria) {
        this.proprietaria = proprietaria;
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
        for (Processo p : allProcs) {
            procs.put(p, ResultadoEsperado.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p));
        }
        this.setProcessos(procs);
    
        List<AtributoDeProcesso> aps = AtributoDeProcesso.getAtributoDeProcessoPorNivel(this.getNivel());
        this.setAp(aps);
        
        this.cadastroNivel();
    }

    public void cadastroProcesso() {
        this.getCpv().loadScreen();
        MainView.showPanel(MainView.CADASTRA_PROC);
    }
    
    public void cadastroProcesso(String codigo, String nome, String descricao){
        Processo p = new Processo(codigo, nome, descricao, this.getNivel().getNome());
        if(Processo.createProcessoInDB(p))
            this.processos.put(p, new ArrayList<>());
        this.getCnv().loadScreen(this.processos, this.ap);
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }
    
    public void cadastroAP() {
        this.getCpv().loadScreen();
        MainView.showPanel(MainView.CADASTRA_AP);
    }

    public void cadastroAP(String codigo, String nome, String descricao) {
        AtributoDeProcesso ap = new AtributoDeProcesso(codigo, nome, descricao, this.getNivel().getNome());
        if (AtributoDeProcesso.createAPInDB(ap))
            this.ap.add(ap);
        this.getCnv().loadScreen(this.processos, this.ap);
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }

    public void cadastroRE()
    {
        this.getCrev().loadScreen();
        MainView.showPanel(MainView.CADASTRA_RE);
    }

    public void cadastroRE(String codigo, String nome, String desc, List<String> niveis) 
    {    
        ResultadoEsperado re = new ResultadoEsperado(codigo, nome, desc, this.getProprietaria().getCodigo());
        if(ResultadoEsperado.createREInDB(re, niveis))
            this.processos.get(this.getProprietaria()).add(re);
        this.setProprietaria(null);
        this.getCnv().loadScreen(this.processos, this.ap);
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }

    /**
     *  Adiciona Resultado Esperado para um pro
     */
    public void addREProcess() {
        int i;
        Map<String,List<String>> procs = new HashMap<>();
        List<Processo> processos = Processo.getProcessosPorNivel(this.getNivel());
        
        for(Processo p : processos){
            List<ResultadoEsperado> lst = ResultadoEsperado.getAllResultadoEsperadoPorNivelEProcesso(this.getNivel(), p);
            List<String> res = new ArrayList<String>();
            for(ResultadoEsperado r : lst){
                res.add(r.getCodigo());
            }
            procs.put(p.getCodigo(),res);
        }        
        
        this.getArev().loadScreen(procs);
        MainView.showPanel(MainView.ADD_RE);
    }



    public void addREProcess(String codProcesso) {
        
        for(Processo p : this.getProcessos().keySet())
        {
            if(p.getCodigo().equals(codProcesso)){
                this.setProprietaria(p);
            }
        }
        this.getCrev().loadScreen();
        MainView.showPanel(MainView.CADASTRA_RE);
    }

    public void cadastroRE(String processo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Carrega os valores para serem exibidos na tela de cadastro de nivel
     */
    private void cadastroNivel() {
        
        this.getCnv().loadScreen(this.getProcessos(), this.getAp());
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }
}
