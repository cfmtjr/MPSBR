/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mpsbr.DAO.ProjetoDAO;
import mpsbr.DAOImpl.ProjetoDAOImpl;

/**
 *
 * @author gabriela
 */
public class Projeto {

//    public static Map<String, String> getAllProjectNamesAndStatus() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    private int id;
    private String nome;
    private String descricao;
    private String cliente;
    private String gerente;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }    
    
    public Projeto(int id, String nome, String descricao, String faseDesenv, String cliente, String gerente){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.faseDesenv = faseDesenv;
        this.cliente = cliente;
        this.gerente = gerente;
    }

    public Projeto(String nome, String descricao, String faseDesenv, String cliente, String gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.faseDesenv = faseDesenv;
        this.cliente = cliente;
        this.gerente = gerente;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static Map<String,String> getAllProjectNamesAndStatus() {
        ProjetoDAO pd = new ProjetoDAOImpl();
        Map<String,String> names = new HashMap<String,String>();
        for(Projeto p  : pd.getAllProjeto()){
            names.put(p.getNome(), p.getDescricao());
        }
        return names;
    }
    
    public static boolean create(Projeto proj) {
        ProjetoDAO pd = new ProjetoDAOImpl();
        return pd.create(proj);
    }
    
    public static List<Projeto> getProjsAvaliados(List<String> nomesProjs){
        ProjetoDAO pd = new ProjetoDAOImpl();
        List<Projeto> result = new ArrayList<>();
        for (String nome : nomesProjs) {
            result.add(pd.findByNome(nome));
        }
        return result;
    }
}
