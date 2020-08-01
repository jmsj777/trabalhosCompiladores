package Acoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.ItemTable;
import Model.LexItem;
import Model.Record;
import Model.SymbolTable;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *
 * @author ze
 */
public class Acoes {

    //public RTextScrollPane sp;
    //public RSyntaxTextArea fonte;
    //txt = fonte.getText().toString();
    int level;
    SymbolTable st;
    ArrayList<Integer> offsetVar;
    ArrayList<String> labelData;
    public String asmCode;
    public int localVars;
    Record globalRecord;
    int ctLabel;
    int ctParam;
    String currentFuncProc;

    int ln;
    int col;
    int index;
    int lastLine;
    String txt;
    LexItem lexItem;
    Boolean error;
    String errorDsc;
    private ArrayList<String> resWords;
    private ArrayList<LexItem> detType;
    int ctLavel2;
    ItemTable[] itemTable;

    public Acoes() {
        level = 0;
        offsetVar = new ArrayList<>();
        labelData = new ArrayList<>();
        asmCode = "";
        localVars = 0;
        ctLabel = 0;
        ctParam = 0;
        currentFuncProc = "";

        ln = 0;
        col = 0;
        index = 0;
        lastLine = 0;

        error = false;
        resWords = new ArrayList<>();
        detType = new ArrayList<>();
        ctLavel2 = 0;
        itemTable = new ItemTable[17];
    }

    public String getasmCode() {
        return asmCode;
    }

