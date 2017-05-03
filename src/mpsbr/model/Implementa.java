/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.Map;

/**
 *
 * @author gabriela
 */
public class Implementa<T> {
    private String dataAval;
    private Map<Projeto, String> grauImplPorProj;
    private T caracteristicaAvaliada;

    public String getDataAval() {
        return dataAval;
    }

    public void setDataAval(String dataAval) {
        this.dataAval = dataAval;
    }

    public T getCaracteristicaAvaliada() {
        return caracteristicaAvaliada;
    }

    public void setCaracteristicaAvaliada(T caracteristicaAvaliada) {
        this.caracteristicaAvaliada = caracteristicaAvaliada;
    }

    public Map<Projeto, String> getGrauImplPorProj() {
        return grauImplPorProj;
    }

    public void setGrauImplPorProj(Map<Projeto, String> grauImplPorProj) {
        this.grauImplPorProj = grauImplPorProj;
    }
    
    public Implementa(String dataAval, Map<Projeto, String> grauImplProProj, T caracteristicaAvaliada){
        this.grauImplPorProj = grauImplProProj;
        this.caracteristicaAvaliada = caracteristicaAvaliada;
    }
}
