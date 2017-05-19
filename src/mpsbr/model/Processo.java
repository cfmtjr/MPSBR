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
    private String codigo;
    private String nome;
    private String descricao;
    private String nomeNivel;
    private String status;
    private static ProcessoDAO pd = new ProcessoDAOImpl();

    
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Processo(int id, String codigo, String nome,String descricao, String nomeNivel){
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }
    
    public Processo(String codigo, String nome, String descricao, String nomeNivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }
    
    public static List<Processo> getProcessosPorNivel(Nivel nivel) 
    {
        List<Processo> processoList = pd.getAllProcessoPorNivel(nivel);
        return processoList;
    }
    
    public static boolean createProcessoInDB(Processo processo){
        return pd.create(processo);
    }
}