    public SymbolTable getSymbolTable() {
        return st;
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

    public void insereLinhaArquivo(String ln) {
        asmCode = asmCode + ln + "\n";
    }

    public String geradorRotulo() {
        ctLavel2++;
        return String.format("@string%d", ctLavel2);
    }

    public File geraArquivoAsm() {
        File file = new File("./programa.asm");
        try {
            file.createNewFile();
            FileWriter asm = new FileWriter(file);
            asm.write(asmCode); // colocar a string do assembly aqui
            asm.flush();
            asm.close();
        } catch (Exception ex) {
        }

        return file;
    }

    public void rodaAsm() {
        try {
            String caminho = geraArquivoAsm().getAbsolutePath();
            System.out.print(caminho);
            Runtime.getRuntime().exec("nasm -f win32 ./programa.asm -o ./programa.o");
            Runtime.getRuntime().exec("gcc ./programa.o -o ./prog.exe");

            String commando = "cmd /c start cmd.exe /C \"programa\"";
            Runtime.getRuntime().exec(commando);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void A01() {
        st = new SymbolTable();
        st.setTabelaPai(null);
        st.setRotulo("_main");
        currentFuncProc = st.getRotulo();
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        level = 0;
        rec.setNivel(level);
        rec.setCategoria("Programa principal");

        offsetVar.add(0);
        rec.setOffset(offsetVar.get(level));
        st.addRecord(rec);
        insereLinhaArquivo("global _main");
        insereLinhaArquivo("\textern _printf");
        insereLinhaArquivo("\textern _putchar");
        insereLinhaArquivo("\textern _scanf");
        insereLinhaArquivo("section .text");
    }

    public void A03() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        System.out.println(lexItem.getTexto());
        if (!st.temRecord(rec)) {
            rec.setCategoria("Variavel");
            offsetVar.set(level, offsetVar.get(level) + 4); //SIZEOF_INT
            rec.setNivel(level);
            rec.setOffset(offsetVar.get(level));
            st.addRecord(rec);
        } else {
            //Erro: identificador já declarado anteriormente
        }
    }

    public void A04() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        rec.setRotulo(lexItem.getTexto());
        if (!st.temRecordTodasTabelas(rec)) {
            level++;
            rec.setNivel(level);
            rec.setCategoria("Procedimento");
            SymbolTable ts = new SymbolTable();
            ts.setTabelaPai(st);
            offsetVar.add(0);
//            ts.setRotulo(String.format("rotuloProcedimento%d", ctLabel++));
            ts.setRotulo(rec.getNome());
            rec.setSymbolTable(ts);
            st.addRecord(rec);
            st = ts;
            currentFuncProc = rec.getNome();
        }
    }

    /*
    public SymbolTable procuraId(SymbolTable tabelaPai){
        SymbolTable resultado = new SymbolTable();
        boolean encontrou = false;
        if(tabelaPai== null){
           resultado = tabelaPai;
        }else{
            for(Record r: tabelaPai.getRecords()){
                if(r.getNome().equals(lexItem.getTexto())){
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
    public Record A05() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (!st.temRecordTodasTabelas(rec)) {
            level += 1;
            rec.setNivel(level);
            rec.setCategoria("Funcao");
            rec.setRotulo(lexItem.getTexto());
            SymbolTable novaTs = new SymbolTable();
            novaTs.setTabelaPai(st);
            rec.setSymbolTable(novaTs);
            st.addRecord(rec);
//                novaTs.addRecord(rec);
            st = novaTs;
            st.addRecord(rec);
            // Por este motivo, add na acao 56:  st = st.getTabelaPai();
            offsetVar.add(0);
            offsetVar.set(level, offsetVar.get(level)); //SIZEOF_INT
            st.setRotulo(rec.getNome());
            currentFuncProc = rec.getNome();
        } else {
            //Erro: identificador já declarado anteriormente
            return null;
        }
        return rec;
    }

    public void A07() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (!st.temRecord(rec)) {
            rec.setCategoria("Parametro");
            rec.setNivel(level);
            st.addRecord(rec);
        } else {
            //Erro: identificador já declarado anteriormente
        }
    }

    public void A08() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (!st.temRecordTodasTabelas(rec)) {
            //emitir uma mensagem apropriada dizendo que o mesmo ainda não foi declarado.
        } else {
//            for(Record r: procura.getRecords()){
//                rec = r;
//            }
            rec = st.getEsseRecord(rec);
            if (rec.getCategoria().equals("Variavel") || rec.getCategoria().equals("Parametro")) {
                insereLinhaArquivo("\tmov edx, ebp");
                insereLinhaArquivo(String.format("\tlea eax, [edx - %d] ", rec.getOffset()));
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
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (st.temRecordTodasTabelas(rec)) {
            rec = st.getEsseRecord(rec);
            if (rec.getCategoria().equals("Variavel") || rec.getCategoria().equals("Parametro")) {
                String basePilha = "ebp";
                if (rec.getNivel() != level) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", 4 * rec.getNivel()));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s - %d]", basePilha, rec.getOffset()));
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

    public ArrayList<String> A11(Record ultimoId) {
        if (ultimoId != null) {
            String basePilha = "ebp";
            if (ultimoId.getNivel() != level) {
                insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
                basePilha = "ebx";
            }
            insereLinhaArquivo(String.format("	pop dword [%s - %d]", basePilha, ultimoId.getOffset()));
            ArrayList<String> rotulosFor = new ArrayList<>();
            rotulosFor.add(String.format("rotuloInFor%d", ctLabel++));
            rotulosFor.add(String.format("rotuloEndFor%d", ctLabel++));
            insereLinhaArquivo(String.format("%s:", rotulosFor.get(0)));// gerar rotulo _for
            return rotulosFor;
        } else {
            return null;
        }
    }

    public void A12(Record ultimoId, ArrayList<String> rotulosFor) {
        insereLinhaArquivo(String.format("\tmov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
        insereLinhaArquivo("\tpop eax");
        insereLinhaArquivo(String.format("\tcmp [ebx - %d], eax", ultimoId.getOffset()));
        insereLinhaArquivo(String.format("\tjg %s", rotulosFor.get(1))); // usar rotulo gerado no gerador de rótulos;            
    }

    public void A13(Record ultimoId, ArrayList<String> rotulosFor) {
        if (ultimoId != null) {
            String basePilha = "ebp";
            if (ultimoId.getNivel() != level) {
                insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", ultimoId.getNivel() * 4));
                basePilha = "ebx";
            }
            insereLinhaArquivo(String.format("\tadd dword [%s - %d], 1", basePilha, ultimoId.getOffset()));
            insereLinhaArquivo(String.format("\tjmp %s", rotulosFor.get(0)));// jmp rotulo _for
            insereLinhaArquivo(String.format("%s:", rotulosFor.get(1)));// gerar rotulo _fim_for
        }
    }

    public String A14() {
        String rotulo = String.format("rotuloRepeat%d", ctLabel++);//criar rotulor de repetição do repeat
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
        rotulosWhile.add(String.format("rotuloInWhile%d", ctLabel++));//criar rotulo entrada while
        rotulosWhile.add(String.format("rotuloEndWhile%d", ctLabel++));//criar rotulo saida while
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
        rotulos.add(String.format("rotuloInElse%d", ctLabel++));
        rotulos.add(String.format("rotuloEndIf%d", ctLabel++));
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

    public void A22(Record rec) {
        if (rec.getCategoria().equals("Variavel")) {
            insereLinhaArquivo(String.format("\tmov eax, dword[@DSP+%d]", rec.getNivel() * 4));
            insereLinhaArquivo("\tpop ebx");
            insereLinhaArquivo(String.format("\tmov dword[eax - %d], ebx", rec.getOffset()));
            //Falta implementar caso seja uma função
        } else {
            if (rec.getCategoria().equals("Funcao")) {
                insereLinhaArquivo("\tpop dword[ebp +" + (12 + rec.getNumeroParametros() * 4) + "]");
            }
        }
    }

    public void A23(Record ultimoId) {
        if (ultimoId.getNumeroParametros() == ctParam) {
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
        String rotuloTrue = String.format("rotulo_true%d", ctLabel++); // Criar rotulo _true
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); //Criar rotulo _fim
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
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // Criar rotulo _false
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); //Criar rotulo _fim
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        String rotuloFim = String.format("rotuloFim%d", ctLabel++); // criar rotulo _fim
        String rotuloFalse = String.format("rotuloFalse%d", ctLabel++); // criar rotulo _false
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
        insereLinhaArquivo(String.format("	push %d", Integer.parseInt(lexItem.getTexto())));
    }

    public void A42(Record ultimoId) {
        if (ultimoId.getNumeroParametros() == ctParam) {
            insereLinhaArquivo(String.format("\tcall %s", ultimoId.getSymbolTable().getRotulo()));
            insereLinhaArquivo(String.format("\tadd esp, %d", ultimoId.getNumeroParametros() * 4));
        } else {
            //Erro: numero argumentos
        }
    }

    public void A44() {
        String rotulo = new String();
        rotulo = st.getRotulo();
        insereLinhaArquivo(String.format("%s:", rotulo));
        insereLinhaArquivo("\tpush ebp");
        insereLinhaArquivo(String.format("\tpush dword[@DSP + %d]", level * 4));
        insereLinhaArquivo("\tmov ebp,esp");
        insereLinhaArquivo(String.format("\tmov dword[@DSP +%d],ebp", level * 4));

        int nVariaveis = 0;
        if (st != null && st.getRecords() != null) {
            for (Record r : st.getRecords()) {
                if (r.getCategoria().equals("Variavel")) {
                    nVariaveis++;
                }
            }
        }
        insereLinhaArquivo(String.format("\tsub esp,%d", nVariaveis * 4));

    }

    public void A45() {
        insereLinhaArquivo("section .data");
        insereLinhaArquivo(String.format("\t@DSP times %d db 0", (level + 1) * 4));
        insereLinhaArquivo("\t@INTEGER: db '%d' , 0");

        for (String s : labelData) {
            insereLinhaArquivo(s);
        }
    }

    public void A46() {

        //verifica quantidade de variaveis locais
        int variaveis = 0;
        if (st != null && st.getRecords() != null) {
            for (Record r : st.getRecords()) {
                if (r.getNivel() == level && r.getCategoria().equals("Variavel")) {
                    variaveis++;
                }
            }
        }

        insereLinhaArquivo(String.format("\tadd esp, %d", variaveis * 4));
        insereLinhaArquivo("\tmov ebp, esp");
        insereLinhaArquivo(String.format("\tpop dword[@DSP+%d]", level * 4));
        insereLinhaArquivo("\tpop ebp");
        insereLinhaArquivo("\tret");
    }

    public void A47(Record ultimoId) {
        ultimoId.setNumeroParametros(st.getNumeroRecordParametro());
    }

    public void A48(int nParametros) {
        Record r = new Record();
        r.setNome(currentFuncProc);
        r = st.getTabelaPai().getEsseRecord(r);
        r.setNumeroParametros(nParametros);
        int n = 0;
        if (r.getCategoria().equals("Procedimento")) {
            for (int i = 0; i < nParametros; i++) {
                n = 12 + (4 * (nParametros - (i + 1)));
                st.getRecords().get(i).setOffset(n);
            }
        } else if (r.getCategoria().equals("Funcao")) {
            for (int i = 1; i < nParametros + 1; i++) {
                n = 12 + (4 * (nParametros - i));
                st.getRecords().get(i).setOffset(n);
            }
        }
    }

    public Record A49() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (st.temRecordTodasTabelas(rec)) {
            rec = st.getEsseRecord(rec);
            String categoria = rec.getCategoria();
            if (categoria == null || (!categoria.equals("Variavel") && !categoria.equals("Parametro"))) {
                //Erro id nao e variavel/ parametro
            }
        } else {
            rec = null;//Erro variavel ainda nao declarada
        }
        return rec;
    }

    public Record A50() {
        Record r = new Record();
        r.setNome(lexItem.getTexto());
        if (st.temRecordTodasTabelas(r)) {
            r = st.getEsseRecord(r);
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
        Record rec = globalRecord;
        if (st.temRecordTodasTabelas(rec)) {
            rec = st.getEsseRecord(rec);
            String categoria = rec.getCategoria();
            if (categoria != null && (categoria.equals("Variavel"))) {
                String basePilha = "ebp";
                if (rec.getNivel() != level) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", rec.getNivel() * 4));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s - %d]", basePilha, rec.getOffset()));
            } else if (categoria.equals("Parametro")) {
                String basePilha = "ebp";
                if (rec.getNivel() != level) {
                    insereLinhaArquivo(String.format("	mov ebx, dword [@DSP + %d]", rec.getNivel() * 4));
                    basePilha = "ebx";
                }
                insereLinhaArquivo(String.format("	push dword [%s + %d]", basePilha, rec.getOffset()));
            }
        } else {
            //Erro variavel nao declarada
        }
    }

    public void A56() {
        level--;
        st = st.getTabelaPai();
        currentFuncProc = st.getRotulo();
    }

    public Record A57() {
        Record rec = new Record();
        rec.setNome(lexItem.getTexto());
        if (st.temRecordTodasTabelas(rec)) {
            rec = st.getEsseRecord(rec);
            if (!rec.getCategoria().equals("Variavel") && !rec.getCategoria().equals("Parametro") && !rec.getCategoria().equals("Funcao")) {
                // Erro identificador não é uma variavel
                return null;
            }
        } else {
            //Erro variavel nao declarada
            return null;
        }
        return rec;
    }

    public Record A58(Record ultimoId) {
        Record esse = null;
        if (st.temRecord(ultimoId)) {
            ultimoId = st.getEsseRecord(ultimoId);
            if (ultimoId.getCategoria().equals("Funcao")) {
                if (ultimoId.getNivel() != level) {
                    //Erro: id deve corresponder a funcao corrente
                } else {
                    esse = st.getEsseRecord(ultimoId);
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
        labelData.add(String.format("\t%s db %s %s", rotuloString, lexItem.getTexto(), endString));
        insereLinhaArquivo(String.format("	push %s", rotuloString));
        insereLinhaArquivo("	call _printf");
        insereLinhaArquivo("	add esp, 4");
    }

    public void A60() {
        insereLinhaArquivo("\tsub esp, 4");
    }

}
