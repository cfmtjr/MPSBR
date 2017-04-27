/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.List;

/**
 *
 * @author gabriela
 */
public class Projeto {

    
    private int id;
    private String nome;
    private String descricao;
    private String faseDesenv;

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
    
    public Projeto(String nome, String descricao, String faseDesenv){
        this.nome = nome;
        this.descricao = descricao;
        this.faseDesenv = faseDesenv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
