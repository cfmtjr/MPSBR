/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import mpsbr.DAO.NivelDAO;
import mpsbr.DAOImpl.NivelDAOImpl;

/**
 *
 * @author gabriela
 */
public class Nivel {
    private String nome;
    private String status;
    private Nivel nivelAnterior; 

    public Nivel(String nome, String status, Nivel nivelAnterior) {
        this.nome = nome;
        this.status = status;
        this.nivelAnterior = nivelAnterior;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Nivel getNivelAnterior() {
        return nivelAnterior;
    }

    public void setNivelAnterior(Nivel nivelAnterior) {
        this.nivelAnterior = nivelAnterior;
    }
    
    public static Nivel getNivelFromDB(String nivel){
        NivelDAO nv = new NivelDAOImpl();
        return nv.findByName(nivel);
    }
    
    public static boolean cadastraAllNivel(){
        NivelDAO nv = new NivelDAOImpl();
        return nv.createAllNivel();
    }
    
    public static boolean habilitaNivel(String nome){
        NivelDAO nv = new NivelDAOImpl();
        return nv.habilitaNivel(nome);
    }
    
}
