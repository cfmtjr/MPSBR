/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import mpsbr.view.BuscaProjetoView;
import mpsbr.view.CadastraProjetoView;

/**
 *
 * @author gabriela
 */
public class ProjetoControl {
    
    static ProjetoControl pc;
    
    CadastraProjetoView cpv;
    BuscaProjetoView bpv;

    private ProjetoControl()
    {
        this.setBpv(new BuscaProjetoView());
        this.setCpv(new CadastraProjetoView());
    }
    
    /**
     * @return 
     */
    public static ProjetoControl getInstance()
    {
        if(ProjetoControl.pc == null)
            return new ProjetoControl();
        else
            return ProjetoControl.pc;
    }
    
    
    public CadastraProjetoView getCpv() {
        return cpv;
    }

    public void setCpv(CadastraProjetoView cpv) {
        this.cpv = cpv;
    }

    public BuscaProjetoView getBpv() {
        return bpv;
    }

    public void setBpv(BuscaProjetoView bpv) {
        this.bpv = bpv;
    }
    
    
    
}
