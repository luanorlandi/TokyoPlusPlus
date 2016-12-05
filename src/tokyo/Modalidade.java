/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokyo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orlandi
 */
public class Modalidade extends javax.swing.JFrame {

    JTable tableEsporte = new javax.swing.JTable();
    JTable tableModalidade = new javax.swing.JTable();
    
    /**
     * Creates new form Modalidade
     */
    public Modalidade() {
        initComponents();
        this.setTitle("Tokyo++ - Modalidade");
        this.setIconImage(new ImageIcon(getClass().getResource("/img/japan.png")).getImage()); 
        this.setLocationRelativeTo(null);
        
        loadEsporte();
    }
    
    private void loadEsporte() {
        paneEsporte.setViewportView(tableEsporte);
        tableEsporte.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome do Esporte", "Unidade"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false
            };
        });
        
        try {
            ResultSet resultSet = DatabaseConnection
                    .getInstance()
                    .select(scriptEsporte());
                    
            DefaultTableModel model = (DefaultTableModel) tableEsporte.getModel();
            
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("nomeEsporte"),
                    resultSet.getString("unidade")});
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void loadModalidade() {
        paneModalidade.setViewportView(tableModalidade);
        tableModalidade.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome da Modalidade",
                    "Nº máx. de Atletas",
                    "Categoria",
                    "Nome do Esporte"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
        });
        
        try {
            ResultSet resultSet = DatabaseConnection
                    .getInstance()
                    .select(scriptModalidadeListar());
                    
            DefaultTableModel model = (DefaultTableModel) tableModalidade.getModel();
            
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("nomeModalidade"),
                    resultSet.getString("numeroMaximoAtletas"),
                    resultSet.getString("categoria"),
                    resultSet.getString("nomeEsporte")});
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private String scriptEsporte() {
        return
                "select * "
                + "from esporte";
    }
    
    private String scriptModalidadeListar() {
        return
                "select * "
                + "from modalidade";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonListar = new javax.swing.JButton();
        buttonRemover = new javax.swing.JButton();
        buttonInserir = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();
        paneModalidade = new javax.swing.JScrollPane();
        labelNome = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        labelNumMax = new javax.swing.JLabel();
        textFieldCategoria = new javax.swing.JTextField();
        labelCategoria = new javax.swing.JLabel();
        labelEsporte = new javax.swing.JLabel();
        textFieldMax = new javax.swing.JTextField();
        paneEsporte = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonListar.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 18)); // NOI18N
        buttonListar.setText("Listar");
        buttonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarActionPerformed(evt);
            }
        });

        buttonRemover.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 18)); // NOI18N
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        buttonInserir.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 18)); // NOI18N
        buttonInserir.setText("Inserir");
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        buttonAtualizar.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 18)); // NOI18N
        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        labelNome.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        labelNome.setText("Nome da modalidade:");

        textFieldNome.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        textFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomeActionPerformed(evt);
            }
        });

        labelNumMax.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        labelNumMax.setText("Número máximo de atletas:");

        textFieldCategoria.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        textFieldCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCategoriaActionPerformed(evt);
            }
        });

        labelCategoria.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        labelCategoria.setText("Categoria:");

        labelEsporte.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        labelEsporte.setText("Esporte:");

        textFieldMax.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        textFieldMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMaxActionPerformed(evt);
            }
        });

        paneEsporte.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNome)
                            .addComponent(textFieldCategoria)
                            .addComponent(textFieldMax)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNome)
                                    .addComponent(labelEsporte)
                                    .addComponent(labelCategoria)
                                    .addComponent(labelNumMax))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(paneEsporte)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNumMax)
                        .addGap(11, 11, 11)
                        .addComponent(textFieldMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelEsporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneEsporte, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addComponent(paneModalidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonListar)
                    .addComponent(buttonRemover)
                    .addComponent(buttonInserir)
                    .addComponent(buttonAtualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarActionPerformed
        loadModalidade();
    }//GEN-LAST:event_buttonListarActionPerformed

    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        System.err.println("selected row: " + tableEsporte.getSelectedRow());
    }//GEN-LAST:event_buttonInserirActionPerformed

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void textFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNomeActionPerformed

    private void textFieldCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCategoriaActionPerformed

    private void textFieldMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldMaxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonListar;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelEsporte;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumMax;
    private javax.swing.JScrollPane paneEsporte;
    private javax.swing.JScrollPane paneModalidade;
    private javax.swing.JTextField textFieldCategoria;
    private javax.swing.JTextField textFieldMax;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
