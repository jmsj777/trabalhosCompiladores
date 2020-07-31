package acoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.ItemTabela;
import Model.Lexema;
import Model.Registro;
import Model.TabelaSimbolos;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author ze
 */
public class Acoes {

    public RTextScrollPane sp;
    public RSyntaxTextArea fonte;
    int nivel;
    TabelaSimbolos tabelaSimbolos;
    ArrayList<Integer> offsetVariavel = new ArrayList<>();
    ArrayList<String> rotulosData = new ArrayList<>();
    public String codigoAssembly = "";
    public int variaveisLocais;
    Registro registroGlobal;
    int countRotulo = 0;
    int countParametros = 0;
    String currentFuncProc = "";

    int linha = 0;
    int coluna = 0;
    int index = 0;
    int lastLine = 0;
    String texto;
    Lexema lexema;
    Boolean erro = false;
    String errorDescription;
    private ArrayList<String> palavrasReservadas = new ArrayList<>();
    private ArrayList<Lexema> detTipo = new ArrayList<>();
    int contadorRotulos = 0;
    ItemTabela[] table = new ItemTabela[17];

    public Acoes() {
    }

    public static void call(Acoes object, String acao) {
        try {
            object.getClass().getDeclaredMethod(acao).invoke(object);
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {;
        }

    }

    public void insereLinhaArquivo(String linha) {
        codigoAssembly = codigoAssembly + linha + "\n";
    }

    public String geradorRotulo() {
        contadorRotulos++;
        return String.format("@string%d", contadorRotulos);
    }

    public File geraArquivoAsm(){
        File file = new File("./programa.asm");
        try{
            file.createNewFile();
            FileWriter asm = new FileWriter(file);
            asm.write(codigoAssembly); // colocar a string do assembly aqui
            asm.flush();
            asm.close();
        }catch(Exception ex){
        }
        
        return file;
    }

    public void rodaAsm(){
        try{
            String caminho = geraArquivoAsm().getAbsolutePath();
            System.out.print(caminho);
            Runtime.getRuntime().exec("nasm -f win32 ./programa.asm -o ./programa.o");
            Runtime.getRuntime().exec("gcc ./programa.o -o ./prog.exe");
            
            String commando = "cmd /c start cmd.exe /C \"programa\"";
            Runtime.getRuntime().exec(commando);
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void posPrograma() {
        contadorRotulos =0;
        offsetVariavel = new ArrayList(); 
        variaveisLocais=0;
        countRotulo = 0;
         nivel = 0;
         rotulosData = new ArrayList<>();
        //fcodigoAssembly = "";
        //textAreaMensagens.setText("");
        //texto = fonte.getText().toString();
        //jTableTabelaDeSimbolos.removeAll();
        table = null;
        table = new ItemTabela[17];
        //lexema = analisadorLexico(texto);
        //programa();
        //if(!erro)
        //    textAreaMensagens.setText("Compilado com sucesso!\n");
        index = 0;
        linha = 0;
        coluna = 0;
        erro = false;
        //imprimeTabela();
        rodaAsm();
        //textAreaAssembly.setText(codigoAssembly);
    
    }
    public void A01() {
        tabelaSimbolos = new TabelaSimbolos();
        tabelaSimbolos.setTabelaPai(null);
        tabelaSimbolos.setRotulo("_main");
        currentFuncProc = tabelaSimbolos.getRotulo();
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        nivel = 0;
        registro.setNivel(nivel);
        registro.setCategoria("Programa principal");

        offsetVariavel.add(0);
        registro.setOffset(offsetVariavel.get(nivel));
        tabelaSimbolos.addRegistro(registro);
        insereLinhaArquivo("global _main");
        insereLinhaArquivo("\textern _printf");
        insereLinhaArquivo("\textern _putchar");
        insereLinhaArquivo("\textern _scanf");
        insereLinhaArquivo("section .text");
    }

    public void A03() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (!tabelaSimbolos.temRegistro(registro)) {
            registro.setCategoria("Variavel");
            offsetVariavel.set(nivel, offsetVariavel.get(nivel) + 4); //SIZEOF_INT
            registro.setNivel(nivel);
            registro.setOffset(offsetVariavel.get(nivel));
            tabelaSimbolos.addRegistro(registro);
        } else {
            //Erro: identificador já declarado anteriormente
        }
    }

    public void A04() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        registro.setRotulo(lexema.getTexto());
        if (!tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            nivel++;
            registro.setNivel(nivel);
            registro.setCategoria("Procedimento");
            TabelaSimbolos ts = new TabelaSimbolos();
            ts.setTabelaPai(tabelaSimbolos);
            offsetVariavel.add(0);
//            ts.setRotulo(String.format("rotuloProcedimento%d", countRotulo++));
            ts.setRotulo(registro.getNome());
            registro.setTabelaSimbolos(ts);
            tabelaSimbolos.addRegistro(registro);
            tabelaSimbolos = ts;
            currentFuncProc = registro.getNome();
        }
    }

    /*
    public TabelaSimbolos procuraId(TabelaSimbolos tabelaPai){
        TabelaSimbolos resultado = new TabelaSimbolos();
        boolean encontrou = false;
        if(tabelaPai== null){
           resultado = tabelaPai;
        }else{
            for(Registro r: tabelaPai.getRegistros()){
                if(r.getNome().equals(lexema.getTexto())){
                    resultado = tabelaPai;
                    encontrou = true;
                }  
            }
            if (!encontrou){
                resultado = procuraId(tabelaPai.getTabelaPai());
            }
        }
        return resultado;
    }
     */
    public Registro A05() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (!tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            nivel += 1;
            registro.setNivel(nivel);
            registro.setCategoria("Funcao");
            registro.setRotulo(lexema.getTexto());
            TabelaSimbolos novaTs = new TabelaSimbolos();
            novaTs.setTabelaPai(tabelaSimbolos);
            registro.setTabelaSimbolos(novaTs);
            tabelaSimbolos.addRegistro(registro);
//                novaTs.addRegistro(registro);
            tabelaSimbolos = novaTs;
            tabelaSimbolos.addRegistro(registro);
            // Por este motivo, add na acao 56:  tabelaSimbolos = tabelaSimbolos.getTabelaPai();
            offsetVariavel.add(0);
            offsetVariavel.set(nivel, offsetVariavel.get(nivel)); //SIZEOF_INT
            tabelaSimbolos.setRotulo(registro.getNome());
            currentFuncProc = registro.getNome();
        } else {
            //Erro: identificador já declarado anteriormente
            return null;
        }
        return registro;
    }

