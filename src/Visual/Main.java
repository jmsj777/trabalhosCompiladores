/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Acoes.Acoes;
import Antlr4.TestPascal;
import Services.TextLineNumber;
import Processing.DataProcessor;
import Responses.RunResponse;
import File.File;
import File.FileControler;
import File.Simbols;
import File.Tokens;
import LexAnaliser.LexAnaliser;
import Model.SymbolTable;
import Parser.Parser;
import Services.Printer;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Rafhael
 */
public class Main extends javax.swing.JFrame {

    File file = null;
    FileControler Freader = new FileControler();
    DataProcessor Dprocessor = new DataProcessor();
    String ASSEMB;
    
    @Override
    public void setIconImage(Image image) {
        super.setIconImage(image); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form mai
     */
    public Main() {

        initComponents();
        
        TextLineNumber tln = new TextLineNumber(CodeArea);
        ScrollCode.setRowHeaderView( tln );
        CodeArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent arg0) {
            updateCollor();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JTabbedPane();
        ScrollCode = new javax.swing.JScrollPane();
        CodeArea = new javax.swing.JTextPane();
        jPanelLexicalItems = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        itens = new javax.swing.JTable();
        jPanelSymbolTable = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        simbolsT = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssembArea = new javax.swing.JTextArea();
        MessageField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MainBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemPrint = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemCut = new javax.swing.JMenuItem();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemPaste = new javax.swing.JMenuItem();
        jMenuItemClean = new javax.swing.JMenuItem();
        jMenuItemSelectAll = new javax.swing.JMenuItem();
        jMenuItemSearch = new javax.swing.JMenuItem();
        jMenuItemReplace = new javax.swing.JMenuItem();
        jMenuRun = new javax.swing.JMenu();
        jMenuItemRun = new javax.swing.JMenuItem();
        jMenuWindow = new javax.swing.JMenu();
        jMenuItemCascade = new javax.swing.JMenuItem();
        jMenuItemSideBySide = new javax.swing.JMenuItem();
        jMenuItemOrganizeAll = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemCredits = new javax.swing.JMenuItem();
        jMenuItemDocumentation = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiladores - Trabalho 02");
        setIconImage(new ImageIcon(
            System.getProperty("user.dir") +
            "/src/Images/icon.png"
        ).getImage());

        ScrollCode.setViewportView(CodeArea);

        Panel.addTab("Code", ScrollCode);

        itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Position", "Value", "Class"
            }
        ));
        jScrollPane4.setViewportView(itens);

        javax.swing.GroupLayout jPanelLexicalItemsLayout = new javax.swing.GroupLayout(jPanelLexicalItems);
        jPanelLexicalItems.setLayout(jPanelLexicalItemsLayout);
        jPanelLexicalItemsLayout.setHorizontalGroup(
            jPanelLexicalItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        jPanelLexicalItemsLayout.setVerticalGroup(
            jPanelLexicalItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        Panel.addTab("Lexical Items", jPanelLexicalItems);

        simbolsT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexeme", "Category", "Type", "Address"
            }
        ));
        jScrollPane5.setViewportView(simbolsT);

        javax.swing.GroupLayout jPanelSymbolTableLayout = new javax.swing.GroupLayout(jPanelSymbolTable);
        jPanelSymbolTable.setLayout(jPanelSymbolTableLayout);
        jPanelSymbolTableLayout.setHorizontalGroup(
            jPanelSymbolTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        jPanelSymbolTableLayout.setVerticalGroup(
            jPanelSymbolTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        Panel.addTab("Symbol Table", jPanelSymbolTable);

        AssembArea.setColumns(20);
        AssembArea.setRows(5);
        jScrollPane1.setViewportView(AssembArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        Panel.addTab("Assembly", jPanel1);

        MessageField.setEditable(false);

        jLabel1.setText("Message");

        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemNew.setText("New");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Save as");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);

        jMenuItemPrint.setText("Print");
        jMenuItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrintActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemPrint);

        jMenuItemClose.setText("Close");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemClose);

        MainBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemCut.setText("cut");
        jMenuItemCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCutActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemCut);

        jMenuItemCopy.setText("copy");
        jMenuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopyActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemCopy);

        jMenuItemPaste.setText("paste");
        jMenuItemPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPasteActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemPaste);

        jMenuItemClean.setText("clean");
        jMenuItemClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCleanActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemClean);

        jMenuItemSelectAll.setText("select all");
        jMenuItemSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSelectAllActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemSelectAll);

        jMenuItemSearch.setText("search");
        jMenuItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSearchActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemSearch);

        jMenuItemReplace.setText("replace");
        jMenuItemReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReplaceActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemReplace);

        MainBar.add(jMenuEdit);

        jMenuRun.setText("Run");

        jMenuItemRun.setText("Compile and Run");
        jMenuItemRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRunActionPerformed(evt);
            }
        });
        jMenuRun.add(jMenuItemRun);

        MainBar.add(jMenuRun);

        jMenuWindow.setText("Window");

        jMenuItemCascade.setText("Cascade");
        jMenuWindow.add(jMenuItemCascade);

        jMenuItemSideBySide.setText("Side by Side");
        jMenuWindow.add(jMenuItemSideBySide);

        jMenuItemOrganizeAll.setText("Orgazine all");
        jMenuItemOrganizeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOrganizeAllActionPerformed(evt);
            }
        });
        jMenuWindow.add(jMenuItemOrganizeAll);

        MainBar.add(jMenuWindow);

        jMenuHelp.setText("Help");

        jMenuItemCredits.setText("Credits");
        jMenuItemCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreditsActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemCredits);

        jMenuItemDocumentation.setText("Documentation");
        jMenuItemDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDocumentationActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemDocumentation);

        MainBar.add(jMenuHelp);

        setJMenuBar(MainBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MessageField, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        file = Freader.getFile(this);
        if (this.file != null)
            CodeArea.setText(file.getfText());
            updateCollor();
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        if (file == null) {
            file = Freader.newFile(this, CodeArea.getText());
        }
        try {
            Freader.saveFile(file, CodeArea.getText());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemCloseActionPerformed

    private void jMenuItemCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreditsActionPerformed
        new Credits().setVisible(true);
    }//GEN-LAST:event_jMenuItemCreditsActionPerformed

    private void jMenuItemRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRunActionPerformed
        if (!CodeArea.getText().isEmpty()) {
            if (file == null) {
                file = Freader.newInstaFile(this, CodeArea.getText());
            }
            try {
                Acoes acoes = TestPascal.rodaPrograma(CodeArea.getText());
                ASSEMB = acoes.getasmCode();
                SymbolTable st = acoes.getSymbolTable();
                AssembArea.setText(ASSEMB);
                RunResponse response = Dprocessor.runCode(file, CodeArea.getText());
                MessageField.setText("");
                LexAnaliser analis = new LexAnaliser(CodeArea.getText() + "\n");
                ArrayList<Tokens> tokenL = new ArrayList<>(analis.getTokens());
                ArrayList<Simbols> simbols = analis.getSimbols();
                DefaultTableModel lexicalItems = (DefaultTableModel) itens.getModel();
                DefaultTableModel simbolTables = (DefaultTableModel) simbolsT.getModel();
                MessageField.setText(analis.getError());
                lexicalItems.setRowCount(0);
                simbolTables.setRowCount(0);
                MessageField.setText("");
                for (int i = 0; i < tokenL.size(); i++) {
                    Object[] data = {tokenL.get(i).getline(), tokenL.get(i).getclasss(), tokenL.get(i).getLexema()};
                    lexicalItems.addRow(data);
                }

                Parser sintatic = new Parser(tokenL, simbols, analis.getError());
                MessageField.setText(sintatic.getEmsg());
                int countr = 0;
                for (int i = 0; i < sintatic.getSimbols().size(); i++) {
                    if (sintatic.getSimbols().get(i).getcat() == "Variável") {
                        Object[] data = {sintatic.getSimbols().get(i).getlex(), sintatic.getSimbols().get(i).getcat(), sintatic.getSimbols().get(i).gettype(), countr};//sintatic.getSimbols().get(i).getlocat()};
                        simbolTables.addRow(data);
                        countr++;
                    } else {
                        Object[] data = {sintatic.getSimbols().get(i).getlex(), sintatic.getSimbols().get(i).getcat(), sintatic.getSimbols().get(i).gettype(), " "};//sintatic.getSimbols().get(i).getlocat()};
                        simbolTables.addRow(data);

                    }
                }
                
                updateCollor();

                /*String[] numbers = this.file.getNumbers();
                for (int i = 0; i < numbers.length; i++) {
                    int index = markup.indexOf(numbers[i]);
                    System.out.println("number:" + numbers[i]);
                    while (index >= 0) {
                        System.out.println("interval of indexes: " + index + "  " + numbers[i].length());
                        sdoc.setCharacterAttributes(index, numbers[i].length(), fontNumbers, false);
                        index = markup.indexOf(numbers[i], index + 1);
                    }
                }*/
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemRunActionPerformed

    private void jMenuItemCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCutActionPerformed

    private void jMenuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCopyActionPerformed

    private void jMenuItemPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemPasteActionPerformed

    private void jMenuItemCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCleanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCleanActionPerformed

    private void jMenuItemSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSelectAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSelectAllActionPerformed

    private void jMenuItemSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSearchActionPerformed

    private void jMenuItemReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemReplaceActionPerformed

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        file = null;
        CodeArea.setText("");
    }//GEN-LAST:event_jMenuItemNewActionPerformed

    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
        file = Freader.newFile(this, CodeArea.getText());
        try {
            Freader.saveFile(file, CodeArea.getText());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed

    private void jMenuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrintActionPerformed
        
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new Printer(this.CodeArea), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_jMenuItemPrintActionPerformed

    private void jMenuItemOrganizeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOrganizeAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemOrganizeAllActionPerformed

    private void jMenuItemDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDocumentationActionPerformed
        new Documentation().setVisible(true);
    }//GEN-LAST:event_jMenuItemDocumentationActionPerformed
    private void updateCollor()
    {
        // comeco da parte de colorir palavras                
                String markup = this.CodeArea.getText();
                
                //atributos para fonte padrao!
                SimpleAttributeSet defaultFont = new SimpleAttributeSet();
                StyleConstants.setForeground(defaultFont, Color.blue);
                StyleConstants.setFontFamily(defaultFont, "Monospaced");
                StyleConstants.setFontSize(defaultFont, 16);

                //atributos para palavras
                SimpleAttributeSet fontWords = new SimpleAttributeSet();
                StyleConstants.setForeground(fontWords, Color.BLACK);
                StyleConstants.setBold(fontWords, true);

                // atributos para operadores
                SimpleAttributeSet fontOperators = new SimpleAttributeSet();
                StyleConstants.setForeground(fontOperators, Color.red);
                StyleConstants.setBold(fontOperators, true);

                // atributos para identificadores
                SimpleAttributeSet fontIdentifiers = new SimpleAttributeSet();
                StyleConstants.setForeground(fontIdentifiers, Color.red);

                // atributos para numeros
                SimpleAttributeSet fontNumbers = new SimpleAttributeSet();
                StyleConstants.setForeground(fontNumbers, Color.green);

                StyledDocument sdoc = this.CodeArea.getStyledDocument();

                sdoc.setCharacterAttributes(0, markup.length(), defaultFont, false);

                ArrayList<String> reservedWords = new ArrayList<>(Arrays.asList("program", "begin", "end", "var", "procedure", "function", "for", "repeat", "while", "do", "if", "then", "else", "or", "and", "not", "untill", "to"));
                reservedWords.forEach((word) -> {
                    int index = markup.indexOf(word);
                    while (index >= 0) {
                        char lim1, lim2;

                        try {
                            lim1 = markup.charAt(index - 1);
                        } catch (Exception e) {
                            lim1 = markup.charAt(index);
                        }

                        try {
                            lim2 = markup.charAt(index + word.length());
                        } catch (Exception e) {
                            lim2 = markup.charAt(index + word.length() - 1);
                        }

                        if ((lim1 == ' ' || lim1 == '\n' || lim1 == '\t') || (lim2 == ' ' || lim2 == '\n' || lim2 == '\t')) {
                            sdoc.setCharacterAttributes(index, word.length(), fontWords, false);
                        }
                        index = markup.indexOf(word, index + 1);
                    }
                });

                ArrayList<String> operators = new ArrayList<>(Arrays.asList(",", ";", ":", ":=", "<", ">", "<=", ">=", "<>", "\\", "*", "+", "-", "(", ")"));
                operators.forEach((item) -> {
                    int index = markup.indexOf(item);
                    while (index >= 0) {
                        sdoc.setCharacterAttributes(index, item.length(), fontOperators, false);
                        index = markup.indexOf(item, index + 1);
                    }
                });

                /*String[] numbers = this.file.getNumbers();
                for (int i = 0; i < numbers.length; i++) {
                    int index = markup.indexOf(numbers[i]);
                    System.out.println("number:" + numbers[i]);
                    while (index >= 0) {
                        System.out.println("interval of indexes: " + index + "  " + numbers[i].length());
                        sdoc.setCharacterAttributes(index, numbers[i].length(), fontNumbers, false);
                        index = markup.indexOf(numbers[i], index + 1);
                    }
                }*/
    }
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AssembArea;
    private javax.swing.JTextPane CodeArea;
    private javax.swing.JMenuBar MainBar;
    private javax.swing.JTextField MessageField;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JScrollPane ScrollCode;
    private javax.swing.JTable itens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemCascade;
    private javax.swing.JMenuItem jMenuItemClean;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemCopy;
    private javax.swing.JMenuItem jMenuItemCredits;
    private javax.swing.JMenuItem jMenuItemCut;
    private javax.swing.JMenuItem jMenuItemDocumentation;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemOrganizeAll;
    private javax.swing.JMenuItem jMenuItemPaste;
    private javax.swing.JMenuItem jMenuItemPrint;
    private javax.swing.JMenuItem jMenuItemReplace;
    private javax.swing.JMenuItem jMenuItemRun;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemSearch;
    private javax.swing.JMenuItem jMenuItemSelectAll;
    private javax.swing.JMenuItem jMenuItemSideBySide;
    private javax.swing.JMenu jMenuRun;
    private javax.swing.JMenu jMenuWindow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLexicalItems;
    private javax.swing.JPanel jPanelSymbolTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable simbolsT;
    // End of variables declaration//GEN-END:variables

}
