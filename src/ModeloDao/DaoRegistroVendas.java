/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexãoSQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansRegistroVenda;

/**
 *
 * @author iurya
 */
public class DaoRegistroVendas {
   
    int codProd, codCliente;
    
     ConexãoSQL conex = new ConexãoSQL();
     
     public void adicionarItem(BeansRegistroVenda mod) {
         
         buscarCodigoProduto(mod.getNomeProduto());
       conex.conexão();
       
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into itens_venda_produto(id_venda, id_produto, quantidade_produto) values(?,?,?)");
            pst.setInt(1,mod.getIdvenda());
            pst.setInt(2,codProd);
            pst.setInt(3,mod.getQtdItem());
            pst.execute();
            conex.desconecta();
            
            //baixa de estoque
            int quant =0, result = 0;
            
            conex.conexão();
            conex.execultaSql("select * from tbprodutos where nome_produto='"+mod.getNomeProduto()+"'");
            conex.rs.first();
            quant = conex.rs.getInt("quantidade");
            result = quant - mod.getQtdItem();
            pst = conex.con.prepareStatement("update tbprodutos set quantidade=? where nome_produto=?");
            pst.setInt(1, result);
            pst.setString(2, mod.getNomeProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Produto adicionado!");
            
            conex.desconecta();
            
        } catch (SQLException ex) {
            conex.desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao realizar venda!"+ex);
        }
     }
     public void buscarCodigoProduto(String nome){
         conex.conexão();
         conex.execultaSql("select * from tbprodutos where nome_produto='"+nome+"'");
         try {
             conex.rs.first();
             codProd = conex.rs.getInt("id_produto");
             conex.desconecta();
         } catch (SQLException ex) {
             conex.desconecta();
             JOptionPane.showMessageDialog(null,"Erro:"+ex);
         }
     }
     
     public void FecharVenda(BeansRegistroVenda mod){
         AcharCliente(mod.getNomeCliente());
         conex.conexão();
     
        try {    
            PreparedStatement pst = conex.con.prepareStatement("update tbvenda set data_venda=?, valor_venda=?, valor_desconto=?, forma_pagamento=?, id_cliente=? where id_venda=?");
            

            java.sql.Date dataSql = new java.sql.Date(mod.getData().getTime());
            pst.setDate(1, dataSql);
            pst.setFloat(2,mod.getValorVenda());
            pst.setFloat(3,mod.getValorDesconto());
            pst.setString(4,mod.getFormaPagamento());
            pst.setInt(5, codCliente);
            pst.setInt(6, mod.getIdvenda());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Venda Finalizada!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar a venda!\nErro:"+ex);
        }
     conex.desconecta();
     
     }
     public void AcharCliente(String nome){

         conex.conexão();
     
        try {    
            conex.execultaSql("select * from tbcliente where nome='"+nome+"'");
            conex.rs.first();
            codCliente = conex.rs.getInt("id_cliente");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao achar cliente!\nErro:"+ex);
        }
}
   
     public void CancelaVenda() {
         conex.conexão();
         PreparedStatement pst ;
         conex.execultaSql("select * from tbvenda inner join itens_venda_produto on tbvenda.id_venda = itens_venda_produto.id_venda"
                 + " inner join tbprodutos on itens_venda_produto.id_produto = tbprodutos.id_produto where valor_venda=0");
          
         try {    
             conex.rs.first();
             do{
               int qtdProd = conex.rs.getInt("quantidade");
               int qtdVend = conex.rs.getInt("quantidade_produto");
               int soma = qtdProd + qtdVend;
                pst = conex.con.prepareStatement("update tbprodutos set quantidade=? where id_produto=?");
                pst.setInt(1,soma);
                pst.setInt(2,conex.rs.getInt("id_produto"));
                pst.execute();
                
                pst = conex.con.prepareStatement("delete from itens_venda_produto where id_venda=?");
                pst.setInt(1, conex.rs.getInt("id_venda"));
                pst.execute();
             }while(conex.rs.next());
             pst = conex.con.prepareStatement("delete from tbvenda where valor_venda=?");
            pst.setInt(1,0);
            pst.execute();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cancelar a venda!\nErro:"+ex);
                conex.execultaSql("DELETE FROM tbvenda WHERE valor_venda= 0");
        }
     conex.desconecta();
     
         
     }
}
   