    public void A07() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (!tabelaSimbolos.temRegistro(registro)) {
            registro.setCategoria("Parametro");
            registro.setNivel(nivel);
            tabelaSimbolos.addRegistro(registro);
        } else {
            //Erro: identificador já declarado anteriormente
        }
    }

    public void A08() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (!tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            //emitir uma mensagem apropriada dizendo que o mesmo ainda não foi declarado.
        } else {
//            for(Registro r: procura.getRegistros()){
//                registro = r;
//            }
            registro = tabelaSimbolos.getEsseRegistro(registro);
            if (registro.getCategoria().equals("Variavel") || registro.getCategoria().equals("Parametro")) {
                insereLinhaArquivo("\tmov edx, ebp");
                insereLinhaArquivo(String.format("\tlea eax, [edx - %d] ", registro.getOffset()));
                insereLinhaArquivo("\tpush eax");
                insereLinhaArquivo("\tpush @INTEGER");
                insereLinhaArquivo("\tcall _scanf");
                insereLinhaArquivo("\tadd esp, 8");

                //gerar funcção de leitura
            } else {
                // ERRO não é variavel nem parametro
            }
        }
    }

    public void A09() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            registro = tabelaSimbolos.getEsseRegistro(registro);
            if (registro.getCategoria().equals("Variavel") || registro.getCategoria().equals("Parametro")) {
                String basePilha = "ebp";
                if (registro.getNivel() != nivel) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", 4 * registro.getNivel()));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s - %d]", basePilha, registro.getOffset()));
                insereLinhaArquivo(String.format("	push dword @INTEGER"));
                insereLinhaArquivo("	call _printf");
                insereLinhaArquivo(String.format("	add esp, 8"));
            } else {
                //Erro: identificador não é uma Variável
            }
        } else {
            //Erro: identificador não foi declarado anteriormente
        }
    }

    public ArrayList<String> A11(Registro ultimoId) {
        if (ultimoId != null) {
            String basePilha = "ebp";
            if (ultimoId.getNivel() != nivel) {
                insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
                basePilha = "ebx";
            }
            insereLinhaArquivo(String.format("	pop dword [%s - %d]", basePilha, ultimoId.getOffset()));
            ArrayList<String> rotulosFor = new ArrayList<>();
            rotulosFor.add(String.format("rotuloInFor%d", countRotulo++));
            rotulosFor.add(String.format("rotuloEndFor%d", countRotulo++));
            insereLinhaArquivo(String.format("%s:", rotulosFor.get(0)));// gerar rotulo _for
            return rotulosFor;
        } else {
            return null;
        }
    }

    public void A12(Registro ultimoId, ArrayList<String> rotulosFor) {
        insereLinhaArquivo(String.format("\tmov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
        insereLinhaArquivo("\tpop eax");
        insereLinhaArquivo(String.format("\tcmp [ebx - %d], eax", ultimoId.getOffset()));
        insereLinhaArquivo(String.format("\tjg %s", rotulosFor.get(1))); // usar rotulo gerado no gerador de rótulos;            
    }

    public void A13(Registro ultimoId, ArrayList<String> rotulosFor) {
        if (ultimoId != null) {
            String basePilha = "ebp";
            if (ultimoId.getNivel() != nivel) {
                insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
                basePilha = "ebx";
            }
            insereLinhaArquivo(String.format("\tadd dword [%s - %d], 1", basePilha, ultimoId.getOffset()));
            insereLinhaArquivo(String.format("\tjmp %s", rotulosFor.get(0)));// jmp rotulo _for
            insereLinhaArquivo(String.format("%s:", rotulosFor.get(1)));// gerar rotulo _fim_for
        }
    }

    public String A14() {
        String rotulo = String.format("rotuloRepeat%d", countRotulo++);//criar rotulor de repetição do repeat
        insereLinhaArquivo(String.format("%s:", rotulo));
        return rotulo;
    }

    public void A15(String rotulo) {
        insereLinhaArquivo(String.format("\tpop eax"));
        insereLinhaArquivo(String.format("\tcmp eax, 0"));
        insereLinhaArquivo(String.format("\tje %s", rotulo));

        // jne rotulo _repeat
    }

    public ArrayList<String> A16() {
        ArrayList<String> rotulosWhile = new ArrayList<>();
        rotulosWhile.add(String.format("rotuloInWhile%d", countRotulo++));//criar rotulo entrada while
        rotulosWhile.add(String.format("rotuloEndWhile%d", countRotulo++));//criar rotulo saida while
        insereLinhaArquivo(String.format("%s:", rotulosWhile.get(0))); // para label while criada acima para entrada
        return rotulosWhile;
    }

    public void A17(ArrayList<String> rotulosWhile) {
        insereLinhaArquivo(String.format("\tpop eax"));
        insereLinhaArquivo(String.format("\tcmp eax, 0"));
        insereLinhaArquivo(String.format("\tje %s", rotulosWhile.get(1)));
    }

    public void A18(ArrayList<String> rotulosWhile) {
        insereLinhaArquivo(String.format("\tjmp %s", rotulosWhile.get(0)));
        insereLinhaArquivo(String.format("%s:", rotulosWhile.get(1)));
    }

    public ArrayList<String> A19() {
        ArrayList<String> rotulos = new ArrayList<>();
        rotulos.add(String.format("rotuloInElse%d", countRotulo++));
        rotulos.add(String.format("rotuloEndIf%d", countRotulo++));
        insereLinhaArquivo("	cmp dword [esp],0");
        insereLinhaArquivo(String.format("	je %s", rotulos.get(0)));
        return rotulos;
    }

    public void A20(ArrayList<String> rotulos) {
        insereLinhaArquivo(String.format("	jmp %s", rotulos.get(1)));
    }

    public void A21(ArrayList<String> rotulos) {
        insereLinhaArquivo(String.format("%s:", rotulos.get(1)));
        // gerar rotulo _fim_if
    }

    public void A22(Registro registro) {
        if (registro.getCategoria().equals("Variavel")) {
            insereLinhaArquivo(String.format("\tmov eax, dword[@DSP+%d]", registro.getNivel() * 4));
            insereLinhaArquivo("\tpop ebx");
            insereLinhaArquivo(String.format("\tmov dword[eax - %d], ebx", registro.getOffset()));
            //Falta implementar caso seja uma função
        } else {
            if (registro.getCategoria().equals("Funcao")) {
                insereLinhaArquivo("\tpop dword[ebp +" + (12 + registro.getNumeroParametros() * 4) + "]");
            }
        }
    }

    public void A23(Registro ultimoId) {
        if (ultimoId.getNumeroParametros() == countParametros) {
            insereLinhaArquivo(String.format("	call %s", ultimoId.getRotulo()));
            insereLinhaArquivo(String.format("	add esp, %d", ultimoId.getNumeroParametros() * 4));
        } else {
            // Erro numero argumentos
        }
    }

    public void A25(ArrayList<String> rotulos, boolean pf) {
        insereLinhaArquivo(String.format("%s:", rotulos.get(0)));
        if (!pf) {
            insereLinhaArquivo(String.format("\tjmp %s", rotulos.get(1)));
        }
        // gerar rotulo _else
    }

    public void A26() {
        String rotuloTrue = String.format("rotulo_true%d", countRotulo++); // Criar rotulo _true
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); //Criar rotulo _fim
        insereLinhaArquivo(String.format("	cmp dword [esp + 4], 1"));
        insereLinhaArquivo(String.format("	je %s", rotuloTrue));	// je rotulo _false
        insereLinhaArquivo(String.format("	cmp dword [esp], 1"));
        insereLinhaArquivo(String.format("	je %s", rotuloTrue));	//	je rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp + 4], 0"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));	// jmp rotulo _fim
        insereLinhaArquivo(String.format("%s:", rotuloTrue));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp + 4], 1"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));		// gerar rotulo _fim
        insereLinhaArquivo(String.format("	add esp, 4"));
    }

    public void A27() {
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // Criar rotulo _false
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); //Criar rotulo _fim
        insereLinhaArquivo(String.format("	cmp dword [esp + 4], 0"));
        insereLinhaArquivo(String.format("	je %s", rotuloFalse));	// je rotulo _false
        insereLinhaArquivo(String.format("	cmp dword [esp], 0"));
        insereLinhaArquivo(String.format("	je %s", rotuloFalse));	//	je rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp + 4], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));	// jmp rotulo _fim
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp + 4], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));		// gerar rotulo _fim
        insereLinhaArquivo(String.format("	add esp, 4"));
    }

    public void A29() {
        insereLinhaArquivo(String.format("	push 1"));
    }

    public void A30() {
        insereLinhaArquivo(String.format("	push 0"));
    }

    public void A31() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	jne %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A32() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	jle %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A33() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	jl %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A34() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	jge %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A35() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	jg %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A36() {
        String rotuloFim = String.format("rotuloFim%d", countRotulo++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", countRotulo++); // criar rotulo _false
        insereLinhaArquivo(String.format("	pop eax"));
        insereLinhaArquivo(String.format("	cmp dword [esp], eax"));
        insereLinhaArquivo(String.format("	je %s", rotuloFalse));
        insereLinhaArquivo(String.format("	mov dword [esp], 1"));
        insereLinhaArquivo(String.format("	jmp %s", rotuloFim));
        insereLinhaArquivo(String.format("%s:", rotuloFalse));	// gerar rotulo _false
        insereLinhaArquivo(String.format("	mov dword [esp], 0"));
        insereLinhaArquivo(String.format("%s:", rotuloFim));	// gerar rotulo _fim
    }

    public void A37() {
        insereLinhaArquivo("	pop eax");
        insereLinhaArquivo("	add dword [esp], eax");
    }

    public void A38() {
        insereLinhaArquivo("	pop eax");
        insereLinhaArquivo("	sub dword [esp], eax");
    }

    public void A39() {
        insereLinhaArquivo("	pop eax");
        insereLinhaArquivo("	imul eax, dword [esp]");
        insereLinhaArquivo("	mov dword [esp], eax");
    }

    public void A40() {
        insereLinhaArquivo("	pop ecx");
        insereLinhaArquivo("	pop eax");
        insereLinhaArquivo("    mov edx,0");
        insereLinhaArquivo("	idiv ecx");
        insereLinhaArquivo("	push eax");
    }

    public void A41() {
        insereLinhaArquivo(String.format("	push %d", Integer.parseInt(lexema.getTexto())));
    }

    public void A42(Registro ultimoId) {
        if (ultimoId.getNumeroParametros() == countParametros) {
            insereLinhaArquivo(String.format("\tcall %s", ultimoId.getTabelaSimbolos().getRotulo()));
            insereLinhaArquivo(String.format("\tadd esp, %d", ultimoId.getNumeroParametros() * 4));
        } else {
            //Erro: numero argumentos
        }
    }

    public void A44() {
        String rotulo = new String();
        rotulo = tabelaSimbolos.getRotulo();
        insereLinhaArquivo(String.format("%s:", rotulo));
        insereLinhaArquivo("\tpush ebp");
        insereLinhaArquivo(String.format("\tpush dword[@DSP + %d]", nivel * 4));
        insereLinhaArquivo("\tmov ebp,esp");
        insereLinhaArquivo(String.format("\tmov dword[@DSP +%d],ebp", nivel * 4));

        int nVariaveis = 0;
        if (tabelaSimbolos != null && tabelaSimbolos.getRegistros() != null) {
            for (Registro r : tabelaSimbolos.getRegistros()) {
                if (r.getCategoria().equals("Variavel")) {
                    nVariaveis++;
                }
            }
        }
        insereLinhaArquivo(String.format("\tsub esp,%d", nVariaveis * 4));

    }

    public void A45() {
        insereLinhaArquivo("section .data");
        insereLinhaArquivo(String.format("\t@DSP times %d db 0", (nivel + 1) * 4));
        insereLinhaArquivo("\t@INTEGER: db '%d' , 0");

        for (String s : rotulosData) {
            insereLinhaArquivo(s);
        }
    }

    public void A46() {

        //verifica quantidade de variaveis locais
        int variaveis = 0;
        if (tabelaSimbolos != null && tabelaSimbolos.getRegistros() != null) {
            for (Registro r : tabelaSimbolos.getRegistros()) {
                if (r.getNivel() == nivel && r.getCategoria().equals("Variavel")) {
                    variaveis++;
                }
            }
        }

        insereLinhaArquivo(String.format("\tadd esp, %d", variaveis * 4));
        insereLinhaArquivo("\tmov ebp, esp");
        insereLinhaArquivo(String.format("\tpop dword[@DSP+%d]", nivel * 4));
        insereLinhaArquivo("\tpop ebp");
        insereLinhaArquivo("\tret");
    }

    public void A47(Registro ultimoId) {
        ultimoId.setNumeroParametros(tabelaSimbolos.getNumeroRegistroParametro());
    }

    public void A48(int nParametros) {
        Registro r = new Registro();
        r.setNome(currentFuncProc);
        r = tabelaSimbolos.getTabelaPai().getEsseRegistro(r);
        r.setNumeroParametros(nParametros);
        int n = 0;
        if (r.getCategoria().equals("Procedimento")) {
            for (int i = 0; i < nParametros; i++) {
                n = 12 + (4 * (nParametros - (i + 1)));
                tabelaSimbolos.getRegistros().get(i).setOffset(n);
            }
        } else if (r.getCategoria().equals("Funcao")) {
            for (int i = 1; i < nParametros + 1; i++) {
                n = 12 + (4 * (nParametros - i));
                tabelaSimbolos.getRegistros().get(i).setOffset(n);
            }
        }
    }

    public Registro A49() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            registro = tabelaSimbolos.getEsseRegistro(registro);
            String categoria = registro.getCategoria();
            if (categoria == null || (!categoria.equals("Variavel") && !categoria.equals("Parametro"))) {
                //Erro id nao e variavel/ parametro
            }
        } else {
            registro = null;//Erro variavel ainda nao declarada
        }
        return registro;
    }

    public Registro A50() {
        Registro r = new Registro();
        r.setNome(lexema.getTexto());
        if (tabelaSimbolos.temRegistroTodasTabelas(r)) {
            r = tabelaSimbolos.getEsseRegistro(r);
            if (!r.getCategoria().equals("Procedimento")) {
                //Erro: id deve ser procedimento
                return null;
            }
            return r;
        } else {
            return null;
        }
    }

    public void A55() {
        Registro registro = registroGlobal;
        if (tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            registro = tabelaSimbolos.getEsseRegistro(registro);
            String categoria = registro.getCategoria();
            if (categoria != null && (categoria.equals("Variavel"))) {
                String basePilha = "ebp";
                if (registro.getNivel() != nivel) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", registro.getNivel() * 4));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s - %d]", basePilha, registro.getOffset()));
            } else if (categoria.equals("Parametro")) {
                String basePilha = "ebp";
                if (registro.getNivel() != nivel) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", registro.getNivel() * 4));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s + %d]", basePilha, registro.getOffset()));
            }
        } else {
            //Erro variavel nao declarada
        }
    }

    public void A56() {
        nivel--;
        tabelaSimbolos = tabelaSimbolos.getTabelaPai();
        currentFuncProc = tabelaSimbolos.getRotulo();
    }

    public Registro A57() {
        Registro registro = new Registro();
        registro.setNome(lexema.getTexto());
        if (tabelaSimbolos.temRegistroTodasTabelas(registro)) {
            registro = tabelaSimbolos.getEsseRegistro(registro);
            if (!registro.getCategoria().equals("Variavel") && !registro.getCategoria().equals("Parametro") && !registro.getCategoria().equals("Funcao")) {
                // Erro identificador não é uma variavel
                return null;
            }
        } else {
            //Erro variavel nao declarada
            return null;
        }
        return registro;
    }

    public Registro A58(Registro ultimoId) {
        Registro esse = null;
        if (tabelaSimbolos.temRegistro(ultimoId)) {
            ultimoId = tabelaSimbolos.getEsseRegistro(ultimoId);
            if (ultimoId.getCategoria().equals("Funcao")) {
                if (ultimoId.getNivel() != nivel) {
                    //Erro: id deve corresponder a funcao corrente
                } else {
                    esse = tabelaSimbolos.getEsseRegistro(ultimoId);
                }
            }
        } else {
            //Erro: id nao declarado
        }
        return esse;
    }

    public void A59(boolean wln) {
        String rotuloString = geradorRotulo();	//criar rotulo _string
        String endString = ", 0";
        if (wln) {
            endString = ", 10, 0";
        }
        rotulosData.add(String.format("\t%s db %s %s", rotuloString, lexema.getTexto(), endString));
        insereLinhaArquivo(String.format("	push %s", rotuloString));
        insereLinhaArquivo("	call _printf");
        insereLinhaArquivo("	add esp, 4");
    }

    public void A60() {
        insereLinhaArquivo("\tsub esp, 4");
    }

}
