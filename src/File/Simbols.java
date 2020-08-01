/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;
import java.util.ArrayList;

/**
 *
 * @author rafha
 */
public class Simbols {
    private String lex;
    private String cat;    
    private int locat;
    private String type;        
    private ArrayList<Integer> lines;
    
    
    public Simbols(String lex) {
        this.lex = lex;
    }

    public Simbols() {
        throw new UnsupportedOperationException("Nope");
    }

    @Override//devido ao bug na geração da tabela de simbolos...
    public boolean equals(Object obj) {
        if (!(obj instanceof Simbols)) {
            return false;
        }
        final Simbols other = (Simbols) obj;
        return this.getlex().equals(other.getlex());
    }
    public String getcat() {
        return cat;
    }
    public void setcat(String cat) {
        this.cat = cat;
    }
    public String getlex() {
        return lex;
    }
    public String gettype() {
        return type;
    }
    public void setlocat(int locat) {
        this.locat = locat;
    }
    public void setlex(String lex) {
        this.lex = lex;
    }
    public void settype(String type) {
        this.type = type;
    }
    public int getlocat() {
        return locat;
    }    
}
