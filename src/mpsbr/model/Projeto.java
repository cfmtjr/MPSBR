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
public class Projeto {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFaseDesenv() {
        return faseDesenv;
    }

    public void setFaseDesenv(String faseDesenv) {
        this.faseDesenv = faseDesenv;
    }
    private String descricao;
    private String faseDesenv;
    
    public Projeto(){
        
    }
    
    
}
