private List<Token> tokens;
    private TreeSet<Simbolo> tabelaSimbolos;
    private ArrayList<Simbolo> simbolosParaAdd;
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

    public AnalisadorSintatico(List<Token> tokens) {
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
        codigo += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jne Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A32() {
        codigo += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jng Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A33() {
        codigo += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnge Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A34() {
        codigo += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnl Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A35() {
        codigo += "pop eax\n"
                + "cmp dword [ESP], eax \n"
                + "jnle Falso" + this.contRotuloFalso + " \n"
                + "mov dword [ESP], 1\n"
                + "jmp Fim" + this.contRotuloFim + " \n"
                + "Falso" + this.contRotuloFalso++ + ": \n"
                + "mov dword [ESP], 0 \n"
                + "Fim" + this.contRotuloFim++ + ": \n";
    }

    public void A36() {
        codigo += "pop eax\n"
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
        Simbolo simbolo = tabela.getElementoTabelaSimbolosAtual(token.getLexema(), "Função");

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
