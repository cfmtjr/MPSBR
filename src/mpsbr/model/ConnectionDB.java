/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.lineSeparator;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gabriela
 */
public class ConnectionDB {
    
    public ConnectionDB(){
        
//        try {
//            this.loadValues();
//        } catch (IOException ex) {
//            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String serverName = "127.0.0.1:3306";     //caminho do servidor do BD
    private static String dbName = "mydb";         //nome do BD
    private static String url = "jdbc:mysql://"+ serverName + "/" + dbName;
    private static String user = "root";
    private static String password = "root";    //ENCONTRAR PARAMETRO PARA ATUALIZAR USUARIO E SENHA
    private Connection newConnection;
    
    
    public void loadValues() throws IOException{
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("config.cfg"));
            try{
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while(line != null){
                    sb.append(line);
                    sb.append(lineSeparator());
                    line = br.readLine();
                }

                String[] separated = StringUtils.splitByWholeSeparator(sb.toString(), " ");
                ConnectionDB.serverName = separated[0];
                ConnectionDB.user = separated[1];
                ConnectionDB.password = separated[2];
                
                ConnectionDB.url="jdbc:mysql://" + ConnectionDB.serverName + "/" + ConnectionDB.dbName;

            }
            finally
            {
                br.close();
            }
        }catch(java.io.FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Configurar os dados do Servidor antes de realizar a busca");
        }
        
    }
    
    public static void setInfoDB(String driverName, String serverName, String dbName, String user, String password){
        ConnectionDB.driverName = driverName;
        ConnectionDB.serverName = serverName;
        ConnectionDB.dbName = dbName;
        ConnectionDB.url = "jdbc:mysql://" + serverName + "/" + dbName;
        ConnectionDB.user = user;
        ConnectionDB.password = password;
    }
    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driverName);
            newConnection = DriverManager.getConnection(url, user, password);
            return newConnection;
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "O driver especificado não foi encontrado");
            return null;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao acessar banco de dados.");
            return null;
        }
    }
}
