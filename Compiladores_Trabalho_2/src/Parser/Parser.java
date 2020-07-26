/*
 * To change this license header, choose License Headers in Project Properties
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
    ArrayList<Tokens> tokensList;
    String errorMessageText = "";
    int i = 0;
    Tokens tokens;
    ArrayList<Tokens> tokensListAux = new ArrayList<Tokens>();
    

    public Parser(ArrayList<Tokens> tokensList, ArrayList<Simbols> simbolsList, String message) {
        this.tokensList = tokensList;
        this.simbolsList = simbolsList;
        this.errorMessageText = message;
        this.run();
    }
    
    public void run() {
        this.lexi();
        if (tokens.getLexema().toLowerCase().equals("program")) {            
            this.lexi();            
            if (tokens.getclasss().equals("cId")) {
                this.simbolsList.get(this.tokens.getlocat()).setcat("program");
                this.lexi();
                if (!tokens.getLexema().equals(";")) {
                    this.Add_Error(tokens.getline());
                }
                this.lexi();
                //Declarando as vars   
                this.decVars();
                //Lexema está no begin
                this.routine();
                this.block();
                if (!tokens.getLexema().equals(".")) {
                    this.Add_Error(tokens.getline());
                }
                
            } else {
                this.Add_Error(tokens.getline());
            }    
        } else {
           this.Add_Error(tokens.getline());
        }
        this.verifyError();
    }
    // sta
    public void routine() {
        if (this.tokens.getLexema().toLowerCase().equals("procedure")) {
            this.procedure();
        } else if (this.tokens.getLexema().toLowerCase().equals("function")) {
            this.funct();
        }
    }
    
    public void procedure() {
        this.lexi();
        if (this.tokens.getclasss().equals("cId")) {
            this.simbolsList.get(this.tokens.getlocat()).setcat("Procedure");
            this.paramet();
            this.lexi();
            if (!this.tokens.getLexema().equals(";")) {
                this.Add_Error(tokens.getline());
                return;
            }
            this.decVars();
            this.routine();
            this.block();
            if (!this.tokens.getLexema().equals(";")) {
                this.Add_Error(tokens.getline()-1);
                return;
            }
            this.routine();
        }
    }
    Tokens funct;
    public void funct() {
        this.lexi();
        if (this.tokens.getclasss().equals("cId")) {
            this.simbolsList.get(this.tokens.getlocat()).setcat("Function");
            this.funct = this.tokens;
            this.paramet();
            this.lexi();
            if (this.tokens.getLexema().equals(":")) {
                this.lexi();
                if (this.tokens.getLexema().toLowerCase().equals("integer")) {
                    this.simbolsList.get(this.funct.getlocat()).settype("Integer");
                } else {
                    this.Add_Error(tokens.getline());
                    return;
                }
                this.lexi();
                if (!this.tokens.getLexema().equals(";")) {
                    this.Add_Error(tokens.getline()-1);
                    return;
                } else {
                    this.lexi();
                    this.decVars();
                    this.routine();
                   this.block();
                   if (!this.tokens.getLexema().equals(";")) {
                        this.Add_Error(tokens.getline());
                        return;
                    } else {
                        this.lexi();
                        this.routine();
                    }
                }
            } else {
                this.Add_Error(tokens.getline());
            }
        } else {
            this.Add_Error(tokens.getline());
        }
    }
    
        public void block() {
        if (this.tokens.getLexema().toLowerCase().equals("begin")) {
            this.lexi();
            this.recursiveSenteces();
            if (this.tokens.getLexema().toLowerCase().equals("end")) {
                this.lexi();                        
            }else{
                this.Add_Error(tokens.getline());
            }
        }
    }

    public void paramet() {
        this.lexi();
        if (this.tokens.getLexema().equals("(")) {
            this.listparamet();
            if (this.tokens.getLexema().equals(")")) {
                if (this.tokensList.get(this.i - 2).getLexema().equals(";")) {
                    this.Add_Error(tokens.getline());
                }
            } else {
                this.Add_Error(tokens.getline()-1);
            }
        }
    }

    public void listparamet() {
        this.listId();
        if (this.tokens.getLexema().equals(":")) {
            if (this.tokensList.get(this.i - 2).getLexema().equals(",")) {
                this.Add_Error(tokens.getline());
                return;
            }            
            this.lexi();
            if (this.tokens.getLexema().toLowerCase().equals("integer") ) {
                this.TypeDeclaration();
            } else {
                this.Add_Error(tokens.getline());
            }
            this.lexi();
            if (this.tokens.getLexema().equals(";")) {
                this.listparamet();
            }
        }
    }

    public void listId() {
        this.lexi();
        if (this.tokens.getclasss().equals("cId")) {      
            this.tokensListAux.add(this.tokens);
            if (this.simbolsList.get(this.tokens.getlocat()).getcat()!= null) {
                Simbols id = new Simbols(this.tokens.getLexema().toLowerCase());
                for (int j = 0; j < this.simbolsList.size(); j++) {
                    if (this.simbolsList.get(j).getlex().equals(this.tokens.getLexema()) && this.simbolsList.get(j).getcat().equals("Parâmetro")) {
                        this.Add_Error(tokens.getline());
                    }
                }
                id.setlocat(this.simbolsList.size());
                id.setcat("Parâmetro");
                this.simbolsList.add(id);
                this.tokens.setlocat(id.getlocat());
            } else {
                this.simbolsList.get(this.tokens.getlocat()).setcat("Parâmetro");
            }
            this.lexi();
            if (this.tokens.getLexema().equals(":")) {
            } else if (this.tokens.getLexema().equals(",")) {
                this.listId();
            } else {
                this.Add_Error(tokens.getline());
            }          
            } else if (this.tokens.getLexema().equals(")")) {
        }
    }
    
    public void recursiveSenteces() {
        this.command();
        this.lexi();
        try {
            if (this.tokens.getLexema().toLowerCase().equals("read") || this.tokens.getLexema().toLowerCase().equals("write") || this.tokens.getLexema().toLowerCase().equals("for") || this.tokens.getLexema().toLowerCase().equals("repeat") || this.tokens.getLexema().toLowerCase().equals("while") || this.tokens.getLexema().toLowerCase().equals("if") || this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável")) {
                this.recursiveSenteces();
            }
        } catch (Exception e) {
            this.Add_Error(tokens.getline());        
        }
    }

    public void command() {
        try {
            if (this.tokens.getLexema().toLowerCase().equals("read")) {
                this.lexi();
                if (this.tokens.getLexema().equals("(")) {
                    this.var_read_Recursive();
                    if (this.tokens.getLexema().equals(")")) {
                        this.lexi();                        
                    } else {
                        this.Add_Error(tokens.getline());
                    }
                } 
            } else if (this.tokens.getLexema().toLowerCase().equals("write")) {
                this.lexi();
                if (this.tokens.getLexema().equals("(")) {
                    this.var_write_Recursive();
                    if (this.tokens.getLexema().equals(")")) {
                        this.lexi();
                    } else {
                        this.Add_Error(tokens.getline());
                    }
                } 
            } else if (this.tokens.getLexema().toLowerCase().equals("for")) {
                this.lexi();
                try {
                    if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável")) {
                        this.lexi();
                        if (this.tokens.getLexema().equals(":=")) {
                            this.lexi();
                            this.express();
                            if (this.tokens.getLexema().toLowerCase().equals("to")) {
                                this.lexi();
                                this.express();
                                if (this.tokens.getLexema().toLowerCase().equals("do")) {
                                    this.lexi();
                                    this.block();
                                    //aqui
                                    if (!this.tokens.getLexema().equals(";")) {
                                        this.Add_Error(tokens.getline()-1);
                                        return;
                                    }
                                } else {
                                    this.Add_Error(tokens.getline());
                                }
                            } else {
                                this.Add_Error(tokens.getline());
                            }
                        } else {
                            this.Add_Error(tokens.getline());
                        }
                    }
                } catch (Exception e) {
                    this.Add_Error(tokens.getline());
                }
            } else if (this.tokens.getLexema().toLowerCase().equals("repeat")) {
                this.lexi();
                this.recursiveSenteces();
                if (!this.tokens.getLexema().toLowerCase().equals("until")) {
                    this.Add_Error(tokens.getline());
                    return;
                }
                this.lexi();
                this.express_logicAux_Recursive();
            } else if (this.tokens.getLexema().toLowerCase().equals("while")) {
                this.lexi();
                this.express_logicAux_Recursive();
                if (!this.tokens.getLexema().toLowerCase().equals("do")) {
                    this.Add_Error(tokens.getline());
                    return;
                }
                this.lexi();
                this.block();
                //aqui
                if (!this.tokens.getLexema().equals(";")) {
                    this.Add_Error(tokens.getline()-1);
                    return;
                }
            } else if (this.tokens.getLexema().toLowerCase().equals("if")) {
                this.lexi();
                this.express_logicAux_Recursive();
                if (!this.tokens.getLexema().toLowerCase().equals("then")) {
                    this.Add_Error(tokens.getline());
                    return;
                }
                this.lexi();
                this.block();
                if (this.tokens.getLexema().toLowerCase().equals("else")) {
                    this.lexi();
                    this.block();
                }
            } else if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável") || this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Função")) {
                this.lexi();
                if (this.tokens.getLexema().equals(":=")) {
                    this.lexi();
                    if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("procedure")) {
                        this.lexi();
                        this.args();
                    } else {
                        this.express();
                    }
                } else {
                    this.Add_Error(tokens.getline());
                    return;
                }
            }
        } catch (Exception e) {
            this.Add_Error(tokens.getline());
        }
    }

    public void args() {
        if (this.tokens.getLexema().equals("(")) {
            this.lexi();
            this.list_arg_Recursive();
            if (this.tokens.getLexema().equals(")")) {
                this.lexi();
            } else {
                this.Add_Error(tokens.getline());
                return;
            }
        }
    }

    public void list_arg_Recursive() {
        this.express();
        if (this.tokens.getLexema().equals(",")) {
            this.lexi();
            this.list_arg_Recursive();
        }
    }

    public void var_read_Recursive() {
        this.lexi();
        if (this.simbolsList.get(this.tokens.getlocat()).getcat() != null) {
            if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável")) {
                this.lexi();
                if (this.tokens.getLexema().equals(",")) {
                    this.var_read_Recursive();
                }
            } else {
                this.Add_Error(tokens.getline());
            }
        } else {
            this.Add_Error(tokens.getline());
        }
    }

    public void var_write_Recursive() {
        this.lexi();
        if (this.simbolsList.get(this.tokens.getlocat()).getcat() != null) {
            if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável")) {
                this.lexi();
                if (this.tokens.getLexema().equals(",")) {
                    this.var_write_Recursive();
                }
            } else {
                this.Add_Error(tokens.getline());
            }
        } else {
            this.Add_Error(tokens.getline());
        }
    }

    public void express() {
        if (this.tokens.getLexema().equals("+") || this.tokens.getLexema().equals("-")) {
            this.term();
            if (this.tokens.getLexema().equals("+") || this.tokens.getclasss().equals("cSub") || this.tokens.getLexema().equals("*") || this.tokens.getLexema().equals("/") || this.tokens.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Função") || this.tokens.getLexema().equals("(")) {
                this.express();
            }
        } else {
            this.term();
            if (this.tokens.getLexema().equals("+") || this.tokens.getclasss().equals("cSub") || this.tokens.getLexema().equals("*") || this.tokens.getLexema().equals("/") || this.tokens.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Função") || this.tokens.getLexema().equals("(")) {
                this.lexi();
                this.term();
                if (this.tokens.getLexema().equals("+") || this.tokens.getclasss().equals("cSub") || this.tokens.getLexema().equals("*") || this.tokens.getLexema().equals("/") || this.tokens.getLexema().toLowerCase().equals("and") || this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Função") || this.tokens.getLexema().equals("(")) {
                    this.express();
                }
            }
        }
    }

    public void express_logicAux_Recursive() {
        this.term_logic();
        if (this.tokens.getLexema().toLowerCase().equals("or")) {
            this.lexi();
            this.express_logicAux_Recursive();
        }
    }

    public void term() {
        if (this.tokens.getLexema().equals("*") || this.tokens.getLexema().equals("/") || this.tokens.getLexema().toLowerCase().equals("and")) {
            this.lexi();
            this.q();
            if (this.tokens.getLexema().equals("*") || this.tokens.getLexema().equals("/") || this.tokens.getLexema().toLowerCase().equals("and")) {
                this.term();
            }
        } else {
            this.q();
        }
    }

    public void term_logic() {
        if (this.tokens.getLexema().toLowerCase().equals("and")) {
            this.lexi();
            this.q_logic();
            if (this.tokens.getLexema().toLowerCase().equals("and")) {
                this.term_logic();
            }
        } else {
            this.q_logic();
        }
    }
    
    public void q() {
        try {
            if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Variável")) {
                this.lexi();
            } else if (this.simbolsList.get(this.tokens.getlocat()).getcat().equals("Função")) {
                this.lexi();
                this.args();
            } else if (this.tokens.getclasss().equals("cInt")) {
                this.lexi();
            } else if (this.tokens.getclasss().equals("(")) {
                this.lexi();
                this.express();
                if (this.tokens.getclasss().equals(")")) {
                } else {
                    this.Add_Error(tokens.getline());
                }
            } else {
                this.Add_Error(tokens.getline());
            }
        } catch (Exception e) {
            this.Add_Error(tokens.getline());
        }
    }
    
    public void q_logic() {
        if (this.tokens.getLexema().toLowerCase().equals("not")) {
            this.lexi();
            this.q_logic();
        } else if (this.tokens.getLexema().toLowerCase().equals("false")) {
        } else if (this.tokens.getLexema().toLowerCase().equals("true")) {        
        } else if (this.tokens.getLexema().equals("(")) {
            this.lexi();
            this.express_logicAux_Recursive();
            if (!this.tokens.getLexema().equals(")")) {
                this.Add_Error(tokens.getline());
            }
            this.lexi();
        } else {        
            this.express();
            if (this.tokens.getLexema().equals("=") || this.tokens.getLexema().equals(">") || this.tokens.getLexema().equals("<") || this.tokens.getLexema().equals(">=") || this.tokens.getLexema().equals("<=") || this.tokens.getLexema().equals("<>")) {
                this.lexi();
            } else {
                this.Add_Error(tokens.getline());
            }
            this.express();
        }
    }	
    //end
    public void decVars() {
        if (this.tokens.getLexema().toLowerCase().equals("var")) {
            this.lexi();
            this.recursiveVariables();
            
        }
    }
    
    public void recursiveVariables() {
        if (this.tokens.getclasss().equals("cId")) {
            this.tokensListAux.add(this.tokens);
            this.simbolsList.get(this.tokens.getlocat()).setcat("Variável");
            this.lexi();
            if (this.tokens.getLexema().equals(":")) {
                this.lexi();
                this.TypeDeclaration();
                this.lexi();
                this.recursiveVariables();
            } else if (this.tokens.getLexema().equals(",")) {
                this.lexi();
                this.recursiveVariables();
            } else {
                this.Add_Error(tokens.getline());
            }
        }else if (!this.tokensList.get(this.i - 2).getLexema().equals(";")) {
                this.Add_Error(tokens.getline()-2);
        }
    }
    
    public void TypeDeclaration()
    {
        if (this.tokens.getLexema().toLowerCase().equals("integer")) {
            for (int j = 0; j < this.tokensListAux.size(); j++) {
                this.simbolsList.get(this.tokensListAux.get(j).getlocat()).settype("Integer");
            }
        } else {
            this.Add_Error(tokens.getline());
        }      
        this.lexi();
        this.tokensListAux.clear();
    }
    
    
    public String getEmsg() {
        return this.errorMessageText;
    }

    
    public void lexi() {
        if (this.i < this.tokensList.size()) {
            this.i++;
            this.tokens = this.tokensList.get(i - 1);
        } else {
            this.Add_Error(tokens.getline());
            return;
        }
    }

    public ArrayList<Simbols> getSimbols() {
        return new ArrayList<Simbols>(this.simbolsList);
    }
    
    public void Add_Error(int el)
    {
        if(!(this.errorMessageText.contains(String.valueOf(el)))){
            if((this.errorMessageText.contains("Error")))
            {
                this.errorMessageText +=", " + el;
            }
            else{
                this.errorMessageText += "Error " + el;
            }            
        }
    }  
    
    public void verifyError()
    {
        if(!(this.errorMessageText.contains("Error")))
        {
            this.errorMessageText += "Sucess!";
        }
        else
        {
            this.errorMessageText += ".";
        }
    }
}