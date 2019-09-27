package Banco;

import javax.swing.*;

public class TestaFuncionario {
    public static void main(String[] args) {


        Funcionario funcionario1= new Funcionario(JOptionPane.showInputDialog("Digite o nome do funcionário: "));

        int opcao;
        do{
            opcao=Integer.parseInt(JOptionPane.showInputDialog("1.Alterar Nome\n2.Alterar Salário\n3.Consultar Dados\n4.Sair\n"));
            switch(opcao){
                case 1:
                    funcionario1.alteraNome();
                    break;
                case 2:
                    funcionario1.alteraSalario();
                    break;
                case 3:
                    funcionario1.consultaDados();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida");
                    break;
            }
        }while(opcao!=4);
    }
}