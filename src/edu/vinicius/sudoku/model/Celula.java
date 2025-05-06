package edu.vinicius.sudoku.model;

public abstract class Celula {
    protected int numero;

    private int x;
    private int y;

    protected Celula(int x, int y, int numero) {
        this.x = x;
        this.y = y;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
