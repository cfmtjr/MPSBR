/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import mpsbr.model.Projeto;
import mpsbr.view.BuscaProjetoView;
import mpsbr.view.CadastraProjetoView;
import mpsbr.view.ConsultaProjetoView;

/**
 *
 * @author gabriela
 */
public class ProjetoControl {
    
    static ProjetoControl pc;
    
    CadastraProjetoView cpv;
    BuscaProjetoView bpv;
    ConsultaProjetoView copv;

    private ProjetoControl()
    {
        this.setBpv(new BuscaProjetoView());
        this.setCpv(new CadastraProjetoView());
        this.setCopv(new ConsultaProjetoView());
    }
    
    /**
     * @return 
     */
    public static ProjetoControl getInstance()
    {
        if (pc == null)
            pc = new ProjetoControl();
        return pc;
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

    public ConsultaProjetoView getCopv() {
        return copv;
    }

    public void setCopv(ConsultaProjetoView copv) {
        this.copv = copv;
    }
    
    public boolean cadastraProj(Projeto proj){
        boolean b;
        b = Projeto.create(proj);
        this.getCpv().loadScreen();
        return b;
    }
    
    public boolean verificaSeExiste(String nome){
        if(Projeto.getByNome(nome) != null)
            return true;
        return false;
    }
    
}
