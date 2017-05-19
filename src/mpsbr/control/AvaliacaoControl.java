/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.DAOImpl.AvaliacaoDAOImpl;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Avaliacao;
import mpsbr.model.Implementa;
import mpsbr.model.Processo;
import mpsbr.model.Projeto;
import mpsbr.model.ResultadoEsperado;
import mpsbr.view.MainView;
import mpsbr.view.simulaAvaliacao.AvaliaProcessoView;
import mpsbr.view.simulaAvaliacao.EscolheNivelView;
import mpsbr.view.simulaAvaliacao.EscolheProjetoView;
import mpsbr.view.simulaAvaliacao.ExibeResultadoView;

/**
 *
 * @author gabriela
 */
public class AvaliacaoControl {
    
    //Referencia objeto Singleton
    private static AvaliacaoControl ac;
    
    //Referencia as views
    private EscolheNivelView env;
    private EscolheProjetoView epv;
    private ExibeResultadoView erv;
    private AvaliaProcessoView apv;
    
    //Referencia ao objeto da avaliacao
    private Avaliacao currentAval;
    private List<Processo> listProcessos;
    private List<Projeto> projsAvaliados;
    private List<AtributoDeProcesso> listAtributoDeProcessos;
    private Map<Processo, List<ResultadoEsperado>> mapResultadoEsperado;
    private Map<Processo, List<Implementa<ResultadoEsperado>>> mapImplProjRE; 
    private Map<Processo, List<Implementa<AtributoDeProcesso>>> mapImplProjAP; 
    
    private int currentProcesso = 0;
    
    private AvaliacaoControl()
    {
        this.setEnv(new EscolheNivelView());
        this.setEpv(new EscolheProjetoView());
        this.setErv(new ExibeResultadoView());
        this.setApv(new AvaliaProcessoView());
    }
    
    public static AvaliacaoControl getInstance()
    {
        if(ac == null)
            ac = new AvaliacaoControl();
        return ac;
    }

    public Avaliacao getCurrentAval() {
        return currentAval;
    }

    public void setCurrentAval(Avaliacao currentAval) {
        this.currentAval = currentAval;
    }  

    public EscolheNivelView getEnv() {
        return env;
    }

    public void setEnv(EscolheNivelView env) {
        this.env = env;
    }

    public EscolheProjetoView getEpv() {
        return epv;
    }

    public void setEpv(EscolheProjetoView epv) {
        this.epv = epv;
    }

    public ExibeResultadoView getErv() {
        return erv;
    }

    public void setErv(ExibeResultadoView erv) {
        this.erv = erv;
    }

    public AvaliaProcessoView getApv() {
        return apv;
    }

    public void setApv(AvaliaProcessoView apv) {
        this.apv = apv;
    }

    public List<Processo> getListProcessos() {
        return listProcessos;
    }

    public void setListProcessos(List<Processo> listProcessos) {
        this.listProcessos = listProcessos;
    }

    public List<AtributoDeProcesso> getListAtributoDeProcessos() {
        return listAtributoDeProcessos;
    }

    public void setListAtributoDeProcessos(List<AtributoDeProcesso> listAtributoDeProcessos) {
        this.listAtributoDeProcessos = listAtributoDeProcessos;
    }

    public Map<Processo, List<ResultadoEsperado>> getMapResultadoEsperado() {
        return mapResultadoEsperado;
    }

    public void setMapResultadoEsperado(Map<Processo, List<ResultadoEsperado>> mapResultadoEsperado) {
        this.mapResultadoEsperado = mapResultadoEsperado;
    }

    public Map<Processo, List<Implementa<AtributoDeProcesso>>> getMapImplProjAP() {
        return mapImplProjAP;
    }

    public void setMapImplProjAP(Map<Processo, List<Implementa<AtributoDeProcesso>>> mapImplProjAP) {
        this.mapImplProjAP = mapImplProjAP;
    }

    public Map<Processo, List<Implementa<ResultadoEsperado>>> getMapImplProjRE() {
        return mapImplProjRE;
    }

    public void setMapImplProjRE(Map<Processo, List<Implementa<ResultadoEsperado>>> mapImplProjRE) {
        this.mapImplProjRE = mapImplProjRE;
    }

    public List<Projeto> getProjsAvaliados() {
        return projsAvaliados;
    }

    public void setProjsAvaliados(List<Projeto> projsAvaliados) {
        this.projsAvaliados = projsAvaliados;
    }
    
    public void preAval(String nivel) {
        Avaliacao aval = new Avaliacao(nivel.split(" ")[1],true);
        this.setCurrentAval(aval);
        Map<String,String> prj;
        //TODO descomentar a linha abaixo e comentar a seguinte quando estiver concluido
        prj = Projeto.getAllProjectNamesAndStatus();
        this.getEpv().loadScr(prj);
        MainView.showPanel(MainView.SEL_PRJ);
    }
        
    /**
     * Inicia o processo de avaliacao com os projetos escolhidos pelo usuario
     * @param projetos 
     */
    public void startAval(List<String> projetos)
    {
        //Pegar os processos do nivel escolhido pra baixo
        this.setProjsAvaliados(Projeto.getProjsAvaliados(projetos));
        this.setListProcessos(this.getCurrentAval().listProcessos());
        this.setListAtributoDeProcessos(this.getCurrentAval().listAtributosDeProcesso());
        this.setMapResultadoEsperado(this.getCurrentAval().mapResultadoEsperado(this.getListProcessos()));
        this.setMapImplProjRE(new HashMap<>());
        this.setMapImplProjAP(new HashMap<>());
        this.currentProcesso = 0;
        nextProcessAval();
    }

    public void nextProcessAval(){
        if(currentProcesso < listProcessos.size()){
            this.getApv().loadScreen(projsAvaliados, listProcessos.get(currentProcesso));
            currentProcesso++;
            MainView.showPanel(MainView.DO_AVL);
        } else { //avalia, envia pra tela o resultado e, caso queira salvar o resultado, chamar saveAval
            currentAval.avalia();
            this.getErv().loadScreen();
            MainView.showPanel(MainView.RESULT_AVL); //finaliza
        }
    }
    
    public void saveAval(){
        AvaliacaoDAOImpl av = new AvaliacaoDAOImpl();
        av.create(currentAval);
        av.saveProcessoSatisfazAvaliacao(currentAval, listProcessos);
        av.saveResultAvaliacaoRE(currentAval, mapImplProjRE);
        av.saveResultAvaliacaoAP(currentAval, mapImplProjAP);
    }
}
    