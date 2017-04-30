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
    private int id;
    private String nome;
    private int nivelAnteriorId; 

    public Nivel(int id,String nivel,String nivelAnterior,int nivelAnteriorId) {
        this.nome=nivel;
        this.id=id;
        this.nivelAnteriorId=nivelAnteriorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelAnteriorId() {
        return nivelAnteriorId;
    }

    public void setNivelAnteriorId(int nivelAnteriorId) {
        this.nivelAnteriorId = nivelAnteriorId;
    }
    
    public Nivel(String nome, int nivelAnteriorId){
        this.nome = nome;
        this.nivelAnteriorId = nivelAnteriorId;
    }
    
}
