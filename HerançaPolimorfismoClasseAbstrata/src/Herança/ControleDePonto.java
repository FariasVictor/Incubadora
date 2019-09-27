package Herança;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControleDePonto {
    public static void registraEntrada(Funcionario funcionario){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date agora = new Date();

        System.out.println("Entrada: "+ funcionario.getNome());
        System.out.println("Data: " + sdf.format(agora));

    }

    public static void registraSaida(Funcionario funcionario){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date agora = new Date();

        System.out.println("Saida: "+ funcionario.getNome());
        System.out.println("Data: " + sdf.format(agora));
        System.out.println("------------------------------------");

    }
}
