package aed.analisecomplexidade.algoritmos;

public class JogoTorresHanoi_v2 {

    public static void executar(int numeroDiscos) {
        // Inicializar as torres
        Torre torreA = new Torre('A', numeroDiscos);
        Torre torreB = new Torre('B', numeroDiscos);
        Torre torreC = new Torre('C', numeroDiscos);
        torreA.preencher();

        executarRecursivo(numeroDiscos, torreA, torreB, torreC);
    }

    private static void executarRecursivo(int numeroDiscos, Torre origem, Torre auxiliar, Torre destino) {
        if (numeroDiscos == 1) {
            System.out.println(origem + " => " + destino);
            origem.moverDiscos(destino);
            return;
        }

        executarRecursivo(numeroDiscos - 1, origem, destino, auxiliar);

        System.out.println(origem + " => " + destino);
        origem.moverDiscos(destino);

        executarRecursivo(numeroDiscos - 1, auxiliar, origem, destino);
    }

    public static void apresentar(int numeroDiscos) {
        System.out.println("Resolução para " + numeroDiscos + " discos:");
        executar(numeroDiscos);
    }
}