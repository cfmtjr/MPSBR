/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.util.List;
import mpsbr.DAO.ResultadoEsperadoDAO;
import mpsbr.DAOImpl.ResultadoEsperadoDAOImpl;

/**
 *
 * @author gabriela
 */
public class ResultadoEsperado {
    private int id;
    private String nome;
    private String descricao;
    private String processoNome;

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

    public String getProcessoNome() {
        return processoNome;
    }

    public void setProcessoNome(String processoNome) {
        this.processoNome = processoNome;
    }
    
    public ResultadoEsperado(int id,String nome, String descricao, String processoNome){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.processoNome = processoNome;
    }

    public ResultadoEsperado(String nome, String descricao, String processoNome) {
        this.nome = nome;
        this.descricao = descricao;
        this.processoNome = processoNome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static List<ResultadoEsperado> getAllResultadoEsperadoPorNivelEProcesso(Nivel nivel, Processo processo){
        ResultadoEsperadoDAO re = new ResultadoEsperadoDAOImpl();
        
        return re.getAllResultadoEsperadoPorNivelEProcesso(nivel, processo);
    }
}
