package Static;

import javax.swing.*;

public class Funcionario {

    private static double valeRefeicao=40.00;

    public static double getValeRefeicao() {
        return valeRefeicao;
    }

    public static void setValeRefeicao(double valeRefeicao) {
        Funcionario.valeRefeicao = valeRefeicao;
    }

    public static void reajustaValeRefeicao(double taxa){
        valeRefeicao *= 1+taxa/100;
    }
}
