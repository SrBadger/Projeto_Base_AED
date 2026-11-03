package aed.recursividade.algoritmos;

public class JogoTorresHanoi {

    // a) Implementação do método estático executar
    public static void executar(int numeroDiscos, char origem, char auxiliar, char destino) {
        // Base case: Only one disk to move
        if (numeroDiscos == 1) {
            System.out.println(origem + " => " + destino);
            return;
        }

        // Move n-1 disks from origin to auxiliary, using destination as the temporary peg
        executar(numeroDiscos - 1, origem, destino, auxiliar);

        // Move the remaining largest disk from origin to destination
        System.out.println(origem + " => " + destino);

        // Move the n-1 disks from auxiliary to destination, using origin as the temporary peg
        executar(numeroDiscos - 1, auxiliar, origem, destino);
    }

    // b) Implementação do método estático apresentar
    public static void apresentar(int numeroDiscos) {
        System.out.println("Resolução para " + numeroDiscos + " discos:");
        // The standard towers from Figura 1 are A, B, and C
        executar(numeroDiscos, 'A', 'B', 'C');
    }
}