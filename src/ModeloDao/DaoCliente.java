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
import modeloBeans.BeansCliente;

/**
 *
 * @author iurya
 */
public class DaoCliente {
    //conexão com Banco de dados
    ConexãoSQL conex = new ConexãoSQL();
    BeansCliente mod = new BeansCliente();
     
    public void Salvar(BeansCliente mod){
        conex.conexão();
        
        try {// insere os dados na tbcliente
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO tbcliente (cpf, nome, endereco, complemento, bairro, cidade, uf, cep, "
                    + "telefonecelular, telefonecomercial, telefoneresidencial, ddd) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst.setString(1,mod.getCpf());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getEndereco());
            pst.setString(4, mod.getComplemento());
            pst.setString(5, mod.getBairro()); 
            pst.setString(6, mod.getCidade());
            pst.setString(7, mod.getUf());
            pst.setString(8, mod.getCep());
            pst.setString(9, mod.getTelefoneCelular());
            pst.setString(10, mod.getTelefoneComercial());
            pst.setString(11, mod.getTelefoneResidencial());
            pst.setString(12, mod.getDDD());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
        } catch (SQLException ex) { // imforma o erro
            JOptionPane.showMessageDialog(null, "Erro ao Inserir dados!"+ex);
        }
        
        conex.desconecta();
    
    }
    
    public void Editar(BeansCliente mod){//metodo edição
        conex.conexão();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update tbcliente set nome=?, endereco=?, complemento=?, cidade=?,uf=?, bairro=?, cep=?, ddd=?, telefonecelular=?, telefoneresidencial=?, telefonecomercial=? Where cpf =?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getComplemento());
            pst.setString(4, mod.getCidade());
            pst.setString(5, mod.getUf());
            pst.setString(6, mod.getBairro());
            pst.setString(7,mod.getCep());
            pst.setString(8, mod.getDDD());
            pst.setString(9, mod.getTelefoneCelular());
            pst.setString(10, mod.getTelefoneResidencial());
            pst.setString(11, mod.getTelefoneComercial());
            pst.setString(12, mod.getCpf());
            
            pst.execute();
          JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Alteração de dados!/nErro:"+ex);
        }
        
        conex.desconecta();
        

    }
    
    public void Excluir(BeansCliente mod){
    conex.conexão();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from tbcliente Where cpf=?");
        pst.setString(1, mod.getCpf());
       
           
        pst.execute();
        JOptionPane.showMessageDialog(null, "Dados Excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir dados!/nErro:"+ex);
        }
    conex.desconecta();
    
    
    }
    
        public BeansCliente buscaCliente(BeansCliente mod){
            
            conex.conexão();
            conex.execultaSql("select * from tbcliente Where nome like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            //mod.setCodigo(conex.rs.getInt("codigo_id"));
            
             mod.setCodigo(conex.rs.getInt("id_cliente"));
            mod.setNome(conex.rs.getString("nome"));
           mod.setCpf(conex.rs.getString("cpf"));
           mod.setCep(conex.rs.getString("cep"));
           mod.setBairro(conex.rs.getString("bairro"));
            mod.setEndereco(conex.rs.getString("endereco"));
           mod.setComplemento(conex.rs.getString("complemento"));
           mod.setCidade(conex.rs.getString("cidade"));
           mod.setUf(conex.rs.getString("uf"));
           mod.setDDD(conex.rs.getString("ddd"));
           mod.setTelefoneCelular(conex.rs.getString("telefonecelular"));
           mod.setTelefoneResidencial(conex.rs.getString("telefoneresidencial"));
           mod.setTelefoneComercial(conex.rs.getString("telefonecomercial")); 
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Cliente!"+ex);
        }
            
            conex.desconecta();
            return mod;
        }
  }
