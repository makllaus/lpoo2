package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.ConnectionBD;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    ConnectionBD connecta = new ConnectionBD();

    public TelaLogin() {
        initComponents();
        connecta.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAcessar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jLabelBackgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonAcessar.setText("Acessar");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(280, 170, 100, 29);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(380, 170, 90, 29);

        jLabel1.setText("Usuário: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 90, 70, 17);

        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 130, 60, 17);
        getContentPane().add(txtUser);
        txtUser.setBounds(280, 90, 190, 27);
        getContentPane().add(txtPass);
        txtPass.setBounds(280, 130, 190, 27);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heart-beat-2-icon.png"))); // NOI18N
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(10, 30, 290, 170);

        jLabelBackgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(jLabelBackgroundLogin);
        jLabelBackgroundLogin.setBounds(0, 0, 500, 230);

        setSize(new java.awt.Dimension(509, 257));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
        try {
            connecta.executeSql("select * from usuarios where user_name='" + txtUser.getText() + "'");
            connecta.rs.first();
            if (connecta.rs.getString("pass").equals(txtPass.getText())) {
                TelaPrincipal tela = new TelaPrincipal(txtUser.getText());
                tela.setVisible(true);
                tela.setResizable(false);
                connecta.desconnect();
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Senha ou usuário inválido.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Senha ou usuário inválido.");
            
        }
       
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        connecta.desconnect();
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBackgroundLogin;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
