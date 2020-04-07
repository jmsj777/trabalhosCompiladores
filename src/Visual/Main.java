/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import File.File;
import File.FileControler;
import Processing.DataProcessor;
import Responses.RunResponse;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 *
 * @author lucas
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    File file = null;
  FileControler Freader = new FileControler();
  DataProcessor Dprocessor = new DataProcessor();
  private JTextArea AIndexArea;
  private JTextArea CodeArea;
  private JTabbedPane Panel;
  private JScrollPane Scroll;
  private JTextArea StatisticArea;
  private JLabel jLabel1;
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenu jMenu3;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem2;
  private JMenuItem jMenuItem3;
  private JMenuItem jMenuItem4;
  private JMenuItem jMenuItem5;
  private JMenuItem jMenuItem6;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JScrollPane jScrollPane3;
  private JScrollPane jScrollPane5;
  private JTextArea jTextArea1;
  private JTextPane textPaneTeste;
  
  public void setIconImage(Image image)
  {
    super.setIconImage(image);
  }

    public Main() {
        initComponents();
    }
    
    private void initComponents()
  {
    this.Panel = new JTabbedPane();
    this.Scroll = new JScrollPane();
    this.CodeArea = new JTextArea();
    this.jPanel1 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.StatisticArea = new JTextArea();
    this.jPanel2 = new JPanel();
    this.jScrollPane2 = new JScrollPane();
    this.AIndexArea = new JTextArea();
    this.jScrollPane5 = new JScrollPane();
    this.textPaneTeste = new JTextPane();
    this.jPanel3 = new JPanel();
    this.jScrollPane3 = new JScrollPane();
    this.jTextArea1 = new JTextArea();
    this.jLabel1 = new JLabel();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenuItem1 = new JMenuItem();
    this.jMenuItem2 = new JMenuItem();
    this.jMenuItem3 = new JMenuItem();
    this.jMenuItem6 = new JMenuItem();
    this.jMenu3 = new JMenu();
    this.jMenuItem5 = new JMenuItem();
    this.jMenu2 = new JMenu();
    this.jMenuItem4 = new JMenuItem();

    setDefaultCloseOperation(3);
    setTitle("Compiladores - Trabalho 02");

    this.CodeArea.setColumns(20);
    this.CodeArea.setRows(5);
    this.CodeArea.addCaretListener(new CaretListener() {
      public void caretUpdate(CaretEvent evt) {
        Main.this.CodeAreaCaretUpdate(evt);
      }
    });
    this.Scroll.setViewportView(this.CodeArea);

    this.Panel.addTab("Code", this.Scroll);

    this.StatisticArea.setEditable(false);
    this.StatisticArea.setColumns(20);
    this.StatisticArea.setRows(5);
    this.jScrollPane1.setViewportView(this.StatisticArea);

    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jScrollPane1, -1, 591, 32767));

    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jScrollPane1, -1, 373, 32767));

    this.Panel.addTab("Lexical Items", this.jPanel1);

    this.AIndexArea.setEditable(false);
    this.AIndexArea.setColumns(20);
    this.AIndexArea.setRows(5);
    this.jScrollPane2.setViewportView(this.AIndexArea);

    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jScrollPane2, -1, 591, 32767));

    jPanel2Layout.setVerticalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jScrollPane2, -1, 373, 32767));

    this.Panel.addTab("Symbol Table", this.jPanel2);

    this.jScrollPane5.setViewportView(this.textPaneTeste);

    this.Panel.addTab("code2", this.jScrollPane5);

    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 591, 32767));

    jPanel3Layout.setVerticalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 372, 32767));

    this.Panel.addTab("Object Code", this.jPanel3);

    this.jTextArea1.setEditable(false);
    this.jTextArea1.setColumns(20);
    this.jTextArea1.setRows(5);
    this.jScrollPane3.setViewportView(this.jTextArea1);

    this.jLabel1.setText("Messages");

    this.jMenu1.setText("File");

    this.jMenuItem1.setText("Open");
    this.jMenuItem1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem1ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem1);

    this.jMenuItem2.setText("Save");
    this.jMenuItem2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem2ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem2);

    this.jMenuItem3.setText("Close");
    this.jMenuItem3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem3ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem3);

    this.jMenuItem6.setText("Test");
    this.jMenuItem6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem6ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem6);

    this.jMenuBar1.add(this.jMenu1);

    this.jMenu3.setText("Run");

    this.jMenuItem5.setText("Run");
    this.jMenuItem5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem5ActionPerformed(evt);
      }
    });
    this.jMenu3.add(this.jMenuItem5);

    this.jMenuBar1.add(this.jMenu3);

    this.jMenu2.setText("Help");

    this.jMenuItem4.setText("About us");
    this.jMenuItem4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Main.this.jMenuItem4ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem4);

    this.jMenuBar1.add(this.jMenu2);

    setJMenuBar(this.jMenuBar1);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout
      .createSequentialGroup()
      .addContainerGap()
      .addGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jScrollPane3)
      .addGroup(layout
      .createSequentialGroup()
      .addComponent(this.jLabel1)
      .addGap(0, 0, 32767)))
      .addContainerGap())
      .addComponent(this.Panel));

    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout
      .createSequentialGroup()
      .addComponent(this.Panel, -2, 400, -2)
      .addGap(17, 17, 17)
      .addComponent(this.jLabel1)
      .addGap(2, 2, 2)
      .addComponent(this.jScrollPane3, -2, 150, -2)
      .addContainerGap(-1, 32767)));

    pack();
  }
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
    this.file = this.Freader.getFile(this);
    if (this.file != null)
      this.CodeArea.setText(this.file.getFileText());
  }

  private void jMenuItem2ActionPerformed(ActionEvent evt)
  {
    if (this.file != null)
      try {
        this.Freader.saveFile(this.file, this.CodeArea.getText());
      } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private void jMenuItem3ActionPerformed(ActionEvent evt)
  {
    this.file = null;
    this.CodeArea.setText("");
  }

  private void jMenuItem4ActionPerformed(ActionEvent evt) {
    new Credits().setVisible(true);
  }

  private void colorWords() {
    String markup = this.CodeArea.getText();
    this.textPaneTeste.setText(markup);
    SimpleAttributeSet defaultFont = new SimpleAttributeSet();
    SimpleAttributeSet fontWords = new SimpleAttributeSet();

    StyleConstants.setForeground(defaultFont, Color.blue);
    StyleConstants.setFontFamily(defaultFont, "Monospaced");
    StyleConstants.setFontSize(defaultFont, 16);

    StyleConstants.setForeground(fontWords, Color.black);

    StyledDocument sdoc = this.textPaneTeste.getStyledDocument();

    sdoc.setCharacterAttributes(0, markup.length(), defaultFont, false);

    String[] words = this.file.getWords();
    for (int i = 0; i < words.length; i++) {
      int index = markup.indexOf(words[i]);
      while (index >= 0) {
        System.out.println(index);
        sdoc.setCharacterAttributes(index, words[i].length(), fontWords, false);
        index = markup.indexOf(words[i], index + 1);
      }
    }
  }

  private void jMenuItem5ActionPerformed(ActionEvent evt) {
    if (this.file != null) {
      try {
        RunResponse response = this.Dprocessor.runCode(this.file, this.CodeArea.getText());

        colorWords();
      } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else
      JOptionPane.showMessageDialog(null, "No file opened. Try to open a file first!", "No File Opened", 0);
  }

  private void jMenuItem6ActionPerformed(ActionEvent evt)
  {
    String markup = "program Fatorial;\nvar\n   N, F: integer;\nfunction Fat(N : integer) : integer;\nbegin\n   if (N = 0) or (N = 1) then\n       begin\n           Fat := 1;\n       end\n   else\n       begin\n           Fat := N * Fat(N – 1);\n       end;\nend;\n\nbegin\n   N := 0;\n   read( N );\n   if N >= 0 then begin\n       F := Fat(N);\n   end;\n   write( F );\nend.\n";

    this.textPaneTeste.setText(markup);

    SimpleAttributeSet fontePadrao = new SimpleAttributeSet();
    SimpleAttributeSet fontePreta = new SimpleAttributeSet();
    SimpleAttributeSet fonteVermelha = new SimpleAttributeSet();
    SimpleAttributeSet negritoAttrs = new SimpleAttributeSet();

    StyleConstants.setForeground(fontePadrao, Color.blue);
    StyleConstants.setFontFamily(fontePadrao, "Monospaced");
    StyleConstants.setFontSize(fontePadrao, 16);

    StyleConstants.setForeground(fontePreta, Color.black);
    StyleConstants.setForeground(fonteVermelha, Color.red);

    StyleConstants.setBold(negritoAttrs, true);

    StyledDocument sdoc = this.textPaneTeste.getStyledDocument();

    sdoc.setCharacterAttributes(0, markup.length(), fontePadrao, false);

    String palavra = ";";
    int index = markup.indexOf(palavra);
    while (index >= 0) {
      System.out.println(index);
      sdoc.setCharacterAttributes(index, palavra.length(), fonteVermelha, false);
      index = markup.indexOf(palavra, index + 1);
    }
    palavra = "begin";
    index = markup.indexOf(palavra);
    while (index >= 0) {
      sdoc.setCharacterAttributes(index, palavra.length(), fontePreta, false);
      index = markup.indexOf(palavra, index + 1);
    }
  }

  private void CodeAreaCaretUpdate(CaretEvent evt)
  {
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
