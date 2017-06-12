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
    private String codigo;
    private String nome;
    private String descricao;
    private String processoCodigo;

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

    public String getProcessoCodigo() {
        return processoCodigo;
    }

    public void setProcessoNome(String processoCodigo) {
        this.processoCodigo = processoCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public ResultadoEsperado(int id, String codigo, String nome, String descricao, String processoCodigo){
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.processoCodigo = processoCodigo;
    }

    public ResultadoEsperado(String codigo, String nome, String descricao, String processoCodigo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.processoCodigo = processoCodigo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static List<ResultadoEsperado> getAllResultadoEsperadoPorNivelEProcesso(Nivel nivel, Processo processo){
        ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();        
        return red.getAllResultadoEsperadoPorNivelEProcesso(nivel, processo);
    }
    
    public static List<ResultadoEsperado> getAllResultadoEsperadoPorProcesso(Processo processo){
        ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();        
        return red.getAllResultadoEsperadoPorProcesso(processo);
    }
    
    public static boolean createREInDB(ResultadoEsperado re, List<String> validoPara) {
        ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();
        return red.create(re, validoPara);
    }

    public static boolean reHasRegisteredLevel(ResultadoEsperado re, List<String> validoPara) {
        ResultadoEsperadoDAO red = new ResultadoEsperadoDAOImpl();
        List<String> niveisValidos = red.getAllNivelValidoParaRE(re);
        if(niveisValidos != null) {
            for (String nivel : niveisValidos) {
                if(validoPara.contains(nivel))
                    return true;
            }
        }
        return false;
    }
}
