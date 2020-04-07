/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexAnalyser;
import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class ReservedWords {
  private ArrayList<String> RdWords;

  public ReservedWords()
  {
    this.RdWords.add("integer");
    this.RdWords.add("real");
    this.RdWords.add("string");
    this.RdWords.add("boolean");
    this.RdWords.add("false");
    this.RdWords.add("true");
    this.RdWords.add("and");
    this.RdWords.add("array");
    this.RdWords.add("begin");
    this.RdWords.add("break");
    this.RdWords.add("case");
    this.RdWords.add("const");
    this.RdWords.add("div");
    this.RdWords.add("do");
    this.RdWords.add("downto");
    this.RdWords.add("else");
    this.RdWords.add("end");
    this.RdWords.add("file");
    this.RdWords.add("for");
    this.RdWords.add("function");
    this.RdWords.add("goto");
    this.RdWords.add("if");
    this.RdWords.add("in");
    this.RdWords.add("label");
    this.RdWords.add("mod");
    this.RdWords.add("nil");
    this.RdWords.add("not");
    this.RdWords.add("of");
    this.RdWords.add("or");
    this.RdWords.add("packed");
    this.RdWords.add("procedure");
    this.RdWords.add("program");
    this.RdWords.add("record");
    this.RdWords.add("repeat");
    this.RdWords.add("set");
    this.RdWords.add("then");
    this.RdWords.add("to");
    this.RdWords.add("type");
    this.RdWords.add("until");
    this.RdWords.add("var");
    this.RdWords.add("while");
    this.RdWords.add("with");
    this.RdWords.add("read");
    this.RdWords.add("write");
  }

  public ArrayList<String> getRdWords() {
    return this.RdWords;
  }
}
