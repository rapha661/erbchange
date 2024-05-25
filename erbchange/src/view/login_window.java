/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller_login;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

/**
 *
 * @author rgara
 */
public class login_window extends javax.swing.JFrame {

    /**
     * Creates new form login_window
     */
    public login_window() {
        initComponents();
        this.controller = new Controller_login(this);
    }

    public JTextField getInsert_senha_login() {
        return insert_senha_login;
    }

    public void setInsert_senha_login(JTextField insert_senha_login) {
        this.insert_senha_login = insert_senha_login;
    }

    public JTextField getInsert_cpf_login() {
        return insert_cpf_login;
    }

    public void setInsert_cpf_login(JTextField insert_usuario_login) {
        this.insert_cpf_login = insert_usuario_login;
    }

    public JButton getjButton1() {
        return btEntrar;
    }

    public void setjButton1(JButton jButton1) {
        this.btEntrar = jButton1;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JLabel getLblLogin() {
        return lblLogin;
    }

    public void setLblLogin(JLabel lblLogin) {
        this.lblLogin = lblLogin;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public void setLblSenha(JLabel lblSenha) {
        this.lblSenha = lblSenha;
    }

    public JLabel getLblUsuario() {
        return lblCpf;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        this.lblCpf = lblUsuario;
    }

    public JMenu getMenuCriarUsuario() {
        return menuCriarUsuario;
    }

    public void setMenuCriarUsuario(JMenu menuCriarUsuario) {
        this.menuCriarUsuario = menuCriarUsuario;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        insert_cpf_login = new javax.swing.JTextField();
        insert_senha_login = new javax.swing.JTextField();
        btEntrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCriarUsuario = new javax.swing.JMenu();
        MenuItemCriar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblLogin.setText("Bem vindo ao Erbchange");

        lblCpf.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCpf.setText("CPF:");

        lblSenha.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblSenha.setText("Senha:");

        insert_cpf_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_cpf_loginActionPerformed(evt);
            }
        });

        btEntrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        menuCriarUsuario.setText("Criar novo usuário");
        menuCriarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCriarUsuarioActionPerformed(evt);
            }
        });

        MenuItemCriar.setText("Criar");
        MenuItemCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCriarActionPerformed(evt);
            }
        });
        menuCriarUsuario.add(MenuItemCriar);

        jMenuBar1.add(menuCriarUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addComponent(lblSenha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insert_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insert_cpf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 184, Short.MAX_VALUE)
                .addComponent(btEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(insert_cpf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(insert_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btEntrar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCriarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCriarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCriarUsuarioActionPerformed

    private void insert_cpf_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_cpf_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insert_cpf_loginActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        controller.Login_investidor();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void MenuItemCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCriarActionPerformed
        // TODO add your handling code here:
        Cadastro_window cw = new Cadastro_window();
        cw.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuItemCriarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(login_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(login_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(login_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(login_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new login_window().setVisible(true);
//            }
//        });
//    }
    
    private Controller_login controller; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemCriar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JTextField insert_cpf_login;
    private javax.swing.JTextField insert_senha_login;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JMenu menuCriarUsuario;
    // End of variables declaration//GEN-END:variables

}