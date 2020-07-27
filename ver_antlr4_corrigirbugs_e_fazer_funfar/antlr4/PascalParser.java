package antlr4;

// Generated from Pascal.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.TreeSet;
import model.Registro;
import model.TabelaSimbolos;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
    
    private List<Token> tokens;
    private TreeSet<Registro> tabelaSimbolos;
    private ArrayList<Registro> simbolosParaAdd;
    private int endereco;
    private int id;
    private boolean erro;
    private String msgErro;

    //Variáveis do novo trabalho
    int nivel;
    int offsetParametro;
    ArrayList<TabelaSimbolos> listaTabelasSimbolos;
    String secaoCabecalhoAssembly;
    String secaoCorpoAssembly;
    String secaoDataAssembly;
    int contadorStrings;
    int contRotuloFalso;
    int contRotuloFim;
    int contRotuloElse;
    int contRotuloFor;
    int contRotuloVerdade;
    int contRotuloSaida;
    int contRotuloAtribuiFalso;
    int contRotuloRepeat;
    int contRoutuloWhile;
    int contArgumentos;
    boolean writeln;

    public PascalParser(List<Token> tokens) {
        this.tokens = tokens;
        this.tabelaSimbolos = new TreeSet<>();
        this.listaTabelasSimbolos = new ArrayList<>();
        this.secaoCabecalhoAssembly = "";
        this.secaoCorpoAssembly = "";
        this.secaoDataAssembly = "section .data\n";
        this.contadorStrings = 0;
        this.contadorStrings = 0;
        this.contRotuloFalso = 0;
        this.contRotuloFim = 0;
        this.contRotuloElse = 0;
        this.contRotuloFor = 0;
        this.contRotuloVerdade = 0;
        this.contRotuloSaida = 0;
        this.contRotuloAtribuiFalso = 0;
        this.contRotuloRepeat = 0;
        this.contRoutuloWhile = 0;
        this.contArgumentos = 0;
        this.writeln = false;
    }

    // metodos de acoes

