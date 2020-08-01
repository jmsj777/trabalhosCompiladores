/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class ItemTable {
    private int hash;
    private LexItem item;
    private ItemTable next;
    private ItemTable last;

    public ItemTable(LexItem item, ItemTable next, ItemTable last, int hash) {
        this.hash = hash;
        this.item = item;
        this.next = next;
        this.last = last;
    }
    
    public int getHash(){
        return hash;
    }

    public LexItem getItem() {
        return item;
    }


    public ItemTable getProximo() {
        return next;
    }

    public void setProximo(ItemTable next) {
        this.next = next;
    }

    public ItemTable getAnterior() {
        return last;
    }

    public void setAnterior(ItemTable last) {
        this.last = last;
    }

    private ItemTable ultimo(ItemTable itemtabela){
        ItemTable resultado=itemtabela;
        if(itemtabela.getProximo()!= null){
            resultado = ultimo(itemtabela.getProximo());
        }
        return resultado;
    }
    public void insereProximo(ItemTable pai, ItemTable filho){
        pai = ultimo(pai);
        pai.next= filho;
        filho.last =pai;
    }
    
    public boolean existe(ItemTable pai,String lexema, String categoria){
        boolean resultado=true;
        if(pai==null){
            resultado=false;
        }else{
            if(!pai.getItem().getTexto().equals(lexema) || !pai.getItem().getCategoria().equals(categoria)){
                resultado = existe(pai.next,lexema, categoria);
            }
        }
     return resultado;
    }
    
    public void imprimeItensTabela(ItemTable item, DefaultTableModel model){
        if(item!=null){
            model.addRow(new Object[]{item.getItem().getTexto(), item.getItem().getCategoria(), item.getItem().getTipo()});
            imprimeItensTabela(item.next, model);
        }
    }
}
