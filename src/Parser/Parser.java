	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import File.Simbols;
import File.Tokens;
import java.util.ArrayList;

/**
 *
 * @author rafha
 */
public class Parser {
    ArrayList<Simbols> simbolsList;
    ArrayList<Tokens> tokenList;
    String errormsg = "";
    
    ArrayList<Tokens> aux = new ArrayList<Tokens>();
    

    public Parser(ArrayList<Tokens> tokenList, ArrayList<Simbols> simbolsList, String message) {
        this.tokenList = tokenList;
        this.simbolsList = simbolsList;
        this.errormsg = message;
        this.run();
    }

    public String getEmsg() {
        return this.errormsg;
    }

    int i = 0;
    Tokens token;
    public void lexi() {
        if (this.i < this.tokenList.size()) {
            this.i++;
            this.token = this.tokenList.get(i - 1);
        } else {
            this.adError(token.getline());
            return;
        }
    }

    public ArrayList<Simbols> getSimbols() {
        return new ArrayList<Simbols>(this.simbolsList);
    }
    public void run() {
        this.lexi();
        if (token.getLexema().toLowerCase().equals("program")) {
            this.lexi();
            if (token.getclasss().equals("cId")) {
                this.simbolsList.get(this.token.getlocat()).setcat("program");
                this.lexi();
                this.declaration();
                this.routine();
                this.block();
                if (!token.getLexema().equals(".")) {
                    this.adError(token.getline());
                }
            } else {
                this.adError(token.getline());
            }
        } else {
           this.adError(token.getline());
        }
        if(!(this.errormsg.contains("Error")))
        {
            this.errormsg += "Sucess!";
        }

    }
    public void declaration() {
        if (this.token.getLexema().toLowerCase().equals("var")) {
            this.lexi();
            this.dvar();
        }
    }

    public void routine() {
        if (this.token.getLexema().toLowerCase().equals("procedure")) {
            this.procedure();
        } else if (this.token.getLexema().toLowerCase().equals("function")) {
            this.funct();
        }
    }

    public void block() {
        if (this.token.getLexema().toLowerCase().equals("begin")) {
            this.lexi();
            this.recursiveSenteces();
            if (this.token.getLexema().toLowerCase().equals("end")) {
                this.lexi();                        
            }else{
                this.adError(token.getline());
            }
        }
    }

    public void recursiveVariables() {
        if (this.token.getclasss().equals("cId")) {
            this.aux.add(this.token);
            this.simbolsList.get(this.token.getlocat()).setcat("Variável");
            this.lexi();
            if (this.token.getLexema().equals(":")) {
            } else if (this.token.getLexema().equals(",")) {
                this.lexi();
                this.recursiveVariables();
            } else {
                this.adError(token.getline());
            }
        }
    }
	
    public void dvar() {
        this.recursiveVariables();
        if (this.token.getLexema().equals(":")) {
            if (this.tokenList.get(this.i - 2).getLexema().equals(",")) {
                this.adError(token.getline());
                return;
            }            
            this.lexi();
            if (this.token.getLexema().toLowerCase().equals("integer")) {
                this.tSimples(false);
            } else {
                this.adError(token.getline());
            }            
            this.lexi();
            if (this.token.getLexema().equals(";")) {
                this.lexi();
                this.dvar();
            }else
            {
                this.adError(token.getline()-1);
            }
        }
    }

    public void tSimples(boolean array) {
        if (this.token.getLexema().toLowerCase().equals("integer")) {
            for (int j = 0; j < this.aux.size(); j++) {
                if (array) {
                    this.simbolsList.get(this.aux.get(j).getlocat()).settype("[Integer]");
                } else {
                    this.simbolsList.get(this.aux.get(j).getlocat()).settype("Integer");
                }
            }
        } 
        this.aux.clear();
    }

