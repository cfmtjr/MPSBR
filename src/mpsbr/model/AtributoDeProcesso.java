/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.List;
import mpsbr.DAO.AtributoDeProcessoDAO;
import mpsbr.DAOImpl.AtributoDeProcessoDAOImpl;

/**
 *
 * @author gabriela
 */
public class AtributoDeProcesso {
    
    private int id;
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
    
    public AtributoDeProcesso(int id, String nome, String descricao, String nomeNivel){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    static List<AtributoDeProcesso> getAtributoDeProcessoPorNivel(Nivel n) 
    {
        AtributoDeProcessoDAO pd = new AtributoDeProcessoDAOImpl();
        List<AtributoDeProcesso> processoList = pd.getAllAtributoDeProcessoPorNivel(n);
        return processoList;
    }
}
