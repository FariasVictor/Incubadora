import java.io.IOException;

public class Pessoa {

    private String nome;
    private Time time;


    public Pessoa(String nome,String time){

        this.nome=nome;
        this.time = new Time(time);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void salvarPessoa() throws IOException {
        Arquivo.escreverArquivo("Pessoas.txt", this.nome);
        Arquivo.escreverArquivo("PessoasTimes.txt", this.nome+"-"+this.time.getNome());
    }
}
