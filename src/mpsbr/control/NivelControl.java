/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.control;

import mpsbr.view.CadastraNivelXMLView;

/**
 *
 * @author gabriela
 */
public class NivelControl {

    private static NivelControl nc;
    
    private CadastraNivelXMLView cnxv;

    
    private NivelControl()
    {
        this.setCnxv(new CadastraNivelXMLView());
    }
    
    public static NivelControl getInstance()
    {
        if(NivelControl.nc == null)
            return new NivelControl();
        else
            return NivelControl.nc;
    }
    
    public CadastraNivelXMLView getCnxv() {
        return cnxv;
    }

    public void setCnxv(CadastraNivelXMLView cnxv) {
        this.cnxv = cnxv;
    }
    
}
