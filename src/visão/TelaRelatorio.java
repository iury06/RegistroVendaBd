/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visão;

import ModeloConection.ConexãoSQL;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modeloBeans.ModeloTabela;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author iurya
 */
public class TelaRelatorio extends javax.swing.JFrame {
    ConexãoSQL conex = new ConexãoSQL();
    /**
     * Creates new form TelaRelatorio
     */
    public TelaRelatorio() {
        initComponents();
        try {
            MaskFormatter form = new MaskFormatter("##/##/####");//elemento que cria o formato da data
            DataInIcial.setFormatterFactory(new DefaultFormatterFactory(form));
            DataFinal.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            Logger.getLogger(RegistroVendas.class.getName()).log(Level.SEVERE, null, ex);
        }   
         
        
    }

    public void preencherTabela(String Sql){
    ArrayList dados = new ArrayList();
    String[] colunas = new String[]{" Id Venda "," Valor Desconto "," Valor Venda "," Forma Pagamento "," Id Cliente "," Data Venda"};
    
    conex.conexão();
    conex.execultaSql(Sql);
    
    try{
        conex.rs.first();
        do{
           dados.add(new Object[]{conex.rs.getString("id_venda"),conex.rs.getString("valor_desconto"), conex.rs.getString("valor_venda"),conex.rs.getString("forma_pagamento"),conex.rs.getString("id_cliente"),conex.rs.getString("data_venda")});
            
        }while(conex.rs.next());
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(rootPane, "Erro ao preencher um ArrayList"+ex);
    }
    ModeloTabela modelo = new ModeloTabela(dados, colunas);
    
    tabelaPesquisa.setModel(modelo);
    tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(90);
    tabelaPesquisa.getColumnModel().getColumn(0).setResizable(false);
    
    tabelaPesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);//largura
    tabelaPesquisa.getColumnModel().getColumn(1).setResizable(false);

    tabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);
    tabelaPesquisa.getColumnModel().getColumn(2).setResizable(false);

    tabelaPesquisa.getColumnModel().getColumn(3).setPreferredWidth(175);
    tabelaPesquisa.getColumnModel().getColumn(3).setResizable(false);

    tabelaPesquisa.getColumnModel().getColumn(4).setPreferredWidth(80);
    tabelaPesquisa.getColumnModel().getColumn(4).setResizable(false);

    tabelaPesquisa.getColumnModel().getColumn(5).setPreferredWidth(140);
    tabelaPesquisa.getColumnModel().getColumn(5).setResizable(false);
    
    tabelaPesquisa.getTableHeader().setResizingAllowed(false);
    tabelaPesquisa.setAutoResizeMode(tabelaPesquisa.AUTO_RESIZE_OFF);
    tabelaPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  
    conex.desconecta();
    }
    
    
    
    public void tabelamaxCliente(String Sql){
    ArrayList dados = new ArrayList();
    String[] colunas = new String[]{" Id Cliente "};
    conex.conexão();
    conex.execultaSql(Sql);
    
    try{
        conex.rs.first();
        do{
           dados.add(new Object[]{conex.rs.getString("id_cliente")});
            
        }while(conex.rs.next());
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(rootPane, "Erro ao preencher um ArrayList"+ex);
    }
    ModeloTabela modelo = new ModeloTabela(dados, colunas);
    
    MaxCliente.setModel(modelo);
    MaxCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
    MaxCliente.getColumnModel().getColumn(0).setResizable(false);
    
    MaxCliente.getTableHeader().setResizingAllowed(false);
    MaxCliente.setAutoResizeMode(MaxCliente.AUTO_RESIZE_OFF);
    MaxCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     
    conex.desconecta();
    }
    
    public void modaValorVendido(String Sql){
    ArrayList dados = new ArrayList();
    String[] colunas = new String[]{" Moda R$ "};
    conex.conexão();
    conex.execultaSql(Sql);
    
    try{
        conex.rs.first();
        do{
           dados.add(new Object[]{conex.rs.getString("valor_venda")});
            
        }while(conex.rs.next());
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(rootPane, "Erro ao preencher um ArrayList"+ex);
    }
    ModeloTabela modelo = new ModeloTabela(dados, colunas);
    tabelaModa.setModel(modelo);
    tabelaModa.getColumnModel().getColumn(0).setPreferredWidth(100);
    tabelaModa.getColumnModel().getColumn(0).setResizable(false);
    
    tabelaModa.getTableHeader().setResizingAllowed(false);
    tabelaModa.setAutoResizeMode(tabelaModa.AUTO_RESIZE_OFF);
    tabelaModa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     
    conex.desconecta();
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DataInIcial = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DataFinal = new javax.swing.JFormattedTextField();
        ButtonImprimir = new javax.swing.JButton();
        ButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPesquisa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MaxCliente = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaModa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        idCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dataV = new javax.swing.JTextField();
        campoV = new javax.swing.JTextField();
        campoIdVenda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoQtd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CampoValorTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoMedia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoModaPagamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonGrafico = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        CampoCredito = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CampoDebito = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CampoDinheiro = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        MaxData = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorio\n");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatorio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Data inicial:");

        jLabel2.setText("Data final:");

        ButtonImprimir.setBackground(new java.awt.Color(0, 255, 0));
        ButtonImprimir.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ButtonImprimir.setText("Imprimir");
        ButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonImprimirActionPerformed(evt);
            }
        });

        ButtonPesquisar.setBackground(new java.awt.Color(0, 255, 0));
        ButtonPesquisar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ButtonPesquisar.setText("Pesquisar");
        ButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquisarActionPerformed(evt);
            }
        });

        tabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaPesquisa);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estatísticas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 13))); // NOI18N

        MaxCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaxCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(MaxCliente);

        jLabel7.setText("Compras > 2x:");

        tabelaModa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabelaModa);

        jLabel8.setText("Moda valor Total:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Maior venda:"));

        idCliente.setEditable(false);

        jLabel11.setText("ID venda:");

        jLabel12.setText("ID cliente:");

        jLabel13.setText("Valor venda:");

        jLabel14.setText("Data Venda:");

        dataV.setEditable(false);
        dataV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataVActionPerformed(evt);
            }
        });

        campoV.setEditable(false);

        campoIdVenda.setEditable(false);
        campoIdVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdVendaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1))
                    .addComponent(campoV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataV, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(campoIdVenda, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(dataV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setText("Qtd. Vendas:");

        campoQtd.setEditable(false);
        campoQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQtdActionPerformed(evt);
            }
        });

        jLabel3.setText("Total das Vendas:");

        CampoValorTotal.setEditable(false);
        CampoValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoValorTotalActionPerformed(evt);
            }
        });

        jLabel5.setText("Ticket Medio:");

        CampoMedia.setEditable(false);

        jLabel9.setText("Moda Pagamento:");

        campoModaPagamento.setEditable(false);
        campoModaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoModaPagamentoActionPerformed(evt);
            }
        });

        jLabel4.setText("R$:");

        buttonGrafico.setText("Grafico Pagamento");
        buttonGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraficoActionPerformed(evt);
            }
        });

        jLabel16.setText("Cartão Credito:");

        CampoCredito.setEditable(false);

        jLabel15.setText("CartãoDebito:");

        CampoDebito.setEditable(false);
        CampoDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDebitoActionPerformed(evt);
            }
        });

        jLabel17.setText("DInheiro:");

        CampoDinheiro.setEditable(false);

        jLabel18.setText("Dia Max.Vendido:");

        MaxData.setEditable(false);

        jButton2.setText("Grafico Valor Compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(3, 3, 3)
                                .addComponent(CampoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CampoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(CampoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(campoModaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel17)
                                .addGap(8, 8, 8)
                                .addComponent(CampoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addGap(4, 4, 4)
                                .addComponent(MaxData, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel10)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CampoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(25, 25, 25))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(CampoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(CampoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(CampoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(MaxData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoModaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(buttonGrafico)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(DataInIcial, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonPesquisar)
                                .addGap(19, 19, 19)
                                .addComponent(ButtonImprimir)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataInIcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonImprimir)
                    .addComponent(ButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(747, 747, 747))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(749, 826));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquisarActionPerformed
             
                  
        //tabela vendas
        preencherTabela("select * FROM tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        
        //moda sobre o total de cada venda
       modaValorVendido("Select (valor_venda) from tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"' group by valor_venda having count(*) > 1");
       
       //total vendido entre as datas
        conex.conexão();
        conex.execultaSql("select Sum(valor_venda) FROM tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            CampoValorTotal.setText(conex.rs.getString("Sum"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //ticket medio
        conex.conexão();
        conex.execultaSql("SELECT AVG (valor_venda) from tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            CampoMedia.setText(conex.rs.getString("avg"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //id cliente que mais comprou
       tabelamaxCliente("Select id_cliente from tbvenda WHERE data_venda "
                + "BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'group by id_cliente having count(*) > 2");
       
       //qtd venda
       conex.conexão();
        conex.execultaSql("SELECT COUNT(id_cliente) FROM tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            campoQtd.setText(conex.rs.getString("count"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //moda sobre a forma de pagamento
        conex.conexão();
        conex.execultaSql("SELECT mode() WITHIN GROUP (ORDER BY Forma_pagamento) AS modal_value FROM tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            campoModaPagamento.setText(conex.rs.getString("modal_value"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //qtd de vendas com Cartão credito
        conex.conexão();
        conex.execultaSql("SELECT COUNT(forma_pagamento) FROM tbvenda Where forma_pagamento = 'Cartão de Credito' And data_venda BETWEEN'"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            CampoCredito.setText(conex.rs.getString("count"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //qtd vendas com Cartão debito
        conex.conexão();
        conex.execultaSql("SELECT COUNT(forma_pagamento) FROM tbvenda Where forma_pagamento = 'Cartão de Debito' And data_venda BETWEEN'"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            CampoDebito.setText(conex.rs.getString("count"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        //qtd vendas com Cartão debito
        conex.conexão();
        conex.execultaSql("SELECT COUNT(forma_pagamento) FROM tbvenda Where forma_pagamento = 'Dinheiro' And data_venda BETWEEN'"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            CampoDinheiro.setText(conex.rs.getString("count"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        
        //data que teve mais venda
        conex.conexão();
        conex.execultaSql("SELECT mode() WITHIN GROUP (ORDER BY data_venda) AS modal_value FROM tbvenda WHERE data_venda BETWEEN'"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            MaxData.setText(conex.rs.getString("modal_value"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
        
        
    }//GEN-LAST:event_ButtonPesquisarActionPerformed

    private void ButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonImprimirActionPerformed
       
        //salva o arquivo com nome relatoriomesal na pasta temp do disco c:
        conex.conexão();
        conex.execultaSql("copy(select * FROM tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"') to 'C:\\temp\\relatorioMensal.csv' with csv header");
        try {
            java.awt.Desktop.getDesktop().open( new File( "C:\\temp\\relatorioMensal.csv" ) );
        } catch (IOException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
    }//GEN-LAST:event_ButtonImprimirActionPerformed

    private void CampoValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoValorTotalActionPerformed

    private void campoQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoQtdActionPerformed

    private void campoModaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoModaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoModaPagamentoActionPerformed

    private void campoIdVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdVendaActionPerformed

    private void dataVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //maior venda entre as datas
        conex.conexão();
        conex.execultaSql("select  max(valor_venda) from tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        try {
            conex.rs.first();
            campoV.setText(conex.rs.getString("max"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }conex.desconecta();

        conex.conexão();
        conex.execultaSql("select * from tbvenda where valor_venda = '"+campoV.getText()+"'");

        try {
            conex.rs.first();
            idCliente.setText(conex.rs.getString("id_cliente"));
            campoIdVenda.setText(conex.rs.getString("id_venda"));
            dataV.setText(conex.rs.getString("data_venda"));
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }conex.desconecta();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraficoActionPerformed
            //grafico de pagamentos em barras
        String CartãoCredito = CampoCredito.getText();
        String CartãoDebito = CampoDebito.getText();
        String Dinheiro = CampoDinheiro.getText();
        
     
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(new Double (CartãoCredito), "valores", "Cartão Credito");
        dataset.setValue(new Double(CartãoDebito), "valores", "Cartão Debito");
        dataset.setValue(new Double(Dinheiro), "valores", "Dinheiro");
       
        
        JFreeChart chart = ChartFactory.createBarChart3D("Relação de Pagamentos", "Formas Pagamento", "Quantidade", dataset,PlotOrientation.VERTICAL,false, true, false);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Grafico Formas de Pagamentos",chart);
        frame.setVisible(true);
        frame.setSize(450,350);
        
        
        
    }//GEN-LAST:event_buttonGraficoActionPerformed

    private void CampoDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDebitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDebitoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  conex.conexão();
  
        //conex.execultaSql("select data_venda,valor_venda from tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'");
        
        try {
        String query = "select data_venda,valor_venda from tbvenda WHERE data_venda BETWEEN '"+DataInIcial.getText()+"' AND '"+DataFinal.getText()+"'";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(
				"jdbc:postgresql://localhost:5432/db_RegistroVendas", "org.postgresql.Driver",
				"postgres", "postgres");
        dataset.executeQuery(query);
           String ticketM = CampoMedia.getText();
           
           
            JFreeChart chart = ChartFactory.createLineChart("Grafico de Vendas", "Data", "Valores R$", dataset, PlotOrientation.VERTICAL, false, true,true );
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            //marca o valor do ticket medio
             ValueMarker marker = new ValueMarker(new Double(ticketM));
            marker.setLabel("Ticket médio");
            marker.setLabelTextAnchor(TextAnchor.BASELINE_CENTER);
            marker.setPaint(Color.BLACK);
            CategoryPlot p = chart.getCategoryPlot();
            p.addRangeMarker(marker);
            
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Grafico Valores de Compras", chart);
            chart.setBackgroundPaint(Color.YELLOW);
            p.setRangeGridlinePaint(Color.BLUE);
            frame.setVisible(true);
            frame.setSize(800,450);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonImprimir;
    private javax.swing.JButton ButtonPesquisar;
    private javax.swing.JTextField CampoCredito;
    private javax.swing.JTextField CampoDebito;
    private javax.swing.JTextField CampoDinheiro;
    private javax.swing.JTextField CampoMedia;
    private javax.swing.JTextField CampoValorTotal;
    private javax.swing.JFormattedTextField DataFinal;
    private javax.swing.JFormattedTextField DataInIcial;
    private javax.swing.JTable MaxCliente;
    private javax.swing.JTextField MaxData;
    private javax.swing.JButton buttonGrafico;
    private javax.swing.JTextField campoIdVenda;
    private javax.swing.JTextField campoModaPagamento;
    private javax.swing.JTextField campoQtd;
    private javax.swing.JTextField campoV;
    private javax.swing.JTextField dataV;
    private javax.swing.JTextField idCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaModa;
    private javax.swing.JTable tabelaPesquisa;
    // End of variables declaration//GEN-END:variables
}
