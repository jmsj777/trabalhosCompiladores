/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;


/**
 *
 * @author Rafhael
 */
public class File {
    
    private String fText;
    private String fName;
    private String fPath;
    private int chars;
    private int charNoSpaces;
    private int lines;
    String AIndex;
    String Words[];
    String Identifiers[];
    String Numbers[];
    String Operators[];
    
    public String getAIndex() {
        return AIndex;
    }

    public void setAIndex(String AIndex) {
        this.AIndex = AIndex;
    }
    
    public String[] getIdentifiers() {
        return Identifiers;
    }

    public void setIdentifiers(String[] Identifiers) {
        this.Identifiers = Identifiers;
    }

    public String[] getNumbers() {
        return Numbers;
    }

    public void setNumbers(String[] Numbers) {
        this.Numbers = Numbers;
    }

    public String[] getOperators() {
        return Operators;
    }

    public void setOperators(String[] Operators) {
        this.Operators = Operators;
    }

    public int getChars() {
        return chars;
    }

    public String[] getWords() {
        return Words;
    }

    public void setWords(String[] Words) {
        this.Words = Words;
    }

    public void setChars(int chars) {
        this.chars = chars;
    }

    public int getCharNoSpaces() {
        return charNoSpaces;
    }

    public void setCharNoSpaces(int charNoSpaces) {
        this.charNoSpaces = charNoSpaces;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public String getFilePath() {
        return fPath;
    }

    public void setFilePath(String filePath) {
        this.fPath = filePath;
    }

    public File(String fileTxt, String fileName, String path)
    {
        this.fText = fileTxt;
        this.fName = fileName;
        this.fPath = path;
    }

    public void setfText(String fText) {
        this.fText = fText;
    }
    public String getfText() {
        return fText;
    }

    public String getFileName() {
        return fName;
    }
}
