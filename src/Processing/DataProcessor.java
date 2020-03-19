/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processing;

import Responses.RunResponse;
import File.File;
import File.FileControler;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafhael
 */
public class DataProcessor {
    FileControler control = new FileControler();
    public RunResponse runCode(File file, String code) throws IOException
    {
        file.setFileText(code);
        control.saveFile(file, code);
        RunResponse response = new RunResponse();
        file.setChars(control.countCharacters(file));
        file.setCharNoSpaces(control.countCharNoSpaces(file));
        file.setWords(control.countWords(file));
        file.setNumbers(control.countNumbers(file)); 
        file.setOperators(control.countOperators(file));
        file.setLines(control.countLines(file));        
        file.setIdentifiers(control.countIdentifiers(file));
        file.setAIndex(control.AIndexOrganizer(file));
        
        //Estatisticas
        JOptionPane.showMessageDialog(null,"File saved. Runing Code!","Runing...",1);  
        response.setStatistics("Quantidade de caracteres (incluindo espaço): "+file.getChars()+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de caracteres (sem considerar o espaço): "+file.getCharNoSpaces()+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de palavras: "+file.getWords().length+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de identificadores: "+file.getIdentifiers().length+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de números (inteiros e reais): "+file.getNumbers().length+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de operadores (relacionais e aritméticos): "+file.getOperators().length+"\n");
        response.setStatistics(response.getStatistics()+"Quantidade de linhas: "+file.getLines()+"\n");
        
        //A Index
        response.setAIndex(file.getAIndex());
        return response;
    }
}
