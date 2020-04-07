/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processing;
import File.File;
import File.FileControler;
import Responses.RunResponse;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class DataProcessor {
    FileControler control = new FileControler();

  public RunResponse runCode(File file, String code) throws IOException {
    file.setFileText(code);
    this.control.saveFile(file, code);
    RunResponse response = new RunResponse();
    file.setChars(this.control.countCharacters(file));
    file.setCharNoSpaces(this.control.countCharNoSpaces(file));
    file.setWords(this.control.countWords(file));
    file.setNumbers(this.control.countNumbers(file));
    file.setOperators(this.control.countOperators(file));
    file.setLines(this.control.countLines(file));
    file.setIdentifiers(this.control.countIdentifiers(file));
    file.setAIndex(this.control.AIndexOrganizer(file));

    JOptionPane.showMessageDialog(null, "File saved. Runing Code!", "Runing...", 1);
    response.setStatistics("Quantidade de caracteres (incluindo espaço): " + file.getChars() + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de caracteres (sem considerar o espaço): " + file.getCharNoSpaces() + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de palavras: " + file.getWords().length + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de identificadores: " + file.getIdentifiers().length + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de números (inteiros e reais): " + file.getNumbers().length + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de operadores (relacionais e aritméticos): " + file.getOperators().length + "\n");
    response.setStatistics(response.getStatistics() + "Quantidade de linhas: " + file.getLines() + "\n");

    response.setAIndex(file.getAIndex());
    return response;
  }
}
