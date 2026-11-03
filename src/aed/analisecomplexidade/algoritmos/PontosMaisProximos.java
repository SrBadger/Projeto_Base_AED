package aed.analisecomplexidade.algoritmos;
import aed.utils.Par;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class PontosMaisProximos
{
    public static Par<Point2D, Point2D> executar(Point2D... pontos)
    {
        int tamanho = pontos.length;
        if(tamanho <2)
        {
            throw new IllegalArgumentException("Deve conter pelo menos 2 pontos!");
        }

        if(tamanho  == 2)
        {
            return new Par<>(pontos[0], pontos[1]);
        }
        int pi1 = -1;
        int pi2 = -1;
        double distmin = Double.MAX_VALUE;
        for(int i = 0; i < pontos.length -1; i++)
        {
            for (int j = i +1; j < pontos.length; j++)
            {
                double distsq = pontos[i].distanceSq(pontos[j]);
                if (distsq < distmin)
                {
                    distmin = distsq;
                    pi1 = i;
                    pi2 = j;
                }
            }
        }

        return new Par<>(pontos[pi1], pontos[pi2]);
    }

    public static void apresentar(Point2D... pontos)
    {
        try
        {
            Par<Point2D,Point2D> resultado = executar(pontos);
            System.out.println("Os pontos mais próximos desta sequência:");
            System.out.println(Arrays.toString(pontos));
            System.out.println("são"+ resultado.getPrimeiro() + "e" + resultado.getSegundo());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}