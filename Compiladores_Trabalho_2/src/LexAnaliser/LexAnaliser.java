/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexAnaliser;

import File.Simbols;
import File.Tokens;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafha
 */

public class LexAnaliser {
    String error = "";
    String code = "";
    int line = 1;
    int bigLogic = 0;
    ArrayList<Tokens> tokens = new ArrayList<>();
    ArrayList<Simbols> symbolTable = new ArrayList<>();
    ArrayList<String> Reserv = new ArrayList<>(Arrays.asList("begin", "and",  "div", "case", "const", "else", "end", "file", "for", "function", "do", "downto","goto",  "label", "mod","if", "in", "nil", "not", "of", "or", "packed", "procedure","program", "record", "repeat", "set", "then", "to", "type", "until", "var", "while", "with" ,"write", "read" , "integer"));
        
    public LexAnaliser(String code) {
        this.code=code;
        getL();
    }
    
    public ArrayList<Tokens> getTokens() {
        return new ArrayList<Tokens>(tokens);
    }
    public String getError() {
        return this.error;
    }
    public ArrayList<Simbols> getSimbols() {
        return new ArrayList<Simbols>(symbolTable);
    }
    
    public void getL()
    {
        String[] lines = this.code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            this.verify(lines[i] + " ");
            this.line++;
        }
    }
    public void verify(String text) {

        String lexema = "";
        int status = 0;
        char character;
        for (int i = 0; i < text.length(); i++) {
            character = text.charAt(i);
            if(status ==0) {
                lexema = "";
                if ((Character.isDigit(character))) { 
                    lexema += character;
                    status = 1;
                } else if ((Character.isLetter(character))) { 
                    lexema += character;
                    status = 5;
                } else if (character == ':') {
                    lexema += character;
                    status = 2;
                } else if (character == '"') { 
                    lexema += character;
                    status = 8;                
                } else if (character == '(') {
                    Tokens tokens = new Tokens("cLPar", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '[') {
                    Tokens tokens = new Tokens("cLCha", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == ')') {
                    Tokens tokens = new Tokens("cDPar", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);                    
                } else if (character == ']') {
                    Tokens tokens = new Tokens("cRCha", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '*') {
                    Tokens tokens = new Tokens("cMul", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '/') {
                    Tokens tokens = new Tokens("cDiv", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '+') {
                    Tokens tokens = new Tokens("cAdd", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '-' || character == '–') {
                    Tokens tokens = new Tokens("cSub", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '=') {
                    Tokens tokens = new Tokens("cEQ", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if ((character == '>') || (character == '<')) {
                    if((character == '>'))
                    {
                        bigLogic = 1;
                    }
                    else{
                        bigLogic = 2;                                    
                    }
                    lexema += character;
                    status = 6;
                } else if (character == ';') {
                    Tokens tokens = new Tokens("cPVir", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == ',') {
                    Tokens tokens = new Tokens("cVir", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                } else if (character == '.') {
                    Tokens tokens = new Tokens("cPto", Character.toString(character), this.line, i);
                    this.tokens.add(tokens);
                }
            }else if(status== 1) {
                if ((Character.isDigit(character)) && !Character.isWhitespace(character)) {
                    lexema += character;
                } else if (character == '.') {
                    lexema += character;
                    status = 3;
                } else {
                    Tokens tokens = new Tokens("cInt", lexema, this.line, i - lexema.length());
                    this.tokens.add(tokens);
                    i--;
                    status = 0;
                }
            }else if(status== 2) {
                if (character == '=') {
                    lexema += character;
                    Tokens tokens = new Tokens("cAtr", lexema, this.line, i - lexema.length());
                    this.tokens.add(tokens);
                    status = 0;
                } else {
                    Tokens tokens = new Tokens("cDPto", lexema, this.line, i - lexema.length());
                    this.tokens.add(tokens);
                    i--;
                    status = 0;
                }
            }else if(status== 3) {
                if ((Character.isDigit(character))) {
                    lexema += character;
                    status = 4;
                } else {
                    adError(this.line);
                    i--;
                    status = 0;
                }
            }else if(status== 4){
                if ((Character.isDigit(character)) && !Character.isWhitespace(character)) {
                    lexema += character;
                } else {
                    adError(this.line);
                    i--;
                    status = 0;
                }
             }else if(status== 5) {
                if ((Character.isLetter(character) || Character.isDigit(character)) && !Character.isWhitespace(character)) {
                    lexema += character;
                } else {
                    Simbols id = new Simbols(lexema.toLowerCase());
                    int endereco = 0;
                    if (!symbolTable.contains(id) && !Reserv.contains(id.getlex().toLowerCase())) {
                        id.setlocat(symbolTable.size());
                        endereco = symbolTable.size();
                        symbolTable.add(id);
                    } else if (symbolTable.contains(id) && !Reserv.contains(id.getlex().toLowerCase())) {
                        endereco = symbolTable.indexOf(id);
                    }
                    if (Reserv.contains(lexema.toLowerCase())) {
                        Tokens tokens = new Tokens("Reserved Word", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                    } else {
                        Tokens tokens = new Tokens("cId", lexema, this.line, i - lexema.length(), endereco);
                        this.tokens.add(tokens);
                    }
                    i--;
                    status = 0;
                }            
            }else if(status== 6) {
                if(bigLogic == 1){
                    if (character == '=') {
                        lexema += character;
                        Tokens tokens = new Tokens("cGE", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                    } else {
                        Tokens tokens = new Tokens("cGT", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                        i--;
                    }
                    status = 0;
                }else{
                    if (character == '=') {
                        lexema += character;
                        Tokens tokens = new Tokens("cLE", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                    } else if (character == '>') {
                        lexema += character;
                        Tokens tokens = new Tokens("cNE", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                    } else {
                        Tokens tokens = new Tokens("cLT", lexema, this.line, i - lexema.length());
                        this.tokens.add(tokens);
                        i--;
                    }
                    status = 0;
                }
            }else if(status== 7) {
                if ((Character.isLetter(character) || Character.isDigit(character)) && !Character.isWhitespace(character)) {
                    lexema += character;
                    status = 7;
                } else if (character == '"') {
                    lexema += character;
                    Tokens tokens = new Tokens("cStr", lexema, this.line, i - lexema.length());
                    this.tokens.add(tokens);
                    status = 0;
                } else {
                    lexema += '"';
                    adError(this.line);
                    Tokens tokens = new Tokens("cStr", lexema, this.line, i - lexema.length());
                    this.tokens.add(tokens);
                    i--;
                    status = 0;
                }
            }
        }
    }   
    public void adError(int el)
    {
        if(!(this.error.contains(String.valueOf(el)))){
            this.error += "Lexical error on the line " + el+"!\n";
        }
    }
}