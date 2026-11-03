package aed.recursividade.algoritmos;

public class Fibonacci {

    // a) Implementação do método estático executar
    public static long executar(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return executar(n - 2) + executar(n - 1);
    }

    // b) Implementação do método estático apresentar
    public static void apresentar(int n) {
        long resultado = executar(n);
        System.out.println("Fibonacci(" + n + ") = " + resultado);
    }
}