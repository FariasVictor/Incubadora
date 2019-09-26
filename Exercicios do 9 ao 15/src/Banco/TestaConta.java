package Banco;

import javax.swing.*;
import java.util.Scanner;

public class TestaConta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conta conta = new Conta();
        System.out.println("Digite o numero da conta: ");
        conta.setNumero(sc.nextInt());
        System.out.println("Digite o saldo da conta: ");
        conta.setSaldo(sc.nextDouble());
        System.out.println("Digite o limite da conta: ");
        conta.setLimite(sc.nextDouble());

        int opcao;
        do{
            opcao=Integer.parseInt(JOptionPane.showInputDialog(null,"1.Depósito\n 2.Saque\n3.Extrato\n4.Sair\n"));
            FuncoesConta operador=new FuncoesConta();
            switch (opcao){
                case 1:
                    operador.deposito(conta,sc.nextDouble());
                    break;
                case 2:
                    operador.saque(conta,50);
                    break;
                case 3:
                    operador.extrato(conta);
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
            }

        }while(opcao!=4);

    }

}
