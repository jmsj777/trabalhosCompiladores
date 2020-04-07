/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexAnalyser;
import File.Simbols;
import File.Tokens;
import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class LexAnaliser {
  String error = "";
  String code = "";
  int line = 1;
  int logicaMaior = 0;
  ArrayList<Tokens> token = new ArrayList();
  ArrayList<Simbols> tabelaSimbolos = new ArrayList();
  ArrayList<String> Reserved;
  ReservedWords words;

  public LexAnaliser(String codigo)
  {
    this.Reserved = this.words.getRdWords();
    this.code = codigo;
    getL();
  }

  public ArrayList<Tokens> getTokens() {
    return new ArrayList(this.token);
  }
  public String getError() {
    return this.error;
  }
  public ArrayList<Simbols> getSimbols() {
    return new ArrayList(this.tabelaSimbolos);
  }

  public void getL()
  {
    String[] lines = this.code.split("\n");
    for (int i = 0; i < lines.length; i++) {
      verify(lines[i] + " ");
      this.line += 1;
    }
  }

  public void verify(String texto) {
    String lexema = "";
    int estado = 0;

    for (int i = 0; i < texto.length(); i++) {
      char caracter = texto.charAt(i);
      if (estado == 0) {
        lexema = "";
        if (Character.isDigit(caracter)) {
          lexema = lexema + caracter;
          estado = 1;
        } else if (Character.isLetter(caracter)) {
          lexema = lexema + caracter;
          estado = 5;
        } else if (caracter == ':') {
          lexema = lexema + caracter;
          estado = 2;
        } else if (caracter == '"') {
          lexema = lexema + caracter;
          estado = 8;
        } else if (caracter == '(') {
          Tokens token = new Tokens("cLPar", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '[') {
          Tokens token = new Tokens("cLCha", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == ')') {
          Tokens token = new Tokens("cDPar", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == ']') {
          Tokens token = new Tokens("cRCha", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '*') {
          Tokens token = new Tokens("cMul", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '/') {
          Tokens token = new Tokens("cDiv", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '+') {
          Tokens token = new Tokens("cAdd", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if ((caracter == '-') || (caracter == '–')) {
          Tokens token = new Tokens("cSub", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '=') {
          Tokens token = new Tokens("cEQ", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if ((caracter == '>') || (caracter == '<')) {
          if (caracter == '>')
          {
            this.logicaMaior = 1;
          }
          else {
            this.logicaMaior = 2;
          }
          lexema = lexema + caracter;
          estado = 6;
        } else if (caracter == ';') {
          Tokens token = new Tokens("cPVir", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == ',') {
          Tokens token = new Tokens("cVir", Character.toString(caracter), this.line, i);
          this.token.add(token);
        } else if (caracter == '.') {
          Tokens token = new Tokens("cPto", Character.toString(caracter), this.line, i);
          this.token.add(token);
        }
      } else if (estado == 1) {
        if ((Character.isDigit(caracter)) && (!Character.isWhitespace(caracter))) {
          lexema = lexema + caracter;
        } else if (caracter == '.') {
          lexema = lexema + caracter;
          estado = 3;
        } else {
          Tokens token = new Tokens("cInt", lexema, this.line, i - lexema.length());
          this.token.add(token);
          i--;
          estado = 0;
        }
      } else if (estado == 2) {
        if (caracter == '=') {
          lexema = lexema + caracter;
          Tokens token = new Tokens("cAtr", lexema, this.line, i - lexema.length());
          this.token.add(token);
          estado = 0;
        } else {
          Tokens token = new Tokens("cDPto", lexema, this.line, i - lexema.length());
          this.token.add(token);
          i--;
          estado = 0;
        }
      } else if (estado == 3) {
        if (Character.isDigit(caracter)) {
          lexema = lexema + caracter;
          estado = 4;
        } else {
          adError(this.line);
          i--;
          estado = 0;
        }
      } else if (estado == 4) {
        if ((Character.isDigit(caracter)) && (!Character.isWhitespace(caracter))) {
          lexema = lexema + caracter;
        } else {
          adError(this.line);
          i--;
          estado = 0;
        }
      } else if (estado == 5) {
        if (((Character.isLetter(caracter)) || (Character.isDigit(caracter))) && (!Character.isWhitespace(caracter))) {
          lexema = lexema + caracter;
        } else {
          Simbols id = new Simbols(lexema.toLowerCase());
          int endereco = 0;
          if ((!this.tabelaSimbolos.contains(id)) && (!this.Reserved.contains(id.getlex().toLowerCase()))) {
            id.setlocat(this.tabelaSimbolos.size());
            endereco = this.tabelaSimbolos.size();
            this.tabelaSimbolos.add(id);
          } else if ((this.tabelaSimbolos.contains(id)) && (!this.Reserved.contains(id.getlex().toLowerCase()))) {
            endereco = this.tabelaSimbolos.indexOf(id);
          }
          if (this.Reserved.contains(lexema.toLowerCase())) {
            Tokens token = new Tokens("Palavra Reservada", lexema, this.line, i - lexema.length());
            this.token.add(token);
          } else {
            Tokens token = new Tokens("cId", lexema, this.line, i - lexema.length(), endereco);
            this.token.add(token);
          }
          i--;
          estado = 0;
        }
      } else if (estado == 6) {
        if (this.logicaMaior == 1) {
          if (caracter == '=') {
            lexema = lexema + caracter;
            Tokens token = new Tokens("cGE", lexema, this.line, i - lexema.length());
            this.token.add(token);
          } else {
            Tokens token = new Tokens("cGT", lexema, this.line, i - lexema.length());
            this.token.add(token);
            i--;
          }
          estado = 0;
        } else {
          if (caracter == '=') {
            lexema = lexema + caracter;
            Tokens token = new Tokens("cLE", lexema, this.line, i - lexema.length());
            this.token.add(token);
          } else if (caracter == '>') {
            lexema = lexema + caracter;
            Tokens token = new Tokens("cNE", lexema, this.line, i - lexema.length());
            this.token.add(token);
          } else {
            Tokens token = new Tokens("cLT", lexema, this.line, i - lexema.length());
            this.token.add(token);
            i--;
          }
          estado = 0;
        }
      } else if (estado == 7) {
        if (((Character.isLetter(caracter)) || (Character.isDigit(caracter))) && (!Character.isWhitespace(caracter))) {
          lexema = lexema + caracter;
          estado = 7;
        } else if (caracter == '"') {
          lexema = lexema + caracter;
          Tokens token = new Tokens("cStr", lexema, this.line, i - lexema.length());
          this.token.add(token);
          estado = 0;
        } else {
          lexema = lexema + '"';
          adError(this.line);
          Tokens token = new Tokens("cStr", lexema, this.line, i - lexema.length());
          this.token.add(token);
          i--;
          estado = 0;
        }
      }
    }
  }

  public void adError(int el) {
    if (!this.error.contains(String.valueOf(el)))
      this.error = (this.error + "Erro léxico na linha " + el + "!\n");
  }
}
