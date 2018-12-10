/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author iurya
 */
public class ConexãoSQL {
    public Statement stm;//responsavel por preparar e realizar pesquisas no bd  
    public ResultSet rs;//responsavel por armazenar o resultado de uma pesquisa passada para o Statement
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/db_RegistroVendas";
    private String usuario = "postgres";
    private String senha = "postgres";
   public Connection con;//responsavel por realizar conexão com bd
   
   public void conexão() { //metodo responsavel por fazer a conexão com banco de dados
   
       System.setProperty("jdbc.Drivers", driver);//seta a propriedadedo driver de conexão
       
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            
           // JOptionPane.showMessageDialog(null,"Conexão Efetuada com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se conectar com o banco de dados!\n"+ex);
        }
   }
   public void execultaSql(String sql) {
        try {
             
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao se conectar com o banco de dados!\n"+ex);
        }
   }
   public void desconecta(){ // metodo reponsavel por desconectar do banco de dados
    
        try {
            con.close();
           // JOptionPane.showMessageDialog(null, "Banco de Dados Desconectado com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com Banco de Dados !\n"+ex.getMessage());
        }
        
        
}
}   

   
   
    
 