/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

/**
 *
 * @author lucas
 */
public class Tokens {
  private int colunm;
  private String classs;
  private String lexema = null;
  private int line;
  private int locat;

  public Tokens(String classs, String lexema, int line, int colunm)
  {
    this.colunm = colunm;
    this.line = line;
    this.classs = classs;
    this.lexema = lexema;
  }

  public void setlocat(int locat) {
    this.locat = locat;
  }

  public Tokens(String classs, String lexema, int line, int colunm, int locat) {
    this.classs = classs;
    this.lexema = lexema;
    this.line = line;
    this.locat = locat;
  }
  public String getLexema() {
    return this.lexema;
  }
  public String getclasss() {
    return this.classs;
  }
  public int getline() {
    return this.line;
  }
  public int getcolunm() {
    return this.colunm;
  }
  public int getlocat() {
    return this.locat;
  }
}
