/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller_Cadastro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author rgara
 */
public class Cadastro_window extends javax.swing.JFrame {

    /**
     * Creates new form novo_usuario_window
     */
    public Cadastro_window() {
        initComponents();
        controller = new Controller_Cadastro(this);
    }

    public Controller_Cadastro getController() {
        return controller;
    }

    public void setController(Controller_Cadastro controller) {
        this.controller = controller;
    }

    public JButton getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public JTextField getInsert_senha_novo_usuario() {
        return insert_senha_novo_usuario;
    }

    public void setInsert_senha_novo_usuario(JTextField inserrt_senha_novo_usuario) {
        this.insert_senha_novo_usuario = inserrt_senha_novo_usuario;
    }

    public JTextField getInsert_cpf_novo_usuario() {
        return insert_cpf_novo_usuario;
    }

    public void setInsert_cpf_novo_usuario(JTextField insert_cpf_novo_usuario) {
        this.insert_cpf_novo_usuario = insert_cpf_novo_usuario;
    }

    public JTextField getInsert_nome_novo_usuario() {
        return insert_nome_novo_usuario;
    }

    public void setInsert_nome_novo_usuario(JTextField insert_nome_novo_usuario) {
        this.insert_nome_novo_usuario = insert_nome_novo_usuario;
    }

    public JLabel getLblCPF() {
        return lblCPF;
    }

    public void setLblCPF(JLabel lblCPF) {
        this.lblCPF = lblCPF;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public void setLblNome(JLabel lblNome) {
        this.lblNome = lblNome;
    }

    public JLabel getLblNovoUsuario() {
        return lblNovoUsuario;
    }

    public void setLblNovoUsuario(JLabel lblNovoUsuario) {
        this.lblNovoUsuario = lblNovoUsuario;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public void setLblSenha(JLabel lblSenha) {
        this.lblSenha = lblSenha;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNovoUsuario = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        insert_cpf_novo_usuario = new javax.swing.JTextField();
        insert_nome_novo_usuario = new javax.swing.JTextField();
        insert_senha_novo_usuario = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        lblSenhaa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNovoUsuario.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblNovoUsuario.setText("Insira as informações para criar um novo usuário");

        lblNome.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        lblNome.setText("Nome:");

        lblCPF.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        lblCPF.setText("CPF:");

        lblSenha.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        lblSenha.setText("Senha:");

        insert_senha_novo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_senha_novo_usuarioActionPerformed(evt);
            }
        });

        btCadastrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lblSenhaa.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblSenhaa.setText("6 dígitos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblNovoUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenhaa)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSenha)
                                    .addComponent(lblNome)
                                    .addComponent(lblCPF))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(insert_nome_novo_usuario)
                                            .addComponent(insert_cpf_novo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(insert_senha_novo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblNovoUsuario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(insert_nome_novo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(insert_cpf_novo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(insert_senha_novo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenhaa)
                .addGap(4, 4, 4)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        controller.salvarInvestidor();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void insert_senha_novo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_senha_novo_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insert_senha_novo_usuarioActionPerformed

    
    private Controller_Cadastro controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JTextField insert_cpf_novo_usuario;
    private javax.swing.JTextField insert_nome_novo_usuario;
    private javax.swing.JTextField insert_senha_novo_usuario;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNovoUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaa;
    // End of variables declaration//GEN-END:variables
}
