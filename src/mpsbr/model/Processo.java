/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.List;
import mpsbr.DAO.ProcessoDAO;
import mpsbr.DAOImpl.ProcessoDAOImpl;

/**
 *
 * @author gabriela
 */
public class Processo {

    private int id;
    private String nome;
    private String descricao;
    private String nomeNivel;
    private String status;
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
    
    public Processo(int id,String nome, String descricao, String nomeNivel){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }
    
    public static List<Processo> getProcessosPorNivel(Nivel nivel) 
    {
        ProcessoDAO pd = new ProcessoDAOImpl();
        List<Processo> processoList = pd.getAllProcessoPorNivel(nivel);
        return processoList;
    }
}
