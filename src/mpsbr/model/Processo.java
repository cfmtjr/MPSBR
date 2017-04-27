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
public class Processo {
    private String nome;
    private String descricao;
    private String nomeNivel;
    
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

    public String getNomeNivel() {
        return nomeNivel;
    }

    public void setNomeNivel(String nomeNivel) {
        this.nomeNivel = nomeNivel;
    }
    
    public Processo(String nome, String descricao, String nomeNivel){
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }
}
