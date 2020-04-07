/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author lucas
 */
public class Credits extends javax.swing.JFrame {

    /**
     * Creates new form Credits
     */
    private JButton jButton1;
    private JInternalFrame jInternalFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    public Credits() {
        initComponents();
    }
    
    private void initComponents()
  {
    this.jInternalFrame1 = new JInternalFrame();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jButton1 = new JButton();

    this.jInternalFrame1.setVisible(true);

    GroupLayout jInternalFrame1Layout = new GroupLayout(this.jInternalFrame1.getContentPane());
    this.jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
    jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 0, 32767));

    jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 0, 32767));

    setDefaultCloseOperation(2);

    this.jLabel1.setBackground(new Color(0, 0, 0));
    this.jLabel1.setFont(new Font("Tahoma", 1, 18));
    this.jLabel1.setText("Trabalho 02 - Compiladores");

    this.jLabel2.setFont(new Font("Tahoma", 1, 14));
    this.jLabel2.setText("Integrantes do projeto:");

    this.jLabel3.setText("        Rafhael Menezes Braga");

    this.jLabel4.setText("        José Mário da Silva Júnior");

    this.jLabel5.setText("        Lucas Henrique de Melo");

    this.jButton1.setText("Voltar");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Credits.this.jButton1ActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout
      .createSequentialGroup()
      .addContainerGap()
      .addGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel1, -1, -1, 32767)
      .addGroup(layout
      .createSequentialGroup()
      .addGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel5, -2, 344, -2)
      .addGroup(layout
      .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
      .addComponent(this.jLabel2, -2, 344, -2)
      .addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
      .addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
      .addGap(0, 36, 32767))
      .addGroup(GroupLayout.Alignment.TRAILING, layout
      .createSequentialGroup()
      .addGap(0, 0, 32767)
      .addComponent(this.jButton1)))
      .addContainerGap()));

    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout
      .createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jLabel1, -2, 50, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel2, -2, 41, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel3, -2, 27, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel4, -2, 37, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel5, -2, 41, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
      .addComponent(this.jButton1)
      .addContainerGap()));

    pack();
  }
    
   private void jButton1ActionPerformed(ActionEvent evt) {
    dispose();
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
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
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try
    {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
    }
    catch (ClassNotFoundException ex) {
      Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
