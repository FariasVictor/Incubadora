import javax.swing.*;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        int opcaoJogo = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Menu: \n1.Jogar contra outro player" +
                        "\n 2.Jogar contra máquina."));

        if(opcaoJogo == 1){
            jogarDuasPessoas();
        }
        else{
            jogarMaquina();
        }


    }

    private static void jogarDuasPessoas(){
        String jogador1, jogador2;

        jogador1 = JOptionPane.showInputDialog(null, "Informe o nome do 1º Jogador: ");
        jogador2 = JOptionPane.showInputDialog(null, "Informe o nome do 2º Jogador: ");
        int continuar;
        int opcaoJogador1;
        int opcaoJogador2;
        int numJog1;
        int numJog2;
        int somaNumeros;
        int placar1=0;
        int placar2=0;

        do{
            opcaoJogador1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menu: \n1. Par" +
                            "\n 2.Ímpar"));
            if(opcaoJogador1==1){
                opcaoJogador2=2;
            }
            else{
                opcaoJogador2=1;
            }
            numJog1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Jogador 1 informa o numero."));

            numJog2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Jogador 2 informa o numero."));

            somaNumeros= Soma(numJog1, numJog2);

            if(validarPar(somaNumeros)){
                if(opcaoJogador1 == 1){
                    placar1++;
                    JOptionPane.showMessageDialog(null, "Jogador 1 venceu!");
                }else {
                    placar2++;
                    JOptionPane.showMessageDialog(null, "Jogador 2 venceu!");
                }
            } else{
                if(opcaoJogador1==2){
                    placar1++;
                    JOptionPane.showMessageDialog(null, "Jogador 1 venceu!");
                }else{
                    placar2++;
                    JOptionPane.showMessageDialog(null, "Jogador 2 venceu!");
                }
            }

            continuar = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite 1 para continuar ou qualquer outro num para sair."));


        }while(continuar == 1);

        JOptionPane.showMessageDialog(null,
                jogador1+ " Score :"+ placar1+"\n"+"Nome do jogador 2: "+jogador2+ " Score: "+placar2);
    }

    private static boolean validarPar(int somaNumeros){

        return (somaNumeros%2 ==0);
    }

    private static int Soma(int numJ1, int numJ2){
        return numJ1+numJ2;
    }
    private static void jogarMaquina(){
        String nomeJogador1=JOptionPane.showInputDialog(null,"Digite o nome do jogador 1: ");
        int placarJogador=0;
        int placarMaquina=0;
        int jogarDeNovo;
        int continuar;

        do {
            int opcaoJogador = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menu: \n1. Par" +
                            "\n 2.Ímpar"));
            int numeroJogador1 = Integer.parseInt(JOptionPane.showInputDialog(null, nomeJogador1 + ", digite o numero desejado: "));
            //vencedor();

            int numeroMaquina = geraNumeroAleatorio();

            if (validarPar(Soma(numeroJogador1, numeroMaquina)) && opcaoJogador == 1) {
                JOptionPane.showMessageDialog(null, nomeJogador1 + " venceu!");
                placarJogador++;
            } else if (!(validarPar(Soma(numeroJogador1, numeroMaquina))) && opcaoJogador == 2) {
                JOptionPane.showMessageDialog(null, nomeJogador1 + " venceu!");
                placarJogador++;
            } else {
                JOptionPane.showMessageDialog(null, "A máquina venceu!");
                placarMaquina++;
            }
            JOptionPane.showMessageDialog(null,
                    nomeJogador1 + ": " + placarJogador + "\n" + "Máquina: " + placarMaquina);
            continuar = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite 1 para continuar ou qualquer outro num para sair."));

        }while(continuar==1);
    }
    private static int geraNumeroAleatorio(){
        Random geradorDeNumeroAleatorio = new Random();
        int numeroAleatorio=geradorDeNumeroAleatorio.nextInt(11);
        JOptionPane.showMessageDialog(null,"O número escolhido pela máquina foi: "+numeroAleatorio);
        return (numeroAleatorio);
    }


}