public void A01() {
        //AÇÃO {A01();}
        TabelaSimbolos tabela = new TabelaSimbolos();
        tabela.setTabelaSimbolosPai(null);
        this.nivel = 0;
        //lexema, categoria, nivel, offset, numeroParametros, rotulo, tabelaSimbolos
        tabela.addSimbolo(token.getLexema(), "Program", nivel, 0, 0, "_main", tabela);
        this.listaTabelasSimbolos.add(tabela);
        this.secaoCabecalhoAssembly = "global _main\n"
                + "extern _printf\n"
                + "extern _putchar\n"
                + "extern _scanf\n"
                + "section .text\n\n";

        //FIM DA AÇÃO {A01();}
    }

    public void A02() {
        // menosprezada

    }

    public void A03() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        boolean existe = tabela.verificarSimboloExistenteTabelaAtual(token.getLexema(), "Variável");

        if (existe) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Variável declara anteriormente;");
            this.erro = true;
            return;
        }
        tabela.incrementaOffSetVariavel(-4);
        tabela.addSimbolo(token.getLexema(), "Variável", nivel, tabela.getOffsetVariavel(), 0, "", tabela);
    }

    public void A04() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaProcedimento(tabela, token.getLexema());
        if (simbolo != null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Procedimento já declarada anteriormente");
            this.erro = true;
            return;
        }
        this.nivel++;
        TabelaSimbolos novaTabela = new TabelaSimbolos();
        this.listaTabelasSimbolos.add(novaTabela);
        // é inserido na tabela nova e na antiga
        tabela.addSimbolo(token.getLexema(), "Procedimento", this.nivel, 0, 0, "_" + token.getLexema(), novaTabela);
        novaTabela.setTabelaSimbolosPai(tabela);
        novaTabela.addSimbolo(token.getLexema(), "Procedimento", this.nivel, 0, 0, "_" + token.getLexema(), novaTabela);
    }

    public void A05() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        simbolo = tabela.buscaFuncao(tabela, token.getLexema());
        if (simbolo != null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Função já declarada anteriormente");
            this.erro = true;
            return;
        }
        this.nivel++;
        TabelaSimbolos novaTabela = new TabelaSimbolos();
        this.listaTabelasSimbolos.add(novaTabela);
        // é inserido na tabela nova e na antiga
        tabela.addSimbolo(token.getLexema(), "Função", this.nivel, 0, 0, "_" + token.getLexema(), novaTabela);
        novaTabela.setTabelaSimbolosPai(tabela);
        novaTabela.addSimbolo(token.getLexema(), "Função", this.nivel, 0, 0, "_" + token.getLexema(), novaTabela);
    }

    public void A06() {
        // menosprezada

    }

    public void A07() {
        //AÇÃO {A07();}
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        boolean existe = tabela.verificarSimboloExistenteTabelaAtual(token.getLexema(), "Parâmetro");
        if (existe) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Parâmetro já declarado anteriormente;");
            this.erro = true;
            return;
        }
        /*Verificar se está correto*/
        tabela.incrementaOffSetVariavel(-4);
        tabela.addSimbolo(token.getLexema(), "Parâmetro", this.nivel, tabela.getOffsetVariavel(), 0, "", tabela);
    }

    public void A08() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
        if (simbolo == null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Variável não declarada");
            this.erro = true;
            return;
        }

        if (simbolo.getNivel() != this.nivel) {
            this.secaoCorpoAssembly += "push ebp \n"
                    + "push dword [_@DSP + " + (simbolo.getNivel() * 4) + "] \n"
                    + "mov ebp, esp \n";
        }
        this.secaoCorpoAssembly += "mov edx, ebp \n"
                + "lea eax, [edx + " + simbolo.getOffset() + "] \n"
                + "push eax \n"
                + "push _@Integer \n"
                + "call _scanf \n"
                + "add esp, 8 \n";

        if (simbolo.getNivel() != this.nivel) {
            this.secaoCorpoAssembly += "mov esp, ebp\n"
                    + "pop dword [_@DSP + " + (simbolo.getNivel() * 4) + "]\n"
                    + "pop ebp\n";
        }
        this.secaoDataAssembly += "_@Integer: db '%d',0 \n";
    }

    public void A09() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
        if (simbolo == null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Variável não declarada");
            this.erro = true;
            return;
        }
        this.contadorStrings++;
        this.secaoDataAssembly += "_@STR" + this.contadorStrings + ": db '%d',";
        if (this.writeln) {
            this.secaoDataAssembly += "10, 0 \n";
            this.writeln = false;
        } else {
            this.secaoDataAssembly += "0 \n";
        }
        this.secaoCorpoAssembly += "mov dword[_@DSP +" + simbolo.getNivel() * 4 + " ], ebp\n"
                + "push dword[ebp + (" + simbolo.getOffset() + ") ]\n"
                + "push _@STR" + this.contadorStrings + "\n"
                + "call _printf\n"
                + "add esp, 8\n";
    }

    public void A10() {
//         // nao existe
    }

    public void A11() {
        //Desempilhando o resultado de avaliação que está no topo da pilha
        this.secaoCorpoAssembly += "pop eax \n";
        if (simbolo.getNivel() != this.nivel) {
            //Seguindo para o nível da variável
            this.secaoCorpoAssembly += "push ebp \n"
                    + "push dword [_@DSP + " + (simbolo.getNivel() * 4) + "] \n"
                    + "mov ebp, esp \n"
                    + "mov dword [EBP + " + simbolo.getOffset() + "], eax \n"
                    + "mov esp, ebp\n"
                    + "pop dword [_@DSP + " + (simbolo.getNivel() * 4) + "]\n"
                    + "pop ebp\n";
        } else {
            this.secaoCorpoAssembly += "mov dword [EBP + " + simbolo.getOffset() + "], eax \n";
        }
        this.secaoCorpoAssembly += "rotuloFor" + this.contRotuloFor + ": \n";
    }

    public void A12() {
        //Desempilhando o resultado de expressão
        this.secaoCorpoAssembly += "pop eax \n";
        if (simbolo.getNivel() != this.nivel) {
            //Seguindo para o nível da variável
            this.secaoCorpoAssembly += "push ebp \n"
                    + "push dword [_@DSP + " + (simbolo.getNivel() * 4) + "] \n"
                    + "mov ebp, esp \n"
                    + "cmp dword [EBP + " + simbolo.getOffset() + "], eax  \n"
                    + "mov esp, ebp\n"
                    + "pop dword [_@DSP + " + (simbolo.getNivel() * 4) + "]\n"
                    + "pop ebp\n"
                    + "jg rotuloFim" + this.contRotuloFim + " \n";

        } else {
            this.secaoCorpoAssembly += "cmp dword [EBP + " + simbolo.getOffset() + "], eax \n"
                    + "jg rotuloFim" + this.contRotuloFim + " \n";
        }
    }

    public void A13() {
        if (simbolo.getNivel() != this.nivel) {
            //Seguindo para o nível da variável
            this.secaoCorpoAssembly += "push ebp \n"
                    + "push dword [_@DSP + " + (simbolo.getNivel() * 4) + "] \n"
                    + "mov ebp, esp \n"
                    + "add dword [EBP + " + simbolo.getOffset() + "], 1  \n"
                    + "mov esp, ebp\n"
                    + "pop dword [_@DSP + " + (simbolo.getNivel() * 4) + "]\n"
                    + "pop ebp\n";
        } else {
            this.secaoCorpoAssembly += "add dword [EBP + " + simbolo.getOffset() + "], 1 \n";
        }
        this.secaoCorpoAssembly += "jmp rotuloFor" + this.contRotuloFor++ + " \n";
        this.secaoCorpoAssembly += "rotuloFim" + this.contRotuloFim++ + ": \n";
    }

    public void A14() {
        this.secaoCorpoAssembly += "rotuloRepeat" + this.contRotuloRepeat + ": \n";
    }

    public void A15() {
        this.secaoCorpoAssembly += "pop eax \n"
                + "cmp eax, 1 \n"
                + "jne rotuloRepeat" + this.contRotuloRepeat++ + " \n";
    }

    public void A16() {
        this.secaoCorpoAssembly += "rotuloWhile" + this.contRoutuloWhile + ": \n";

    }

    public void A17() {
        this.secaoCorpoAssembly += "pop eax \n"
                + "cmp eax, 1 \n"
                + "jne rotuloFim" + this.contRotuloFim + " \n";

    }

    public void A18() {
        this.secaoCorpoAssembly += "jmp rotuloWhile" + this.contRoutuloWhile++ + " \n"
                + "rotuloFim" + this.contRotuloFim++ + ":\n";
    }

    public void A19() {
        //NÃO SEI SE ESTAR CERTO * BUSCAR NO TEMPO DA PILHA E COMPARAR SE É VERDADEIRO OU FALSO
        this.secaoCorpoAssembly += "pop eax \n"
                + "cmp eax, 1 \n"
                + "jne rotuloElse" + this.contRotuloElse + " \n";
    }

    public void A20() {
        this.secaoCorpoAssembly += "jmp rotuloFim" + this.contRotuloFim + " \n";

    }

    public void A21() {
        this.secaoCorpoAssembly += "rotuloFim" + this.contRotuloFim++ + ": \n";

    }

    public void A22() {
        tabela = listaTabelasSimbolos.get(nivel);
        //int offset = tabela.getOffsetVariavel();
        int offset = simbolo.getOffset();
        this.secaoCorpoAssembly += "pop dword[ebp + (" + offset + ")] \n";
    }

    public void A23() {
        tabela = this.listaTabelasSimbolos.get(nivel);
        simbolo = tabela.getElementoTabelaSimbolosAtual(token.getLexema(), "Procedimento");
        if (simbolo.getNumeroParametros() == this.contArgumentos) {
            this.secaoCorpoAssembly += "call " + simbolo.getRotulo() + "\n"
                    + "add esp, " + simbolo.getNumeroParametros() * 4 + " \n";
        } else {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Número de argumentos inválido");
            this.erro = true;
            return;
        }
        this.contArgumentos = 0;
    }

    public void A24() {
        // NAO EXISTE
    }

    public void A25() {
        this.secaoCorpoAssembly += "rotuloElse" + this.contRotuloElse++ + ": \n";

    }

    public void A26() {
        this.secaoCorpoAssembly += "cmp dword [ESP + 4], 1 \n"
                + "je rotVerdade" + this.contRotuloVerdade + " \n"
                + "cmp dword [ESP], 1\n"
                + "je rotVerdade" + this.contRotuloVerdade + " \n"
                + "mov dword [ESP + 4], 0 \n"
                + "jmp rotSaida" + this.contRotuloSaida + " \n"
                + "rotVerdade" + this.contRotuloVerdade++ + ": \n"
                + "mov dword [ESP + 4], 1 \n"
                + "rotSaida" + this.contRotuloSaida++ + ": \n"
                + "add esp, 4 \n";
    }

    public void A27() {
        this.secaoCorpoAssembly += "cmp dword [ESP + 4], 1 \n"
                + "jne rotAtribuiFalso" + this.contRotuloAtribuiFalso + " \n"
                + "cmp dword [ESP], 1 \n"
                + "je rotVerdade" + this.contRotuloVerdade + " \n"
                + "rotAtribuiFalso" + this.contRotuloAtribuiFalso++ + ": \n"
                + "mov dword [ESP + 4], 0 \n"
                + "jmp rotSaida" + this.contRotuloSaida + " \n"
                + "rotVerdade" + this.contRotuloVerdade++ + ": \n"
                + "mov dword [ESP + 4], 1 \n"
                + "rotSaida" + this.contRotuloSaida++ + ": \n"
    }

    public void A28() {
        this.secaoCorpoAssembly += "cmp dword [ESP], 1 \n"
                + "jne Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 0 \n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 1 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A29() {
        this.secaoCorpoAssembly += "push 1 \n";
    }

    public void A30() {
        this.secaoCorpoAssembly += "push 0 \n";
    }

    public void A31() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jne Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A32() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jng Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A33() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnge Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A34() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnl Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A35() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnle Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A36() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "je Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A37() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "add dword[ESP], eax\n";
    }

    public void A38() {
        this.secaoCorpoAssembly += "pop eax\n"
                + "sub dword[ESP], eax\n";
    }

    public void A39() {
        this.secaoCorpoAssembly += "pop eax \n"
                + "imul eax, dword [ESP] \n"
                + "mov dword [ESP], eax \n";
    }

    public void A40() {
        this.secaoCorpoAssembly += "pop ecx \n"
                + "pop eax \n"
                + "idiv ecx \n"
                + "push eax \n";
    }

    public void A41() {
        this.secaoCorpoAssembly += "push " + token.getLexema() + " \n";

    }

    public void A42() {
        //Verificar numero de argumentos
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Registro simbolo = tabela.getElementoTabelaSimbolosAtual(token.getLexema(), "Função");

        if (simbolo == null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Função não declarada");
            this.erro = true;
            return;
        }

        if (simbolo.getNumeroParametros() == this.contArgumentos) {
            this.secaoCorpoAssembly += "call " + simbolo.getRotulo() + "\n"
                    + "add esp, " + simbolo.getNumeroParametros() * 4 + " \n";
        } else {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Número de argumentos inválido");
            this.erro = true;
            return;
        }
        this.contArgumentos = 0;
    }

    public void A43() {
        // NAO EXISTE
    }

    public void A44() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Iterator<Simbolo> it = tabela.getSimbolos().descendingIterator();
        //Simbolo com o marcador de início da função 
        Simbolo simbolo = (Simbolo) it.next();
        String rotulo = simbolo.getRotulo();
        this.secaoCorpoAssembly += rotulo + ":\n";
        //Gerar a instrução para empilhar o conteúdo do registrador EBP.
        this.secaoCorpoAssembly += "push ebp\n"
                + "push dword [_@DSP + (" + nivel * 4 + ")]\n"
                + "mov ebp, esp\n";
        //Gerar a instrução para armazenar o conteúdo do registrador EBP no display do nível
        this.secaoCorpoAssembly += "mov [_@DSP + " + nivel * 4 + "], ebp\n";
        //Gerar instrução para alocar espaço para as variáveis na pilha. 
        this.secaoCorpoAssembly += "sub esp, " + tabela.getEspacoVariaveisLocais() + "\n";
    }

    public void A45() {
        this.secaoDataAssembly += "_@DSP: times " + this.listaTabelasSimbolos.size() * 4 + " db 0";

    }

    public void A46() {
        this.secaoCorpoAssembly += "add esp, " + tabela.getEspacoVariaveisLocais() + "\n"
                + "mov esp, ebp\n"
                + "pop dword [_@DSP + " + simbolo.getNivel() * 4 + "]\n"
                + "pop ebp\n"
                + "ret\n";
    }

    public void A47() {
        // menosprezada
    }

    public void A48() {
        tabela = this.listaTabelasSimbolos.get(nivel);
        tabela.atualizarNumeroParametros();
        tabela.calculaOffsetParametros();
    }

    public void A49() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Registro simbolo = tabela.buscaProcedimento(tabela, token.getLexema());

        if (simbolo == null) {
            tabela = this.listaTabelasSimbolos.get(nivel);
            simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
            if (simbolo == null) {
                simbolo = tabela.getElementoTabelaSimbolosAtual(token.getLexema(), "Função");
                if (simbolo == null) {
                    this.msgErro = String.format("Erro: \n(%03d) - %s",
                            token.getLinha(), "Variável ou função não declarada");
                    this.erro = true;
                    return;
                } else if (simbolo.getNivel() != this.nivel) {
                    this.msgErro = String.format("Erro: \n(%03d) - %s",
                            token.getLinha(), "A função não está no nível corrente");
                    this.erro = true;
                    return;
                }
            }
        }
    }

    public void A50() {
        this.id--;
        token = this.getProximoToken();
        tabela = this.listaTabelasSimbolos.get(nivel);
        simbolo = tabela.buscaProcedimento(tabela, token.getLexema());
        if (simbolo == null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Procedimento não declarado");
            this.erro = true;
            return;
        }
    }

    public void A51() {

    }

    public void A52() {

    }

    public void A53() {

    }

    public void A54() {

    }

    public void A55() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
        this.secaoCorpoAssembly += "push dword [EBP + (" + simbolo.getOffset() + ")] \n";
    }

    public void A56() {
        this.nivel--;

    }

    public void A57() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
        if (simbolo == null) {
            this.msgErro = String.format("Erro: \n(%03d) - %s",
                    token.getLinha(), "Variável não declarada");
            this.erro = true;
        }
    }

    public void A58() {
        TabelaSimbolos tabela = this.listaTabelasSimbolos.get(nivel);
        Simbolo simbolo = tabela.buscaProcedimento(tabela, token.getLexema());

        if (simbolo == null) {
            tabela = this.listaTabelasSimbolos.get(nivel);
            simbolo = tabela.buscaVariavelOuParametro(tabela, token.getLexema());
            if (simbolo == null) {
                simbolo = tabela.getElementoTabelaSimbolosAtual(token.getLexema(), "Função");
                if (simbolo == null) {
                    this.msgErro = String.format("Erro: \n(%03d) - %s",
                            token.getLinha(), "Variável ou função não declarada");
                    this.erro = true;
                    return;
                } else if (simbolo.getNivel() != this.nivel) {
                    this.msgErro = String.format("Erro: \n(%03d) - %s",
                            token.getLinha(), "A função não está no nível corrente");
                    this.erro = true;
                    return;
                }
            }
        }
    }

    public void A59() {
        this.contadorStrings++;
        this.secaoDataAssembly += "_@STR" + this.contadorStrings + ": db '" + token.getLexema() + "',";
        if (this.writeln) {
            this.secaoDataAssembly += "10 , 0 \n";
            this.writeln = false;
        } else {
            this.secaoDataAssembly += "0 \n";
        }
        this.secaoCorpoAssembly += "push _@STR" + this.contadorStrings + "\n"
                + "call _printf\n"
                + "add esp, 4\n";
    }

    public void A60() {

    }

    public void A61() {

    }
    
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PROGRAM=8, BEGIN=9, 
		END=10, VAR=11, INTEGER=12, PROCEDURE=13, FUNCTION=14, READ=15, WRITE=16, 
		WRITELN=17, FOR=18, TO=19, DO=20, REPEAT=21, UNTIL=22, WHILE=23, IF=24, 
		THEN=25, ELSE=26, NOT=27, TRUE=28, FALSE=29, AND=30, OR=31, EQ=32, GT=33, 
		GE=34, LT=35, LE=36, NE=37, MUL=38, DIV=39, ADD=40, SUB=41, ID=42, INT=43, 
		STRING=44, WS=45, COMMENT=46, LCOMMENT=47;
	public static final int
		RULE_principal = 0, RULE_programa = 1, RULE_corpo = 2, RULE_bloco = 3, 
		RULE_declara = 4, RULE_dvar = 5, RULE_tipo = 6, RULE_variaveis = 7, RULE_rotina = 8, 
		RULE_procedimento = 9, RULE_funcao = 10, RULE_parametros = 11, RULE_lista_parametros = 12, 
		RULE_lista_id = 13, RULE_var_read = 14, RULE_exp_write = 15, RULE_sentenca = 16, 
		RULE_comando = 17, RULE_argumentos = 18, RULE_pfalsa = 19, RULE_expressao_logica = 20, 
		RULE_termo_logico = 21, RULE_fator_logico = 22, RULE_relacional = 23, 
		RULE_expressao = 24, RULE_termo = 25, RULE_fator = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"principal", "programa", "corpo", "bloco", "declara", "dvar", "tipo", 
			"variaveis", "rotina", "procedimento", "funcao", "parametros", "lista_parametros", 
			"lista_id", "var_read", "exp_write", "sentenca", "comando", "argumentos", 
			"pfalsa", "expressao_logica", "termo_logico", "fator_logico", "relacional", 
			"expressao", "termo", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "':'", "','", "'('", "')'", "':='", "'program'", 
			"'begin'", "'end'", "'var'", "'integer'", "'procedure'", "'function'", 
			"'read'", "'write'", "'writeln'", "'for'", "'to'", "'do'", "'repeat'", 
			"'until'", "'while'", "'if'", "'then'", "'else'", "'not'", "'true'", 
			"'false'", "'and'", "'or'", "'='", "'>'", "'>='", "'<'", "'<='", "'<>'", 
			"'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PROGRAM", "BEGIN", "END", 
			"VAR", "INTEGER", "PROCEDURE", "FUNCTION", "READ", "WRITE", "WRITELN", 
			"FOR", "TO", "DO", "REPEAT", "UNTIL", "WHILE", "IF", "THEN", "ELSE", 
			"NOT", "TRUE", "FALSE", "AND", "OR", "EQ", "GT", "GE", "LT", "LE", "NE", 
			"MUL", "DIV", "ADD", "SUB", "ID", "INT", "STRING", "WS", "COMMENT", "LCOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PrincipalContext extends ParserRuleContext {
		public PrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_principal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPrincipal(this);
		}
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(PascalParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(PROGRAM);
			setState(57);
			match(ID);
			A01();
			setState(59);
			match(T__0);
			setState(60);
			corpo();
			setState(61);
			match(T__1);
			A45();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public List<RotinaContext> rotina() {
			return getRuleContexts(RotinaContext.class);
		}
		public RotinaContext rotina(int i) {
			return getRuleContext(RotinaContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCorpo(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(64);
				declara();
				}
			}

			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE || _la==FUNCTION) {
				{
				{
				setState(67);
				rotina();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			A44();
			setState(74);
			bloco();
			A46();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(PascalParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public List<SentencaContext> sentenca() {
			return getRuleContexts(SentencaContext.class);
		}
		public SentencaContext sentenca(int i) {
			return getRuleContext(SentencaContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(BEGIN);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << WRITE) | (1L << WRITELN) | (1L << FOR) | (1L << REPEAT) | (1L << WHILE) | (1L << IF) | (1L << ID))) != 0)) {
				{
				{
				setState(78);
				sentenca();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PascalParser.VAR, 0); }
		public List<DvarContext> dvar() {
			return getRuleContexts(DvarContext.class);
		}
		public DvarContext dvar(int i) {
			return getRuleContext(DvarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(VAR);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				dvar();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DvarContext extends ParserRuleContext {
		public VariaveisContext variaveis() {
			return getRuleContext(VariaveisContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterDvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitDvar(this);
		}
	}

	public final DvarContext dvar() throws RecognitionException {
		DvarContext _localctx = new DvarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			variaveis(0);
			setState(93);
			match(T__2);
			setState(94);
			tipo();
			A02();
			setState(96);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariaveisContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public VariaveisContext variaveis() {
			return getRuleContext(VariaveisContext.class,0);
		}
		public VariaveisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variaveis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariaveis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariaveis(this);
		}
	}

	public final VariaveisContext variaveis() throws RecognitionException {
		return variaveis(0);
	}

	private VariaveisContext variaveis(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariaveisContext _localctx = new VariaveisContext(_ctx, _parentState);
		VariaveisContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_variaveis, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(101);
			match(ID);
			A03();
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariaveisContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variaveis);
					setState(104);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(105);
					match(T__3);
					setState(106);
					match(ID);
					A03();
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RotinaContext extends ParserRuleContext {
		public ProcedimentoContext procedimento() {
			return getRuleContext(ProcedimentoContext.class,0);
		}
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public RotinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRotina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRotina(this);
		}
	}

	public final RotinaContext rotina() throws RecognitionException {
		RotinaContext _localctx = new RotinaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rotina);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				procedimento();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				funcao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedimentoContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public ProcedimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedimento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedimento(this);
		}
	}

	public final ProcedimentoContext procedimento() throws RecognitionException {
		ProcedimentoContext _localctx = new ProcedimentoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_procedimento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(PROCEDURE);
			setState(118);
			match(ID);
			A04();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(120);
				parametros();
				}
			}

			A48();
			setState(124);
			match(T__0);
			setState(125);
			corpo();
			A56();
			setState(127);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncaoContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFuncao(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(FUNCTION);
			setState(130);
			match(ID);
			A05();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(132);
				parametros();
				}
			}

			A48();
			setState(136);
			match(T__2);
			setState(137);
			tipo();
			A47();
			setState(139);
			match(T__0);
			setState(140);
			corpo();
			A56();
			setState(142);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<Lista_parametrosContext> lista_parametros() {
			return getRuleContexts(Lista_parametrosContext.class);
		}
		public Lista_parametrosContext lista_parametros(int i) {
			return getRuleContext(Lista_parametrosContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitParametros(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__4);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				lista_parametros();
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(150);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_parametrosContext extends ParserRuleContext {
		public Lista_idContext lista_id() {
			return getRuleContext(Lista_idContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Lista_parametrosContext lista_parametros() {
			return getRuleContext(Lista_parametrosContext.class,0);
		}
		public Lista_parametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterLista_parametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitLista_parametros(this);
		}
	}

	public final Lista_parametrosContext lista_parametros() throws RecognitionException {
		Lista_parametrosContext _localctx = new Lista_parametrosContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lista_parametros);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				lista_id(0);
				setState(153);
				match(T__2);
				setState(154);
				tipo();
				A06();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				lista_id(0);
				setState(158);
				match(T__2);
				setState(159);
				tipo();
				A06();
				setState(161);
				match(T__0);
				setState(162);
				lista_parametros();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Lista_idContext lista_id() {
			return getRuleContext(Lista_idContext.class,0);
		}
		public Lista_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterLista_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitLista_id(this);
		}
	}

	public final Lista_idContext lista_id() throws RecognitionException {
		return lista_id(0);
	}

	private Lista_idContext lista_id(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Lista_idContext _localctx = new Lista_idContext(_ctx, _parentState);
		Lista_idContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_lista_id, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(167);
			match(ID);
			A07();
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Lista_idContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lista_id);
					setState(170);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(171);
					match(T__3);
					setState(172);
					match(ID);
					A07();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Var_readContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Var_readContext var_read() {
			return getRuleContext(Var_readContext.class,0);
		}
		public Var_readContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVar_read(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVar_read(this);
		}
	}

	public final Var_readContext var_read() throws RecognitionException {
		return var_read(0);
	}

	private Var_readContext var_read(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_readContext _localctx = new Var_readContext(_ctx, _parentState);
		Var_readContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_var_read, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(180);
			match(ID);
			A08();
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Var_readContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_var_read);
					setState(183);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(184);
					match(T__3);
					setState(185);
					match(ID);
					A08();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp_writeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Exp_writeContext exp_write() {
			return getRuleContext(Exp_writeContext.class,0);
		}
		public Exp_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExp_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExp_write(this);
		}
	}

	public final Exp_writeContext exp_write() throws RecognitionException {
		return exp_write(0);
	}

	private Exp_writeContext exp_write(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp_writeContext _localctx = new Exp_writeContext(_ctx, _parentState);
		Exp_writeContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_exp_write, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(193);
				match(STRING);
				A59();
				}
				break;
			case ID:
				{
				setState(195);
				match(ID);
				A09();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Exp_writeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp_write);
						setState(199);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(200);
						match(T__3);
						setState(201);
						match(STRING);
						A59();
						}
						break;
					case 2:
						{
						_localctx = new Exp_writeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp_write);
						setState(203);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(204);
						match(T__3);
						setState(205);
						match(ID);
						A09();
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SentencaContext extends ParserRuleContext {
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public SentencaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSentenca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSentenca(this);
		}
	}

	public final SentencaContext sentenca() throws RecognitionException {
		SentencaContext _localctx = new SentencaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentenca);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			comando();
			setState(213);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(PascalParser.READ, 0); }
		public Var_readContext var_read() {
			return getRuleContext(Var_readContext.class,0);
		}
		public TerminalNode WRITE() { return getToken(PascalParser.WRITE, 0); }
		public Exp_writeContext exp_write() {
			return getRuleContext(Exp_writeContext.class,0);
		}
		public TerminalNode WRITELN() { return getToken(PascalParser.WRITELN, 0); }
		public TerminalNode FOR() { return getToken(PascalParser.FOR, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode TO() { return getToken(PascalParser.TO, 0); }
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode REPEAT() { return getToken(PascalParser.REPEAT, 0); }
		public SentencaContext sentenca() {
			return getRuleContext(SentencaContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(PascalParser.UNTIL, 0); }
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(PascalParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(PascalParser.IF, 0); }
		public TerminalNode THEN() { return getToken(PascalParser.THEN, 0); }
		public PfalsaContext pfalsa() {
			return getRuleContext(PfalsaContext.class,0);
		}
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comando);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(READ);
				setState(216);
				match(T__4);
				setState(217);
				var_read(0);
				setState(218);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(WRITE);
				setState(221);
				match(T__4);
				setState(222);
				exp_write(0);
				setState(223);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				match(WRITELN);
				setState(226);
				match(T__4);
				setState(227);
				exp_write(0);
				setState(228);
				match(T__5);
				A61();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				match(FOR);
				setState(232);
				match(ID);
				A57();
				setState(234);
				match(T__6);
				setState(235);
				expressao(0);
				A11();
				setState(237);
				match(TO);
				setState(238);
				expressao(0);
				A12();
				setState(240);
				match(DO);
				setState(241);
				bloco();
				A13();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				match(REPEAT);
				A14();
				setState(246);
				sentenca();
				setState(247);
				match(UNTIL);
				setState(248);
				expressao_logica(0);
				A15();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				match(WHILE);
				A16();
				setState(253);
				expressao_logica(0);
				A17();
				setState(255);
				match(DO);
				setState(256);
				bloco();
				A18();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(259);
				match(IF);
				setState(260);
				expressao_logica(0);
				A19();
				setState(262);
				match(THEN);
				setState(263);
				bloco();
				A20();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(265);
					pfalsa();
					}
				}

				A21();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(270);
				match(ID);
				A49();
				setState(272);
				match(T__6);
				setState(273);
				expressao(0);
				A22();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(276);
				match(ID);
				A50();
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(278);
					argumentos();
					}
				}

				A23();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitArgumentos(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__4);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << ID) | (1L << INT))) != 0)) {
				{
				setState(285);
				expressao(0);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(286);
					match(T__3);
					setState(287);
					expressao(0);
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(295);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PfalsaContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PascalParser.ELSE, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public PfalsaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pfalsa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPfalsa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPfalsa(this);
		}
	}

	public final PfalsaContext pfalsa() throws RecognitionException {
		PfalsaContext _localctx = new PfalsaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pfalsa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(ELSE);
			A25();
			setState(299);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao_logicaContext extends ParserRuleContext {
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode OR() { return getToken(PascalParser.OR, 0); }
		public Expressao_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpressao_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpressao_logica(this);
		}
	}

	public final Expressao_logicaContext expressao_logica() throws RecognitionException {
		return expressao_logica(0);
	}

	private Expressao_logicaContext expressao_logica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expressao_logicaContext _localctx = new Expressao_logicaContext(_ctx, _parentState);
		Expressao_logicaContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expressao_logica, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(302);
			termo_logico(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expressao_logicaContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressao_logica);
					setState(304);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(305);
					match(OR);
					setState(306);
					termo_logico(0);
					A26();
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Termo_logicoContext extends ParserRuleContext {
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public TerminalNode AND() { return getToken(PascalParser.AND, 0); }
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTermo_logico(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		return termo_logico(0);
	}

	private Termo_logicoContext termo_logico(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, _parentState);
		Termo_logicoContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_termo_logico, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(315);
			fator_logico();
			}
			_ctx.stop = _input.LT(-1);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Termo_logicoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termo_logico);
					setState(317);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(318);
					match(AND);
					setState(319);
					fator_logico();
					A27();
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Fator_logicoContext extends ParserRuleContext {
		public RelacionalContext relacional() {
			return getRuleContext(RelacionalContext.class,0);
		}
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PascalParser.NOT, 0); }
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(PascalParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PascalParser.FALSE, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFator_logico(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fator_logico);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				relacional();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(T__4);
				setState(329);
				expressao_logica(0);
				setState(330);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				match(NOT);
				setState(333);
				fator_logico();
				A28();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				match(TRUE);
				A29();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				match(FALSE);
				A30();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelacionalContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode EQ() { return getToken(PascalParser.EQ, 0); }
		public TerminalNode GT() { return getToken(PascalParser.GT, 0); }
		public TerminalNode GE() { return getToken(PascalParser.GE, 0); }
		public TerminalNode LT() { return getToken(PascalParser.LT, 0); }
		public TerminalNode LE() { return getToken(PascalParser.LE, 0); }
		public TerminalNode NE() { return getToken(PascalParser.NE, 0); }
		public RelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRelacional(this);
		}
	}

	public final RelacionalContext relacional() throws RecognitionException {
		RelacionalContext _localctx = new RelacionalContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_relacional);
		try {
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				expressao(0);
				setState(343);
				match(EQ);
				setState(344);
				expressao(0);
				A31();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				expressao(0);
				setState(348);
				match(GT);
				setState(349);
				expressao(0);
				A32();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(352);
				expressao(0);
				setState(353);
				match(GE);
				setState(354);
				expressao(0);
				A33();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(357);
				expressao(0);
				setState(358);
				match(LT);
				setState(359);
				expressao(0);
				A34();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(362);
				expressao(0);
				setState(363);
				match(LE);
				setState(364);
				expressao(0);
				A35();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(367);
				expressao(0);
				setState(368);
				match(NE);
				setState(369);
				expressao(0);
				A36();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ADD() { return getToken(PascalParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PascalParser.SUB, 0); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expressao, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(375);
			termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(377);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(378);
						match(ADD);
						setState(379);
						termo(0);
						A37();
						}
						break;
					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(382);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(383);
						match(SUB);
						setState(384);
						termo(0);
						A38();
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode MUL() { return getToken(PascalParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PascalParser.DIV, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		return termo(0);
	}

	private TermoContext termo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoContext _localctx = new TermoContext(_ctx, _parentState);
		TermoContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_termo, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(393);
			fator();
			}
			_ctx.stop = _input.LT(-1);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(405);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(395);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(396);
						match(MUL);
						setState(397);
						fator();
						A39();
						}
						break;
					case 2:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(400);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(401);
						match(DIV);
						setState(402);
						fator();
						A40();
						}
						break;
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fator);
		try {
			setState(423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(ID);
				A55();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(ID);
				A60();
				setState(414);
				argumentos();
				A42();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(417);
				match(INT);
				A41();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(419);
				match(T__4);
				setState(420);
				expressao(0);
				setState(421);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return variaveis_sempred((VariaveisContext)_localctx, predIndex);
		case 13:
			return lista_id_sempred((Lista_idContext)_localctx, predIndex);
		case 14:
			return var_read_sempred((Var_readContext)_localctx, predIndex);
		case 15:
			return exp_write_sempred((Exp_writeContext)_localctx, predIndex);
		case 20:
			return expressao_logica_sempred((Expressao_logicaContext)_localctx, predIndex);
		case 21:
			return termo_logico_sempred((Termo_logicoContext)_localctx, predIndex);
		case 24:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		case 25:
			return termo_sempred((TermoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variaveis_sempred(VariaveisContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lista_id_sempred(Lista_idContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean var_read_sempred(Var_readContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_write_sempred(Exp_writeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressao_logica_sempred(Expressao_logicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_logico_sempred(Termo_logicoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u01ac\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\5\4D\n\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5"+
		"R\n\5\f\5\16\5U\13\5\3\5\3\5\3\6\3\6\6\6[\n\6\r\6\16\6\\\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr"+
		"\13\t\3\n\3\n\5\nv\n\n\3\13\3\13\3\13\3\13\5\13|\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0088\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\6\r\u0095\n\r\r\r\16\r\u0096\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a7\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00b1\n\17\f\17\16\17\u00b4\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00be\n\20\f\20\16\20\u00c1"+
		"\13\20\3\21\3\21\3\21\3\21\3\21\5\21\u00c8\n\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\7\21\u00d2\n\21\f\21\16\21\u00d5\13\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u010d\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u011a\n\23\3\23"+
		"\5\23\u011d\n\23\3\24\3\24\3\24\3\24\7\24\u0123\n\24\f\24\16\24\u0126"+
		"\13\24\5\24\u0128\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\7\26\u0138\n\26\f\26\16\26\u013b\13\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0145\n\27\f\27\16\27\u0148\13"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u0157\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0177\n\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0186\n\32\f\32\16\32\u0189\13"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7"+
		"\33\u0198\n\33\f\33\16\33\u019b\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01aa\n\34\3\34\2\n\20\34\36 *"+
		",\62\64\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"\2\2\2\u01bd\28\3\2\2\2\4:\3\2\2\2\6C\3\2\2\2\bO\3\2\2\2\nX\3\2\2\2\f"+
		"^\3\2\2\2\16d\3\2\2\2\20f\3\2\2\2\22u\3\2\2\2\24w\3\2\2\2\26\u0083\3\2"+
		"\2\2\30\u0092\3\2\2\2\32\u00a6\3\2\2\2\34\u00a8\3\2\2\2\36\u00b5\3\2\2"+
		"\2 \u00c7\3\2\2\2\"\u00d6\3\2\2\2$\u011c\3\2\2\2&\u011e\3\2\2\2(\u012b"+
		"\3\2\2\2*\u012f\3\2\2\2,\u013c\3\2\2\2.\u0156\3\2\2\2\60\u0176\3\2\2\2"+
		"\62\u0178\3\2\2\2\64\u018a\3\2\2\2\66\u01a9\3\2\2\289\b\2\1\29\3\3\2\2"+
		"\2:;\7\n\2\2;<\7,\2\2<=\b\3\1\2=>\7\3\2\2>?\5\6\4\2?@\7\4\2\2@A\b\3\1"+
		"\2A\5\3\2\2\2BD\5\n\6\2CB\3\2\2\2CD\3\2\2\2DH\3\2\2\2EG\5\22\n\2FE\3\2"+
		"\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\b\4\1\2LM\5\b"+
		"\5\2MN\b\4\1\2N\7\3\2\2\2OS\7\13\2\2PR\5\"\22\2QP\3\2\2\2RU\3\2\2\2SQ"+
		"\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\f\2\2W\t\3\2\2\2XZ\7\r\2\2"+
		"Y[\5\f\7\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\13\3\2\2\2^_\5"+
		"\20\t\2_`\7\5\2\2`a\5\16\b\2ab\b\7\1\2bc\7\3\2\2c\r\3\2\2\2de\7\16\2\2"+
		"e\17\3\2\2\2fg\b\t\1\2gh\7,\2\2hi\b\t\1\2ip\3\2\2\2jk\f\4\2\2kl\7\6\2"+
		"\2lm\7,\2\2mo\b\t\1\2nj\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\21\3\2"+
		"\2\2rp\3\2\2\2sv\5\24\13\2tv\5\26\f\2us\3\2\2\2ut\3\2\2\2v\23\3\2\2\2"+
		"wx\7\17\2\2xy\7,\2\2y{\b\13\1\2z|\5\30\r\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2"+
		"\2}~\b\13\1\2~\177\7\3\2\2\177\u0080\5\6\4\2\u0080\u0081\b\13\1\2\u0081"+
		"\u0082\7\3\2\2\u0082\25\3\2\2\2\u0083\u0084\7\20\2\2\u0084\u0085\7,\2"+
		"\2\u0085\u0087\b\f\1\2\u0086\u0088\5\30\r\2\u0087\u0086\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\f\1\2\u008a\u008b\7\5"+
		"\2\2\u008b\u008c\5\16\b\2\u008c\u008d\b\f\1\2\u008d\u008e\7\3\2\2\u008e"+
		"\u008f\5\6\4\2\u008f\u0090\b\f\1\2\u0090\u0091\7\3\2\2\u0091\27\3\2\2"+
		"\2\u0092\u0094\7\7\2\2\u0093\u0095\5\32\16\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7\b\2\2\u0099\31\3\2\2\2\u009a\u009b\5\34\17\2\u009b"+
		"\u009c\7\5\2\2\u009c\u009d\5\16\b\2\u009d\u009e\b\16\1\2\u009e\u00a7\3"+
		"\2\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\5\16\b\2"+
		"\u00a2\u00a3\b\16\1\2\u00a3\u00a4\7\3\2\2\u00a4\u00a5\5\32\16\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u009a\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\33\3\2\2"+
		"\2\u00a8\u00a9\b\17\1\2\u00a9\u00aa\7,\2\2\u00aa\u00ab\b\17\1\2\u00ab"+
		"\u00b2\3\2\2\2\u00ac\u00ad\f\4\2\2\u00ad\u00ae\7\6\2\2\u00ae\u00af\7,"+
		"\2\2\u00af\u00b1\b\17\1\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\35\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\u00b6\b\20\1\2\u00b6\u00b7\7,\2\2\u00b7\u00b8\b\20\1\2\u00b8"+
		"\u00bf\3\2\2\2\u00b9\u00ba\f\4\2\2\u00ba\u00bb\7\6\2\2\u00bb\u00bc\7,"+
		"\2\2\u00bc\u00be\b\20\1\2\u00bd\u00b9\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\37\3\2\2\2\u00c1\u00bf\3\2\2"+
		"\2\u00c2\u00c3\b\21\1\2\u00c3\u00c4\7.\2\2\u00c4\u00c8\b\21\1\2\u00c5"+
		"\u00c6\7,\2\2\u00c6\u00c8\b\21\1\2\u00c7\u00c2\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c8\u00d3\3\2\2\2\u00c9\u00ca\f\6\2\2\u00ca\u00cb\7\6\2\2\u00cb"+
		"\u00cc\7.\2\2\u00cc\u00d2\b\21\1\2\u00cd\u00ce\f\4\2\2\u00ce\u00cf\7\6"+
		"\2\2\u00cf\u00d0\7,\2\2\u00d0\u00d2\b\21\1\2\u00d1\u00c9\3\2\2\2\u00d1"+
		"\u00cd\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4!\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\5$\23\2\u00d7\u00d8"+
		"\7\3\2\2\u00d8#\3\2\2\2\u00d9\u00da\7\21\2\2\u00da\u00db\7\7\2\2\u00db"+
		"\u00dc\5\36\20\2\u00dc\u00dd\7\b\2\2\u00dd\u011d\3\2\2\2\u00de\u00df\7"+
		"\22\2\2\u00df\u00e0\7\7\2\2\u00e0\u00e1\5 \21\2\u00e1\u00e2\7\b\2\2\u00e2"+
		"\u011d\3\2\2\2\u00e3\u00e4\7\23\2\2\u00e4\u00e5\7\7\2\2\u00e5\u00e6\5"+
		" \21\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\b\23\1\2\u00e8\u011d\3\2\2\2\u00e9"+
		"\u00ea\7\24\2\2\u00ea\u00eb\7,\2\2\u00eb\u00ec\b\23\1\2\u00ec\u00ed\7"+
		"\t\2\2\u00ed\u00ee\5\62\32\2\u00ee\u00ef\b\23\1\2\u00ef\u00f0\7\25\2\2"+
		"\u00f0\u00f1\5\62\32\2\u00f1\u00f2\b\23\1\2\u00f2\u00f3\7\26\2\2\u00f3"+
		"\u00f4\5\b\5\2\u00f4\u00f5\b\23\1\2\u00f5\u011d\3\2\2\2\u00f6\u00f7\7"+
		"\27\2\2\u00f7\u00f8\b\23\1\2\u00f8\u00f9\5\"\22\2\u00f9\u00fa\7\30\2\2"+
		"\u00fa\u00fb\5*\26\2\u00fb\u00fc\b\23\1\2\u00fc\u011d\3\2\2\2\u00fd\u00fe"+
		"\7\31\2\2\u00fe\u00ff\b\23\1\2\u00ff\u0100\5*\26\2\u0100\u0101\b\23\1"+
		"\2\u0101\u0102\7\26\2\2\u0102\u0103\5\b\5\2\u0103\u0104\b\23\1\2\u0104"+
		"\u011d\3\2\2\2\u0105\u0106\7\32\2\2\u0106\u0107\5*\26\2\u0107\u0108\b"+
		"\23\1\2\u0108\u0109\7\33\2\2\u0109\u010a\5\b\5\2\u010a\u010c\b\23\1\2"+
		"\u010b\u010d\5(\25\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u010f\b\23\1\2\u010f\u011d\3\2\2\2\u0110\u0111\7,\2\2\u0111"+
		"\u0112\b\23\1\2\u0112\u0113\7\t\2\2\u0113\u0114\5\62\32\2\u0114\u0115"+
		"\b\23\1\2\u0115\u011d\3\2\2\2\u0116\u0117\7,\2\2\u0117\u0119\b\23\1\2"+
		"\u0118\u011a\5&\24\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011d\b\23\1\2\u011c\u00d9\3\2\2\2\u011c\u00de\3\2\2\2"+
		"\u011c\u00e3\3\2\2\2\u011c\u00e9\3\2\2\2\u011c\u00f6\3\2\2\2\u011c\u00fd"+
		"\3\2\2\2\u011c\u0105\3\2\2\2\u011c\u0110\3\2\2\2\u011c\u0116\3\2\2\2\u011d"+
		"%\3\2\2\2\u011e\u0127\7\7\2\2\u011f\u0124\5\62\32\2\u0120\u0121\7\6\2"+
		"\2\u0121\u0123\5\62\32\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0127\u011f\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\7\b\2\2\u012a\'\3\2\2\2\u012b\u012c\7\34\2\2\u012c\u012d\b\25\1"+
		"\2\u012d\u012e\5\b\5\2\u012e)\3\2\2\2\u012f\u0130\b\26\1\2\u0130\u0131"+
		"\5,\27\2\u0131\u0139\3\2\2\2\u0132\u0133\f\4\2\2\u0133\u0134\7!\2\2\u0134"+
		"\u0135\5,\27\2\u0135\u0136\b\26\1\2\u0136\u0138\3\2\2\2\u0137\u0132\3"+
		"\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"+\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\b\27\1\2\u013d\u013e\5.\30\2"+
		"\u013e\u0146\3\2\2\2\u013f\u0140\f\4\2\2\u0140\u0141\7 \2\2\u0141\u0142"+
		"\5.\30\2\u0142\u0143\b\27\1\2\u0143\u0145\3\2\2\2\u0144\u013f\3\2\2\2"+
		"\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147-\3"+
		"\2\2\2\u0148\u0146\3\2\2\2\u0149\u0157\5\60\31\2\u014a\u014b\7\7\2\2\u014b"+
		"\u014c\5*\26\2\u014c\u014d\7\b\2\2\u014d\u0157\3\2\2\2\u014e\u014f\7\35"+
		"\2\2\u014f\u0150\5.\30\2\u0150\u0151\b\30\1\2\u0151\u0157\3\2\2\2\u0152"+
		"\u0153\7\36\2\2\u0153\u0157\b\30\1\2\u0154\u0155\7\37\2\2\u0155\u0157"+
		"\b\30\1\2\u0156\u0149\3\2\2\2\u0156\u014a\3\2\2\2\u0156\u014e\3\2\2\2"+
		"\u0156\u0152\3\2\2\2\u0156\u0154\3\2\2\2\u0157/\3\2\2\2\u0158\u0159\5"+
		"\62\32\2\u0159\u015a\7\"\2\2\u015a\u015b\5\62\32\2\u015b\u015c\b\31\1"+
		"\2\u015c\u0177\3\2\2\2\u015d\u015e\5\62\32\2\u015e\u015f\7#\2\2\u015f"+
		"\u0160\5\62\32\2\u0160\u0161\b\31\1\2\u0161\u0177\3\2\2\2\u0162\u0163"+
		"\5\62\32\2\u0163\u0164\7$\2\2\u0164\u0165\5\62\32\2\u0165\u0166\b\31\1"+
		"\2\u0166\u0177\3\2\2\2\u0167\u0168\5\62\32\2\u0168\u0169\7%\2\2\u0169"+
		"\u016a\5\62\32\2\u016a\u016b\b\31\1\2\u016b\u0177\3\2\2\2\u016c\u016d"+
		"\5\62\32\2\u016d\u016e\7&\2\2\u016e\u016f\5\62\32\2\u016f\u0170\b\31\1"+
		"\2\u0170\u0177\3\2\2\2\u0171\u0172\5\62\32\2\u0172\u0173\7\'\2\2\u0173"+
		"\u0174\5\62\32\2\u0174\u0175\b\31\1\2\u0175\u0177\3\2\2\2\u0176\u0158"+
		"\3\2\2\2\u0176\u015d\3\2\2\2\u0176\u0162\3\2\2\2\u0176\u0167\3\2\2\2\u0176"+
		"\u016c\3\2\2\2\u0176\u0171\3\2\2\2\u0177\61\3\2\2\2\u0178\u0179\b\32\1"+
		"\2\u0179\u017a\5\64\33\2\u017a\u0187\3\2\2\2\u017b\u017c\f\5\2\2\u017c"+
		"\u017d\7*\2\2\u017d\u017e\5\64\33\2\u017e\u017f\b\32\1\2\u017f\u0186\3"+
		"\2\2\2\u0180\u0181\f\4\2\2\u0181\u0182\7+\2\2\u0182\u0183\5\64\33\2\u0183"+
		"\u0184\b\32\1\2\u0184\u0186\3\2\2\2\u0185\u017b\3\2\2\2\u0185\u0180\3"+
		"\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\63\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\b\33\1\2\u018b\u018c\5\66"+
		"\34\2\u018c\u0199\3\2\2\2\u018d\u018e\f\5\2\2\u018e\u018f\7(\2\2\u018f"+
		"\u0190\5\66\34\2\u0190\u0191\b\33\1\2\u0191\u0198\3\2\2\2\u0192\u0193"+
		"\f\4\2\2\u0193\u0194\7)\2\2\u0194\u0195\5\66\34\2\u0195\u0196\b\33\1\2"+
		"\u0196\u0198\3\2\2\2\u0197\u018d\3\2\2\2\u0197\u0192\3\2\2\2\u0198\u019b"+
		"\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\65\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019c\u019d\7,\2\2\u019d\u01aa\b\34\1\2\u019e\u019f\7,"+
		"\2\2\u019f\u01a0\b\34\1\2\u01a0\u01a1\5&\24\2\u01a1\u01a2\b\34\1\2\u01a2"+
		"\u01aa\3\2\2\2\u01a3\u01a4\7-\2\2\u01a4\u01aa\b\34\1\2\u01a5\u01a6\7\7"+
		"\2\2\u01a6\u01a7\5\62\32\2\u01a7\u01a8\7\b\2\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u019c\3\2\2\2\u01a9\u019e\3\2\2\2\u01a9\u01a3\3\2\2\2\u01a9\u01a5\3\2"+
		"\2\2\u01aa\67\3\2\2\2\37CHS\\pu{\u0087\u0096\u00a6\u00b2\u00bf\u00c7\u00d1"+
		"\u00d3\u010c\u0119\u011c\u0124\u0127\u0139\u0146\u0156\u0176\u0185\u0187"+
		"\u0197\u0199\u01a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}