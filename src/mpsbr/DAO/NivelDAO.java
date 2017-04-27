/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.DAO;

import java.util.ArrayList;
import mpsbr.model.Nivel;

/**
 *
 * @author gabriela
 */
public interface NivelDAO {
    public boolean create(Nivel nivel);
    public ArrayList<Nivel> getAllNivel();
    public Nivel findByName(String name);
    public boolean update(Nivel nivel);
}
