package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        double numeros[] = new double[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<numeros.length;i++){
            numeros[i]=sc.nextDouble();
        }

        Arrays.sort(numeros);
        System.out.println(numeros[numeros.length-1]);
        //System.out.println(DoubleStream.of(numeros).max().getAsDouble());
    }
}