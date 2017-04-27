/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

/**
 *
 * @author gabriela
 */
public class Nivel {
    private String nome;
    private Nivel nivelAnterior;

    public Nivel(String nivel) {
        this.nome=nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel getNivelAnterior() {
        return nivelAnterior;
    }

    public void setNivelAnterior(Nivel nivelAnterior) {
        this.nivelAnterior = nivelAnterior;
    }
    
    public Nivel(String nome, Nivel nivelAnterior){
        this.nome = nome;
        this.nivelAnterior = nivelAnterior;
    }
    
}
