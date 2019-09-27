import java.io.IOException;

public class Time {
    private String nome;


    public Time(String nome) {
        this.setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void salvarTime() throws IOException {
        Arquivo.escreverArquivo("times.txt", this.nome);
    }

    public void getTimes() throws IOException {

        Arquivo.lerArquivo("times.txt");
    }
}
