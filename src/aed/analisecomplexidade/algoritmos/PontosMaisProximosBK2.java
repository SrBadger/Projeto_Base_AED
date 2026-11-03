package aed.analisecomplexidade.algoritmos;
import aed.utils.Par;
import java.awt.geom.Point2D;

public class PontosMaisProximosBK2 {

    // 1. Signature uses varargs and returns a Par object
    public static Par<Point2D, Point2D> executar(Point2D... pontos) {
        if (pontos == null || pontos.length < 2) {
            return null;
        }

        double minDistanceSq = Double.MAX_VALUE;
        // 2. Declare the custom Par object instead of an array
        Par<Point2D, Point2D> parMaisProximo = null;

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
                    // 3. Instantiate the Par object with the two closest points
                    parMaisProximo = new Par<>(pontos[i], pontos[j]);
                }
            }
        }
        return parMaisProximo;
    }

    // Signature uses varargs
    public static void apresentar(Point2D... pontos) {
        Par<Point2D, Point2D> resultado = executar(pontos);

        if (resultado != null) {
            // 4. Assuming the Par class uses standard getters like getPrimeiro() and getSegundo(),
            // or getElemento1() and getElemento2(). Adjust these method names based on your Par class!
            Point2D p1 = resultado.getPrimeiro(); // Change getter if necessary
            Point2D p2 = resultado.getSegundo(); // Change getter if necessary

            System.out.println("Par mais próximo: (" +
                    p1.getX() + ", " + p1.getY() + ") e (" +
                    p2.getX() + ", " + p2.getY() + ")");
            System.out.println("Distância: " + p1.distance(p2));
        }
    }
}