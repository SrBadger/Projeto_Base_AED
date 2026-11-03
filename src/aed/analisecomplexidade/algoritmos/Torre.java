package aed.analisecomplexidade.algoritmos;

import java.util.NoSuchElementException;

public class Torre {
    private int[] baseEDiscos;
    private int indiceTopo;
    private char nome;

    //construtor
    public Torre(char nome, int numeroDiscos) {
        this.nome = nome;
        baseEDiscos = new int[numeroDiscos + 1];
        baseEDiscos[0] = numeroDiscos * 3; //base
        indiceTopo = 0;
    }
    
    public void preencher() {
        int tamanho = baseEDiscos.length;
        for (int i = 0; i < tamanho ; i++)
        {
            baseEDiscos[i] = tamanho -i;
        }
        indiceTopo = tamanho - 1;
    }

    public void moverDiscos(Torre destino) {
        if (this == destino){
            throw new IllegalArgumentException("Torre de destino igual à da origem!");
        }
        if (this.indiceTopo == 0){
            throw new NoSuchElementException("Torre de origem vazia!");
        }
        if(destino.indiceTopo == destino.baseEDiscos.length -1){
            throw new ArrayIndexOutOfBoundsException("Torre de destino cheia!");
        }
        if(this.baseEDiscos[this.indiceTopo] >= destino.baseEDiscos[destino.indiceTopo]){
            throw new IllegalArgumentException("Disco maior sobre disco menor!");
        }
        // 1. Mover o disco do topo da torre *this* para o topo +1 da torre *destino*
        destino.baseEDiscos[destino.indiceTopo + 1] = this.baseEDiscos[this.indiceTopo];
        this.baseEDiscos[this.indiceTopo--] = 0;
    }

    @Override
    public String toString()
    {
        return String.valueOf(nome);
    }
}