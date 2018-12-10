/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.Date;

/**
 *
 * @author iurya
 */
public class BeansRegistroVenda {

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the valorDesconto
     */
    public float getValorDesconto() {
        return valorDesconto;
    }

    /**
     * @param valorDesconto the valorDesconto to set
     */
    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    /**
     * @return the idvenda
     */
    public int getIdvenda() {
        return idvenda;
    }

    /**
     * @param idvenda the idvenda to set
     */
    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the qtdItem
     */
    public int getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

  private int idvenda;
  private Date data;
  private float valorVenda;
  private String nomeCliente;
  private String nomeProduto;
  private int qtdItem;
  private float valorDesconto;
  private String formaPagamento;
}
