import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static int opcaoMenu;
    public static void main(String[] args) throws IOException{

        do{
            opcaoMenu = menu();
            if(opcaoMenu!=3) {
                subMenu(opcaoMenu);
            }
        }while(opcaoMenu != 3);
    }

    public static int menu() throws IOException {

        do{
            opcaoMenu=Integer.parseInt(lerMensagem("Menu\n1. Times\n 2. Pessoas\n 3. Sair"));

            if(opcaoMenu < 1 || opcaoMenu > 3){
                mostrarMensagem("Digito inválido");
            }

        }while(opcaoMenu < 1 || opcaoMenu > 3);

        return opcaoMenu;
    }

    public static void subMenu(int opcaoMenu) throws IOException {

        int opcaoSubMenu;

        do{
            opcaoSubMenu = Integer.parseInt(lerMensagem("Menu\n1. Adicionar\n2. Remover\n 3. Alterar\n4. Listar\n" +
                                                                                    "5.Voltar ao Menu Principal"));
            if(opcaoSubMenu < 1 || opcaoSubMenu > 5){
                mostrarMensagem("Digito inválido");
            }
        }while(opcaoSubMenu < 1 || opcaoMenu > 5);

         Metodo met = new Metodo();

        switch(opcaoSubMenu){

            case 1: met.Adicionar();
                break;
            case 2: met.Remover();
                break;
            case 3: met.Alterar();
                break;
            case 4: met.Listar();
                break;
            case 5:
                break;
            default:
        }
    }

    public static void mostrarMensagem(String mensagem){
        JOptionPane.showMessageDialog(null,mensagem);
    }
    public static String lerMensagem(String mensagem){
        return JOptionPane.showInputDialog(null,mensagem);
    }
}
