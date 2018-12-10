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
import modeloBeans.BeansProdutos;

/**
 *
 * @author iurya
 */
public class DaoProdutos {

    //conexão com Banco de dados
    ConexãoSQL conex = new ConexãoSQL();
    BeansProdutos mod = new BeansProdutos();

    public void Salvar(BeansProdutos mod) {
        conex.conexão();

        try {// insere os dados na tbcproduto
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO tbprodutos (codigo_produto, nome_produto, preco_venda,"
                    + "Quantidade, preco_compra) VALUES(?, ?, ?, ?, ?)");

            pst.setString(1, mod.getCodigo_produto());
            pst.setString(2, mod.getDescrição());
            pst.setDouble(3, mod.getPreco());
            pst.setInt(4, mod.getQuantidade());
            pst.setDouble(5, mod.getPrecoCompra());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) { // imforma o erro
            JOptionPane.showMessageDialog(null, "Erro ao Inserir dados!" + ex);
        }

        conex.desconecta();

    }

    public void Editar(BeansProdutos mod) {//metodo edição
        conex.conexão();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update tbProdutos set nome_produto=?, preco_venda=?, quantidade=?, preco_compra=? Where Codigo_Produto=?");
            
            pst.setString(1, mod.getDescrição());
            pst.setDouble(2, mod.getPreco());
            pst.setInt(3, mod.getQuantidade());
            pst.setDouble(4, mod.getPrecoCompra());
            pst.setString(5, mod.getCodigo_produto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Alteração de dados!/nErro:" + ex);
        }

        conex.desconecta();

    }

    public void Excluir(BeansProdutos mod) {
        conex.conexão();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from tbProdutos Where Codigo_Produto=?");
            pst.setString(1, mod.getCodigo_produto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Produto!/nErro:" + ex);
        }
        conex.desconecta();

    }

    public BeansProdutos buscaProduto(BeansProdutos mod) {

        conex.conexão();
        conex.execultaSql("select * from tbProdutos Where nome_produto like'%" + mod.getPesquisa() + "%'");
        try {
            conex.rs.first();
            mod.setCodigo_produto(conex.rs.getString("codigo_produto"));
            mod.setDescrição(conex.rs.getString("nome_produto"));
            mod.setPreco(conex.rs.getDouble("preco_venda"));
            mod.setQuantidade(conex.rs.getInt("quantidade"));
            mod.setPrecoCompra(conex.rs.getDouble("preco_compra"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Produtos!" + ex);
        }

        conex.desconecta();
        return mod;
    }
}
