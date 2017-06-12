/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.List;
import java.util.Map;
import mpsbr.DAO.AtributoDeProcessoDAO;
import mpsbr.DAOImpl.AtributoDeProcessoDAOImpl;

/**
 *
 * @author gabriela
 */
public class AtributoDeProcesso {
    
    private int id;
    private String codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public AtributoDeProcesso(int id, String codigo, String nome, String descricao, String nomeNivel){
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeNivel = nomeNivel;
    }

    public AtributoDeProcesso(String codigo, String nome, String descricao, String nomeNivel) {
        this.codigo = codigo;
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
    
    public static List<AtributoDeProcesso> getAtributoDeProcessoPorNivel(Nivel n) {
        AtributoDeProcessoDAO apd = new AtributoDeProcessoDAOImpl();
        List<AtributoDeProcesso> processoList = apd.getAllAtributoDeProcessoPorNivel(n);
        return processoList;
    }

    public static boolean createAPInDB(AtributoDeProcesso ap) {
        AtributoDeProcessoDAO apd = new AtributoDeProcessoDAOImpl();
        return apd.create(ap);
    }
    
    public static Map<String, List<String>> getNotasPorNivelEAp(String nomeNivel) {
        AtributoDeProcessoDAO apd = new AtributoDeProcessoDAOImpl();
        return apd.getAllNotasPorNivelEAP(nomeNivel);
    }
}
