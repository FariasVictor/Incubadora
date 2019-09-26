package Arrays;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Exercicio1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numeros = new double[3];
        double media=0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextDouble();
            media+=numeros[i];
        }
        media/=3;

//        media= DoubleStream.of(numeros).reduce(0,(x,y)->x+y)/numeros.length;
        System.out.printf("%.2f",media);
//        DoubleStream.of(numeros).forEach(e-> System.out.println(e));
    }
}