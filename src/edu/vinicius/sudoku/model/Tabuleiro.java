package edu.vinicius.sudoku.model;

import java.util.Random;

public class Tabuleiro {
    private Random rand = new Random();

    private static final double PROBABILIDADE_CELULA_INICIAL = 0.4;

    private int dimensao;
    private int quadDimensao;
    private Celula[][] celulas;

    public Tabuleiro(int dimensao) {
        if (dimensao > 1) {
            this.dimensao = dimensao;
            this.quadDimensao = (int)Math.pow(dimensao, 2.0);
            this.celulas = new Celula[quadDimensao][quadDimensao];

            this.gerarTabuleiro();
        } else {
            System.out.println("Dimensao deve ser maior que 1.");
        }
    }

    public int getDimensao() {
        return this.dimensao;
    }

    private void gerarTabuleiro() {
        for (int i = 0; i < this.quadDimensao; i++) {
            for (int j = 0; j < this.quadDimensao; j++) {
                if (Math.random() < PROBABILIDADE_CELULA_INICIAL) {
                    this.celulas[i][j] = new CelulaInicial(i, j, 1 + Math.abs(rand.nextInt() % 9));
                } else {
                    this.celulas[i][j] = new CelulaEditavel(i, j);
                }
            }
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < this.quadDimensao; i++) {
            for (int j = 0; j < this.quadDimensao; j++) {
                System.out.print(this.celulas[i][j].getNumero() + " ");
            }

            System.out.println();
        }
    }
}
