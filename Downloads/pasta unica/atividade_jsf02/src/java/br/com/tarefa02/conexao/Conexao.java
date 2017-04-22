
package br.com.tarefa02.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
   private static Connection con;
   private static String banco_url = "jdbc:mysql://localhost:3306/tarefa02";
   private static String usuario = "root";
   private static String senha = "";
   
   
   public static Connection conectar(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(banco_url,usuario,senha);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return con;
   }
}
