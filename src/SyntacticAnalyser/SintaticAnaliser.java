/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SyntacticAnalyser;
import File.Simbols;
import File.Tokens;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class SintaticAnaliser {
    ArrayList<Simbols> simbolosList;
  ArrayList<Tokens> tokenList;
  String errormsg = "";

  ArrayList<Tokens> aux = new ArrayList();

  int i = 0;
  Tokens token;
  Tokens funct;

  public SintaticAnaliser(ArrayList<Tokens> tokenList, ArrayList<Simbols> simbolosList, String mensagem)
  {
    this.tokenList = tokenList;
    this.simbolosList = simbolosList;
    this.errormsg = mensagem;
    rodar();
  }

  public String getEmsg() {
    return this.errormsg;
  }

  public void lexi()
  {
    if (this.i < this.tokenList.size()) {
      this.i += 1;
      this.token = ((Tokens)this.tokenList.get(this.i - 1));
    } else {
      adError(this.token.getline());
      return;
    }
  }

  public ArrayList<Simbols> getSimbolos() {
    return new ArrayList(this.simbolosList);
  }
  public void rodar() {
    lexi();
    if (this.token.getLexema().toLowerCase().equals("program")) {
      lexi();
      if (this.token.getclasss().equals("cId")) {
        ((Simbols)this.simbolosList.get(this.token.getlocat())).setcat("program");
        lexi();
        declaration();
        rotina();
        bloco();
        if (!this.token.getLexema().equals("."))
          adError(this.token.getline());
      }
      else {
        adError(this.token.getline());
      }
    } else {
      adError(this.token.getline());
    }
    if (!this.errormsg.contains("Erro"))
    {
      this.errormsg += "Sucesso!";
    }
  }

  public void declaration() {
    if (this.token.getLexema().toLowerCase().equals("var")) {
      lexi();
      dvar();
    }
  }

  public void rotina() {
    if (this.token.getLexema().toLowerCase().equals("procedure"))
      procedure();
    else if (this.token.getLexema().toLowerCase().equals("function"))
      funct();
  }

  public void bloco()
  {
    if (this.token.getLexema().toLowerCase().equals("begin")) {
      lexi();
      sentecasRecursivas();
      if (this.token.getLexema().toLowerCase().equals("end"))
        lexi();
      else
        adError(this.token.getline());
    }
  }

  public void variaveisRecursivas()
  {
    if (this.token.getclasss().equals("cId")) {
      this.aux.add(this.token);
      ((Simbols)this.simbolosList.get(this.token.getlocat())).setcat("Variável");
      lexi();
      if (!this.token.getLexema().equals(":"))
        if (this.token.getLexema().equals(",")) {
          lexi();
          variaveisRecursivas();
        } else {
          adError(this.token.getline());
        }
    }
  }

  public void dvar() {
    variaveisRecursivas();
    if (this.token.getLexema().equals(":")) {
      if (((Tokens)this.tokenList.get(this.i - 2)).getLexema().equals(",")) {
        adError(this.token.getline());
        return;
      }
      lexi();
      if (this.token.getLexema().toLowerCase().equals("integer"))
        tSimples(false);
      else {
        adError(this.token.getline());
      }
      lexi();
      if (this.token.getLexema().equals(";")) {
        lexi();
        dvar();
      }
      else {
        adError(this.token.getline() - 1);
      }
    }
  }

  public void tSimples(boolean array) {
    if (this.token.getLexema().toLowerCase().equals("integer")) {
      for (int j = 0; j < this.aux.size(); j++) {
        if (array)
          ((Simbols)this.simbolosList.get(((Tokens)this.aux.get(j)).getlocat())).settype("[Inteiro]");
        else {
          ((Simbols)this.simbolosList.get(((Tokens)this.aux.get(j)).getlocat())).settype("Inteiro");
        }
      }
    }
    this.aux.clear();
  }

  public void procedure() {
    lexi();
    if (this.token.getclasss().equals("cId")) {
      ((Simbols)this.simbolosList.get(this.token.getlocat())).setcat("Procedure");
      paramet();
      lexi();
      if (!this.token.getLexema().equals(";")) {
        adError(this.token.getline());
        return;
      }
      declaration();
      rotina();
      bloco();
      if (!this.token.getLexema().equals(";")) {
        adError(this.token.getline() - 1);
        return;
      }
      rotina();
    }
  }

  public void funct() {
    lexi();
    if (this.token.getclasss().equals("cId")) {
      ((Simbols)this.simbolosList.get(this.token.getlocat())).setcat("Função");
      this.funct = this.token;
      paramet();
      lexi();
      if (this.token.getLexema().equals(":")) {
        lexi();
        if (this.token.getLexema().toLowerCase().equals("integer")) {
          ((Simbols)this.simbolosList.get(this.funct.getlocat())).settype("Inteiro");
        } else {
          adError(this.token.getline());
          return;
        }
        lexi();
        if (!this.token.getLexema().equals(";")) {
          adError(this.token.getline() - 1);
          return;
        }
        lexi();
        declaration();
        rotina();
        bloco();
        if (!this.token.getLexema().equals(";")) {
          adError(this.token.getline());
          return;
        }
        lexi();
        rotina();
      }
      else
      {
        adError(this.token.getline());
      }
    } else {
      adError(this.token.getline());
    }
  }

  public void paramet() {
    lexi();
    if (this.token.getLexema().equals("(")) {
      listparamet();
      if (this.token.getLexema().equals(")")) {
        if (((Tokens)this.tokenList.get(this.i - 2)).getLexema().equals(";"))
          adError(this.token.getline());
      }
      else
        adError(this.token.getline() - 1);
    }
  }

  public void listparamet()
  {
    listId();
    if (this.token.getLexema().equals(":")) {
      if (((Tokens)this.tokenList.get(this.i - 2)).getLexema().equals(",")) {
        adError(this.token.getline());
        return;
      }
      lexi();
      if (this.token.getLexema().toLowerCase().equals("integer"))
        tSimples(false);
      else {
        adError(this.token.getline());
      }
      lexi();
      if (this.token.getLexema().equals(";"))
        listparamet();
    }
  }

  public void listId()
  {
    lexi();
    if (this.token.getclasss().equals("cId")) {
      this.aux.add(this.token);
      if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat() != null) {
        Simbols id = new Simbols(this.token.getLexema().toLowerCase());
        for (int j = 0; j < this.simbolosList.size(); j++) {
          if ((((Simbols)this.simbolosList.get(j)).getlex().equals(this.token.getLexema())) && (((Simbols)this.simbolosList.get(j)).getcat().equals("Parâmetro"))) {
            adError(this.token.getline());
            return;
          }
        }
        id.setlocat(this.simbolosList.size());
        id.setcat("Parâmetro");
        this.simbolosList.add(id);
        this.token.setlocat(id.getlocat());
      } else {
        ((Simbols)this.simbolosList.get(this.token.getlocat())).setcat("Parâmetro");
      }
      lexi();
      if (!this.token.getLexema().equals(":"))
        if (this.token.getLexema().equals(","))
          listId();
        else
          adError(this.token.getline());
    }
    else if (!this.token.getLexema().equals(")"));
  }

  public void sentecasRecursivas()
  {
    comando();
    lexi();
    try {
      if ((this.token.getLexema().toLowerCase().equals("read")) || (this.token.getLexema().toLowerCase().equals("write")) || (this.token.getLexema().toLowerCase().equals("for")) || (this.token.getLexema().toLowerCase().equals("repeat")) || (this.token.getLexema().toLowerCase().equals("while")) || (this.token.getLexema().toLowerCase().equals("if")) || (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")))
        sentecasRecursivas();
    }
    catch (Exception e) {
      adError(this.token.getline());
    }
  }

  public void comando() {
    try {
      if (this.token.getLexema().toLowerCase().equals("read")) {
        lexi();
        if (this.token.getLexema().equals("(")) {
          var_read_Recursivo();
          if (this.token.getLexema().equals(")"))
            lexi();
          else
            adError(this.token.getline());
        }
      }
      else if (this.token.getLexema().toLowerCase().equals("write")) {
        lexi();
        if (this.token.getLexema().equals("(")) {
          var_write_Recursivo();
          if (this.token.getLexema().equals(")"))
            lexi();
          else
            adError(this.token.getline());
        }
      }
      else if (this.token.getLexema().toLowerCase().equals("for")) {
        lexi();
        try {
          if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")) {
            lexi();
            if (this.token.getLexema().equals(":=")) {
              lexi();
              express();
              if (this.token.getLexema().toLowerCase().equals("to")) {
                lexi();
                express();
                if (this.token.getLexema().toLowerCase().equals("do")) {
                  lexi();
                  bloco();

                  if (!this.token.getLexema().equals(";"))
                    adError(this.token.getline() - 1);
                }
                else
                {
                  adError(this.token.getline());
                }
              } else {
                adError(this.token.getline());
              }
            } else {
              adError(this.token.getline());
            }
          }
        } catch (Exception e) {
          adError(this.token.getline());
        }
      } else if (this.token.getLexema().toLowerCase().equals("repeat")) {
        lexi();
        sentecasRecursivas();
        if (!this.token.getLexema().toLowerCase().equals("until")) {
          adError(this.token.getline());
          return;
        }
        lexi();
        express_logicAux_Recursiva();
      } else if (this.token.getLexema().toLowerCase().equals("while")) {
        lexi();
        express_logicAux_Recursiva();
        if (!this.token.getLexema().toLowerCase().equals("do")) {
          adError(this.token.getline());
          return;
        }
        lexi();
        bloco();

        if (!this.token.getLexema().equals(";")) {
          adError(this.token.getline() - 1);
        }
      }
      else if (this.token.getLexema().toLowerCase().equals("if")) {
        lexi();
        express_logicAux_Recursiva();
        if (!this.token.getLexema().toLowerCase().equals("then")) {
          adError(this.token.getline());
          return;
        }
        lexi();
        bloco();
        if (this.token.getLexema().toLowerCase().equals("else")) {
          lexi();
          bloco();
        }
      } else if ((((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")) || (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Função"))) {
        lexi();
        if (this.token.getLexema().equals(":=")) {
          lexi();
          if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("procedure")) {
            lexi();
            args();
          } else {
            express();
          }
        } else {
          adError(this.token.getline());
          return;
        }
      }
    } catch (Exception e) {
      adError(this.token.getline());
    }
  }

  public void args() {
    if (this.token.getLexema().equals("(")) {
      lexi();
      list_arg_Recursivo();
      if (this.token.getLexema().equals(")")) {
        lexi();
      } else {
        adError(this.token.getline());
        return;
      }
    }
  }

  public void list_arg_Recursivo() {
    express();
    if (this.token.getLexema().equals(",")) {
      lexi();
      list_arg_Recursivo();
    }
  }

  public void var_read_Recursivo() {
    lexi();
    if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat() != null) {
      if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")) {
        lexi();
        if (this.token.getLexema().equals(","))
          var_read_Recursivo();
      }
      else {
        adError(this.token.getline());
      }
    }
    else adError(this.token.getline());
  }

  public void var_write_Recursivo()
  {
    lexi();
    if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat() != null) {
      if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")) {
        lexi();
        if (this.token.getLexema().equals(","))
          var_write_Recursivo();
      }
      else {
        adError(this.token.getline());
      }
    }
    else adError(this.token.getline());
  }

  public void express()
  {
    if ((this.token.getLexema().equals("+")) || (this.token.getLexema().equals("-"))) {
      termo();
      if ((this.token.getLexema().equals("+")) || (this.token.getclasss().equals("cSub")) || (this.token.getLexema().equals("*")) || (this.token.getLexema().equals("/")) || (this.token.getLexema().toLowerCase().equals("and")) || (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Função")) || (this.token.getLexema().equals("(")))
        express();
    }
    else {
      termo();
      if ((this.token.getLexema().equals("+")) || (this.token.getclasss().equals("cSub")) || (this.token.getLexema().equals("*")) || (this.token.getLexema().equals("/")) || (this.token.getLexema().toLowerCase().equals("and")) || (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Função")) || (this.token.getLexema().equals("("))) {
        lexi();
        termo();
        if ((this.token.getLexema().equals("+")) || (this.token.getclasss().equals("cSub")) || (this.token.getLexema().equals("*")) || (this.token.getLexema().equals("/")) || (this.token.getLexema().toLowerCase().equals("and")) || (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Função")) || (this.token.getLexema().equals("(")))
          express();
      }
    }
  }

  public void express_logicAux_Recursiva()
  {
    termo_logica();
    if (this.token.getLexema().toLowerCase().equals("or")) {
      lexi();
      express_logicAux_Recursiva();
    }
  }

  public void termo() {
    if ((this.token.getLexema().equals("*")) || (this.token.getLexema().equals("/")) || (this.token.getLexema().toLowerCase().equals("and"))) {
      lexi();
      q();
      if ((this.token.getLexema().equals("*")) || (this.token.getLexema().equals("/")) || (this.token.getLexema().toLowerCase().equals("and")))
        termo();
    }
    else {
      q();
    }
  }

  public void termo_logica() {
    if (this.token.getLexema().toLowerCase().equals("and")) {
      lexi();
      q_logica();
      if (this.token.getLexema().toLowerCase().equals("and"))
        termo_logica();
    }
    else {
      q_logica();
    }
  }

  public void q() {
    try {
      if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Variável")) {
        lexi();
      } else if (((Simbols)this.simbolosList.get(this.token.getlocat())).getcat().equals("Função")) {
        lexi();
        args();
      } else if (this.token.getclasss().equals("cInt")) {
        lexi();
      } else if (this.token.getclasss().equals("(")) {
        lexi();
        express();
        if (!this.token.getclasss().equals(")"))
        {
          adError(this.token.getline());
        }
      } else {
        adError(this.token.getline());
      }
    } catch (Exception e) {
      adError(this.token.getline());
    }
  }

  public void q_logica() {
    if (this.token.getLexema().toLowerCase().equals("not")) {
      lexi();
      q_logica();
    } else if ((!this.token.getLexema().toLowerCase().equals("false")) && 
      (!this.token.getLexema().toLowerCase().equals("true"))) {
      if (this.token.getLexema().equals("(")) {
        lexi();
        express_logicAux_Recursiva();
        if (!this.token.getLexema().equals(")")) {
          adError(this.token.getline());
        }
        lexi();
      } else {
        express();
        if ((this.token.getLexema().equals("=")) || (this.token.getLexema().equals(">")) || (this.token.getLexema().equals("<")) || (this.token.getLexema().equals(">=")) || (this.token.getLexema().equals("<=")) || (this.token.getLexema().equals("<>")))
          lexi();
        else {
          adError(this.token.getline());
        }
        express();
      }
    }
  }

  public void adError(int el) {
    if (!this.errormsg.contains(String.valueOf(el)))
      this.errormsg = (this.errormsg + "Erro na linha " + el + "!\n");
  }
}
