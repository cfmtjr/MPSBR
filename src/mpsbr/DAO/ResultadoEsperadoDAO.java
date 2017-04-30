/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import mpsbr.model.Nivel;
import mpsbr.model.ResultadoEsperado;

/**
 *
 * @author gabriela
 */
public interface ResultadoEsperadoDAO {
    public boolean create(ResultadoEsperado re);
    public ArrayList<ResultadoEsperado> getAllResultadoEsperado();
    public ArrayList<ResultadoEsperado> getAllResultadoEsperadoPorNivel(Nivel nivel);
    public ResultadoEsperado findByNome(String nome);
    public boolean update(String nome);    
}