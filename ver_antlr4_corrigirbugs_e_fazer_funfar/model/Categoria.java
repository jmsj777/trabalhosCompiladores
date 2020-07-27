/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ze
 */
class Categoria {

    public static final int VARIAVEL = 0;
    public static final int FUNCAO = 1;
    public static final int PROCEDMIENTO = 2;
    public static final int PARAMETRO = 3;

    private int cat;

    public Categoria(int cat) {
        this.cat = cat;
    }

    
}