    public void procedure() {
        this.lexi();
        if (this.token.getclasss().equals("cId")) {
            this.simbolsList.get(this.token.getlocat()).setcat("Procedure");
            this.paramet();
            this.lexi();
            if (!this.token.getLexema().equals(";")) {
                this.adError(token.getline());
                return;
            }
            this.declaration();
            this.routine();
            this.block();
            if (!this.token.getLexema().equals(";")) {
                this.adError(token.getline()-1);
                return;
            }
            this.routine();
        }
    }
    Tokens funct;
    public void funct() {
        this.lexi();
        if (this.token.getclasss().equals("cId")) {
            this.simbolsList.get(this.token.getlocat()).setcat("Function");
            this.funct = this.token;
            this.paramet();
            this.lexi();
            if (this.token.getLexema().equals(":")) {
                this.lexi();
                if (this.token.getLexema().toLowerCase().equals("integer")) {
                    this.simbolsList.get(this.funct.getlocat()).settype("Integer");
                } else {
                    this.adError(token.getline());
                    return;
                }
                this.lexi();
                if (!this.token.getLexema().equals(";")) {
                    this.adError(token.getline()-1);
                    return;
                } else {
                    this.lexi();
                    this.declaration();
                    this.routine();
                   this.block();
                   if (!this.token.getLexema().equals(";")) {
                        this.adError(token.getline());
                        return;
                    } else {
                        this.lexi();
                        this.routine();
                    }
                }
            } else {
                this.adError(token.getline());
            }
        } else {
            this.adError(token.getline());
        }
    }

    public void paramet() {
        this.lexi();
        if (this.token.getLexema().equals("(")) {
            this.listparamet();
            if (this.token.getLexema().equals(")")) {
                if (this.tokenList.get(this.i - 2).getLexema().equals(";")) {
                    this.adError(token.getline());
                }
            } else {
                this.adError(token.getline()-1);
            }
        }
    }

    public void listparamet() {
        this.listId();
        if (this.token.getLexema().equals(":")) {
            if (this.tokenList.get(this.i - 2).getLexema().equals(",")) {
                this.adError(token.getline());
                return;
            }            
            this.lexi();
            if (this.token.getLexema().toLowerCase().equals("integer") ) {
                this.tSimples(false);
            } else {
                this.adError(token.getline());
            }
            this.lexi();
            if (this.token.getLexema().equals(";")) {
                this.listparamet();
            }
        }
    }

    public void listId() {
        this.lexi();
        if (this.token.getclasss().equals("cId")) {      
            this.aux.add(this.token);
            if (this.simbolsList.get(this.token.getlocat()).getcat()!= null) {
                Simbols id = new Simbols(this.token.getLexema().toLowerCase());
                for (int j = 0; j < this.simbolsList.size(); j++) {
                    if (this.simbolsList.get(j).getlex().equals(this.token.getLexema()) && this.simbolsList.get(j).getcat().equals("Parâmetro")) {
                        this.adError(token.getline());
                        return;
                    }
                }
                id.setlocat(this.simbolsList.size());
                id.setcat("Parâmetro");
                this.simbolsList.add(id);
                this.token.setlocat(id.getlocat());
            } else {
                this.simbolsList.get(this.token.getlocat()).setcat("Parâmetro");
            }
            this.lexi();
            if (this.token.getLexema().equals(":")) {
            } else if (this.token.getLexema().equals(",")) {
                this.listId();
            } else {
                this.adError(token.getline());
            }          
            } else if (this.token.getLexema().equals(")")) {
        }
    }
    
    public void recursiveSenteces() {
        this.command();
        this.lexi();
        try {
            if (this.token.getLexema().toLowerCase().equals("read") || this.token.getLexema().toLowerCase().equals("write") || this.token.getLexema().toLowerCase().equals("for") || this.token.getLexema().toLowerCase().equals("repeat") || this.token.getLexema().toLowerCase().equals("while") || this.token.getLexema().toLowerCase().equals("if") || this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável")) {
                this.recursiveSenteces();
            }
        } catch (Exception e) {
            this.adError(token.getline());        
        }
    }

