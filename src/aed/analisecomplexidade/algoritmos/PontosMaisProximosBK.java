package aed.analisecomplexidade.algoritmos;
import java.awt.geom.Point2D;

public class PontosMaisProximosBK {

    public static Point2D[] executar(Point2D[] pontos) {
        if (pontos == null || pontos.length < 2) {
            return null;
        }

        double minDistanceSq = Double.MAX_VALUE;
        Point2D[] parMaisProximo = new Point2D[2];

        /*
         * JUSTIFICAÇÃO DA COMPLEXIDADE (Ficha 2, Ex 2d):
         * The outer loop runs n-1 times, and the inner loop decreases progressively.
         * The exact number of comparisons is calculated using the formula: n(n-1)/2.
         * For a sequence of 30 points: 30(29)/2 = 435 comparisons.
         * Because the dominant term in the formula expands to n^2,
         * the time complexity of this brute-force algorithm is O(n^2).
         */
        for (int i = 0; i < pontos.length - 1; i++) {
            for (int j = i + 1; j < pontos.length; j++) {

                // OPTIMIZATION: Using distanceSq() avoids the expensive square root calculation
                // required by distance(), since if a < b, then a^2 < b^2.
                double distanciaSq = pontos[i].distanceSq(pontos[j]);

                if (distanciaSq < minDistanceSq) {
                    minDistanceSq = distanciaSq;
                    parMaisProximo[0] = pontos[i];
                    parMaisProximo[1] = pontos[j];
                }
            }
        }
        return parMaisProximo;
    }

    public static void apresentar(Point2D[] pontos) {
        Point2D[] resultado = executar(pontos);
        if (resultado != null) {
            System.out.println("Par mais próximo: (" +
                    resultado[0].getX() + ", " + resultado[0].getY() + ") e (" +
                    resultado[1].getX() + ", " + resultado[1].getY() + ")");
            // We use distance() here because the final output should display the true Euclidean distance
            System.out.println("Distância: " + resultado[0].distance(resultado[1]));
        }
    }
}