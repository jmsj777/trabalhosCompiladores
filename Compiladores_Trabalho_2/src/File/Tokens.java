/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

/**
 *
 * @author rafha
 */
public class Tokens {
    
    private int colunm;
    private String classs;
    private String lexema = null;
    private int line;
    public Tokens(String classs, String lexema, int line, int colunm) {
        this.colunm = colunm;
        this.line = line;
        this.classs = classs;
        this.lexema = lexema;
    }

    public void setlocat(int locat) {
        this.locat = locat;
    }
    private int locat;
    public Tokens(String classs, String lexema, int line, int colunm, int locat) {
        this.classs = classs;
        this.lexema = lexema;
        this.line = line;
        this.locat = locat;
    }
    public String getLexema() {
        return lexema;
    }
    public String getclasss() {
        return classs;
    }
    public int getline() {
        return line;
    }
    public int getcolunm() {
        return colunm;
    }
    public int getlocat() {
        return locat;
    }
        
}