    public void command() {
        try {
            if (this.token.getLexema().toLowerCase().equals("read")) {
                this.lexi();
                if (this.token.getLexema().equals("(")) {
                    this.var_read_Recursive();
                    if (this.token.getLexema().equals(")")) {
                        this.lexi();                        
                    } else {
                        this.adError(token.getline());
                    }
                } 
            } else if (this.token.getLexema().toLowerCase().equals("write")) {
                this.lexi();
                if (this.token.getLexema().equals("(")) {
                    this.var_write_Recursive();
                    if (this.token.getLexema().equals(")")) {
                        this.lexi();
                    } else {
                        this.adError(token.getline());
                    }
                } 
            } else if (this.token.getLexema().toLowerCase().equals("for")) {
                this.lexi();
                try {
                    if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável")) {
                        this.lexi();
                        if (this.token.getLexema().equals(":=")) {
                            this.lexi();
                            this.express();
                            if (this.token.getLexema().toLowerCase().equals("to")) {
                                this.lexi();
                                this.express();
                                if (this.token.getLexema().toLowerCase().equals("do")) {
                                    this.lexi();
                                    this.block();
                                    //aqui
                                    if (!this.token.getLexema().equals(";")) {
                                        this.adError(token.getline()-1);
                                        return;
                                    }
                                } else {
                                    this.adError(token.getline());
                                }
                            } else {
                                this.adError(token.getline());
                            }
                        } else {
                            this.adError(token.getline());
                        }
                    }
                } catch (Exception e) {
                    this.adError(token.getline());
                }
            } else if (this.token.getLexema().toLowerCase().equals("repeat")) {
                this.lexi();
                this.recursiveSenteces();
                if (!this.token.getLexema().toLowerCase().equals("until")) {
                    this.adError(token.getline());
                    return;
                }
                this.lexi();
                this.express_logicAux_Recursive();
            } else if (this.token.getLexema().toLowerCase().equals("while")) {
                this.lexi();
                this.express_logicAux_Recursive();
                if (!this.token.getLexema().toLowerCase().equals("do")) {
                    this.adError(token.getline());
                    return;
                }
                this.lexi();
                this.block();
                //aqui
                if (!this.token.getLexema().equals(";")) {
                    this.adError(token.getline()-1);
                    return;
                }
            } else if (this.token.getLexema().toLowerCase().equals("if")) {
                this.lexi();
                this.express_logicAux_Recursive();
                if (!this.token.getLexema().toLowerCase().equals("then")) {
                    this.adError(token.getline());
                    return;
                }
                this.lexi();
                this.block();
                if (this.token.getLexema().toLowerCase().equals("else")) {
                    this.lexi();
                    this.block();
                }
            } else if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável") || this.simbolsList.get(this.token.getlocat()).getcat().equals("Função")) {
                this.lexi();
                if (this.token.getLexema().equals(":=")) {
                    this.lexi();
                    if (this.simbolsList.get(this.token.getlocat()).getcat().equals("procedure")) {
                        this.lexi();
                        this.args();
                    } else {
                        this.express();
                    }
                } else {
                    this.adError(token.getline());
                    return;
                }
            }
        } catch (Exception e) {
            this.adError(token.getline());
        }
    }

    public void args() {
        if (this.token.getLexema().equals("(")) {
            this.lexi();
            this.list_arg_Recursive();
            if (this.token.getLexema().equals(")")) {
                this.lexi();
            } else {
                this.adError(token.getline());
                return;
            }
        }
    }

    public void list_arg_Recursive() {
        this.express();
        if (this.token.getLexema().equals(",")) {
            this.lexi();
            this.list_arg_Recursive();
        }
    }

    public void var_read_Recursive() {
        this.lexi();
        if (this.simbolsList.get(this.token.getlocat()).getcat() != null) {
            if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável")) {
                this.lexi();
                if (this.token.getLexema().equals(",")) {
                    this.var_read_Recursive();
                }
            } else {
                this.adError(token.getline());
            }
        } else {
            this.adError(token.getline());
        }
    }

    public void var_write_Recursive() {
        this.lexi();
        if (this.simbolsList.get(this.token.getlocat()).getcat() != null) {
            if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável")) {
                this.lexi();
                if (this.token.getLexema().equals(",")) {
                    this.var_write_Recursive();
                }
            } else {
                this.adError(token.getline());
            }
        } else {
            this.adError(token.getline());
        }
    }

    public void express() {
        if (this.token.getLexema().equals("+") || this.token.getLexema().equals("-")) {
            this.term();
            if (this.token.getLexema().equals("+") || this.token.getclasss().equals("cSub") || this.token.getLexema().equals("*") || this.token.getLexema().equals("/") || this.token.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.token.getlocat()).getcat().equals("Função") || this.token.getLexema().equals("(")) {
                this.express();
            }
        } else {
            this.term();
            if (this.token.getLexema().equals("+") || this.token.getclasss().equals("cSub") || this.token.getLexema().equals("*") || this.token.getLexema().equals("/") || this.token.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.token.getlocat()).getcat().equals("Função") || this.token.getLexema().equals("(")) {
                this.lexi();
                this.term();
                if (this.token.getLexema().equals("+") || this.token.getclasss().equals("cSub") || this.token.getLexema().equals("*") || this.token.getLexema().equals("/") || this.token.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.token.getlocat()).getcat().equals("Função") || this.token.getLexema().equals("(")) {
                    this.express();
                }
            }
        }
    }

    public void express_logicAux_Recursive() {
        this.term_logic();
        if (this.token.getLexema().toLowerCase().equals("or")) {
            this.lexi();
            this.express_logicAux_Recursive();
        }
    }

    public void term() {
        if (this.token.getLexema().equals("*") || this.token.getLexema().equals("/") || this.token.getLexema().toLowerCase().equals("and")) {
            this.lexi();
            this.q();
            if (this.token.getLexema().equals("*") || this.token.getLexema().equals("/") || this.token.getLexema().toLowerCase().equals("and")) {
                this.term();
            }
        } else {
            this.q();
        }
    }

    public void term_logic() {
        if (this.token.getLexema().toLowerCase().equals("and")) {
            this.lexi();
            this.q_logic();
            if (this.token.getLexema().toLowerCase().equals("and")) {
                this.term_logic();
            }
        } else {
            this.q_logic();
        }
    }
    
    public void q() {
        try {
            if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Variável")) {
                this.lexi();
            } else if (this.simbolsList.get(this.token.getlocat()).getcat().equals("Função")) {
                this.lexi();
                this.args();
            } else if (this.token.getclasss().equals("cInt")) {
                this.lexi();
            } else if (this.token.getclasss().equals("(")) {
                this.lexi();
                this.express();
                if (this.token.getclasss().equals(")")) {
                } else {
                    this.adError(token.getline());
                }
            } else {
                this.adError(token.getline());
            }
        } catch (Exception e) {
            this.adError(token.getline());
        }
    }
    
    public void q_logic() {
        if (this.token.getLexema().toLowerCase().equals("not")) {
            this.lexi();
            this.q_logic();
        } else if (this.token.getLexema().toLowerCase().equals("false")) {
        } else if (this.token.getLexema().toLowerCase().equals("true")) {        
        } else if (this.token.getLexema().equals("(")) {
            this.lexi();
            this.express_logicAux_Recursive();
            if (!this.token.getLexema().equals(")")) {
                this.adError(token.getline());
            }
            this.lexi();
        } else {        
            this.express();
            if (this.token.getLexema().equals("=") || this.token.getLexema().equals(">") || this.token.getLexema().equals("<") || this.token.getLexema().equals(">=") || this.token.getLexema().equals("<=") || this.token.getLexema().equals("<>")) {
                this.lexi();
            } else {
                this.adError(token.getline());
            }
            this.express();
        }
    }
    
    public void adError(int el)
    {
        if(!(this.errormsg.contains(String.valueOf(el)))){
            this.errormsg += "Erro na linha " + el+"!\n";
        }
    }
   
    
}