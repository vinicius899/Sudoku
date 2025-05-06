package edu.vinicius.sudoku.model;

import java.util.Random;
import java.util.function.Supplier;

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
                    this.celulas[i][j] = new CelulaInicial(i, j, 1 + (Math.abs(rand.nextInt() % 9)));

                    while (!verificarCelulaValida(this.celulas[i][j], i, j)) {
                        this.celulas[i][j].setNumero(1 + Math.abs(rand.nextInt() % 9));
                    }
                } else {
                    this.celulas[i][j] = new CelulaEditavel(i, j);
                }
            }
        }
    }

    private boolean verificarLinha(Celula c, int i) {
        for (int j = 0; j < this.quadDimensao; j++) {
            if (this.celulas[i][j] != null && 
                this.celulas[i][j].getNumero() == c.getNumero() && 
                j != c.getY()) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarColuna(Celula c, int j) {
        for (int i = 0; i < this.quadDimensao; i++) {
            if (this.celulas[i][j] != null &&
                this.celulas[i][j].getNumero() == c.getNumero() &&
                i != c.getX()) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarCelulaValida(Celula c, int linha, int coluna) {
        return verificarLinha(c, linha) && verificarColuna(c, coluna);
    }

    public void imprimirTabuleiro() {
        Supplier<String> divSupplier = () -> "=".repeat(this.quadDimensao*3 + this.dimensao*2);

        System.out.println();

        for (int i = 0; i < this.quadDimensao; i++) {
            if (i % 3 == 0 && i != 0) System.out.println(divSupplier.get());

            for (int j = 0; j < this.quadDimensao; j++) {
                if (j % 3 == 0 && j != 0) System.out.print(" | ");

                if (this.celulas[i][j].getNumero() != 0) {
                    System.out.printf(" %d ", this.celulas[i][j].getNumero());
                } else {
                    System.out.print(" _ ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}
