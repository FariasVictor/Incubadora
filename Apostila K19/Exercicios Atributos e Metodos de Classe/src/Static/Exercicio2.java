package Static;

import javax.swing.*;

public class Exercicio2 {
    public static void main(String[] args) {

        System.out.println("Vale refeição antes do reajuste: " + Funcionario.getValeRefeicao());
        double reajuste = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a taxa de reajuste do vale refeição:"));
        Funcionario.reajustaValeRefeicao(reajuste);
        System.out.printf("Vale refeição após reajuste de %.2f: %.2f", reajuste, Funcionario.getValeRefeicao());

    }
}
