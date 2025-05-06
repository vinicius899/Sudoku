package edu.vinicius.sudoku.model;

public class CelulaEditavel extends Celula {
    public CelulaEditavel(int x, int y) {
        super(x, y, 0);
    }

    public void setNumero(int numero) {
        if (numero > 0)
            this.numero = numero;
    }

}
