/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Murilo Marcineiro
 */
public class SymbolTable {
    private int memoria;
    private ArrayList<Record> registros;
    private SymbolTable tabelaPai;
    private String rotulo;
    
    public void setRotulo(String rotulo){
        this.rotulo = rotulo;
    }
    
    public String getRotulo(){
        return this.rotulo;
    }

    public ArrayList<Record> getRecords() {
        return registros;
    }

    public void addRecord(Record registro) {
        if(this.registros == null)
            this.registros = new ArrayList<>();
        this.registros.add(registro);
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public SymbolTable getTabelaPai() {
        return tabelaPai;
    }

    public void setTabelaPai(SymbolTable tabelaPai) {
        this.tabelaPai = tabelaPai;
    }

    public Record getEsseRecord(Record registro){
        if(this.registros!=null){
            for(Record r : this.registros){
                if(r.getNome().equals(registro.getNome()))
                    return r;
            }
        }
        if(this.tabelaPai!=null){
            return this.tabelaPai.getEsseRecord(registro);
        } else {
            return null;
        }
    }
    
    public boolean temRecord(Record registro){
        if(registros==null)
            return false;
        for(Record r : registros){
            if(registro.getNome().equals(r.getNome()))
                return true;
        }
        return false;
    }

    public boolean temRecordTodasTabelas(Record registro){
        if(this.tabelaPai == null){
            return this.temRecord(registro);
        } else {
            return this.temRecord(registro) || this.tabelaPai.temRecordTodasTabelas(registro);
        }
    }
    
    

    public int getNumeroRecordParametro(){
        int n = 0;
        for (Record registro : this.registros) {
            if(registro.getCategoria()!=null && registro.getCategoria().equals("Parametro"))
                n++;
        }
        return n;
    }
    
}