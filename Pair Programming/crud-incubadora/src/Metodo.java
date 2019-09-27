import javax.swing.*;
import java.io.IOException;

public class Metodo extends Principal{

    public void Adicionar() throws IOException {
        String nome;
        if(opcaoMenu == 1){//times
           do {
               nome=lerMensagem("Digite o time que deseja adicionar");
               if(nome.length()<3){
                   mostrarMensagem("Nome menor que 3 caracteres");
               }
           }while(nome.length()<3);
            Time time=new Time(nome);
            time.salvarTime();
        }
        else{//pessoas
            String time;
            do {
                nome = lerMensagem("Digite o nome:");
                if(nome.length()<3) {
                    mostrarMensagem("Nome menor que 3 caracteres");
                }
            }while(nome.length()<3);
            do {
                time = lerMensagem("Digite o time: ");
                if(time.length()<3) {
                    mostrarMensagem("Nome menor que 3 caracteres");
                }
            }while(time.length()<3);
            Pessoa pessoa = new Pessoa(nome,time);
            pessoa.salvarPessoa();
        }
    }

    public void Remover() throws IOException {

        if(opcaoMenu == 1){
            String timeARemover = lerMensagem("Digite o time a ser removido:"+Arquivo.lerArquivo("times.txt"));
            Arquivo.removerNome("times.txt",timeARemover);
        }
        else{
            String pessoaARemover = lerMensagem("Digite o nome a ser removido:"+Arquivo.lerArquivo("Pessoas.txt"));
            Arquivo.removerNome("Pessoas.txt",pessoaARemover);
        }
    }

    public void Alterar() throws IOException {
        if(opcaoMenu == 1){
            String timeAAlterar = lerMensagem("Digite o time a ser alterado:"+Arquivo.lerArquivo("times.txt"));
            String timeNovo= lerMensagem("Digite o novo time:");
            Arquivo.alterarNome("times.txt",timeAAlterar,timeNovo);
        }
        else{
            String nomeAAlterar = lerMensagem("Digite o nome a ser alterado:"+Arquivo.lerArquivo("Pessoas.txt"));
            String nomeNovo= lerMensagem("Digite o novo nome:");
            Arquivo.alterarNome("Pessoas.txt",nomeAAlterar,nomeNovo);
        }
    }

    public void Listar() {
        if(opcaoMenu==1)
            mostrarMensagem(Arquivo.lerArquivo("times.txt"));
        else
            mostrarMensagem(Arquivo.lerArquivo("Pessoas.txt"));

    }
}
