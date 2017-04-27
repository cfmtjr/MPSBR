/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import java.util.List;
import mpsbr.model.Avaliacao;
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
    
    private static AvaliacaoControl ac;
    
    private EscolheNivelView env;
    private EscolheProjetoView epv;
    private ExibeResultadoView erv;
    private AvaliaProcessoView apv;
    private Avaliacao currentAval;
    
    private AvaliacaoControl()
    {
        this.setEnv(new EscolheNivelView());
        this.setEpv(new EscolheProjetoView());
        this.setErv(new ExibeResultadoView());
        this.setApv(new AvaliaProcessoView());
    }
    
    public static AvaliacaoControl getInstance()
    {
        if(AvaliacaoControl.ac==null)
            return new AvaliacaoControl();
        else
            return AvaliacaoControl.ac;
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

    public void startAval(String nivel) {
        Avaliacao aval = new Avaliacao(nivel,true);
        this.setCurrentAval(aval);
        
        List<String> prj;
        prj = this.getCurrentAval().getProjectNames();
        
        this.getEpv().loadScr(prj);
        MainView.showPanel(MainView.SEL_PRJ);
    }

}
