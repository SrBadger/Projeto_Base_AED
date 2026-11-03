package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import aed.utils.VetorDePoint2D;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaPontosMaisProximos {

    public static void main(String[] args) {
        // Array defining the different sample sizes (number of points) to test
        int[] ns = {5, 10, 15};

        // Loop through each sample size
        for (int n : ns) {
            // 1. VetorDePoint2D.criarAleatorio(n) generates an array of 'n' random Point2D objects.
            // 2. PontosMaisProximos.apresentar() passes that array into your brute-force algorithm and prints the closest pair.
            PontosMaisProximos.apresentar(VetorDePoint2D.criarAleatorio(n));
        }
    }
}