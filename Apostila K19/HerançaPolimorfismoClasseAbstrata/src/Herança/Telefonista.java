package Herança;

public class Telefonista extends Funcionario {
    private int estacaoDeTrabalho;


    public Telefonista(String nome, double salario, int estacaoDeTrabalho) {
        super(nome, salario);
        this.estacaoDeTrabalho = estacaoDeTrabalho;
        calculaBonificacao();
    }

    @Override
    public void calculaBonificacao() {
        this.setBonificacao(this.getSalario()*0.08);
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Estação de Trabalho:" +this.estacaoDeTrabalho);
        System.out.println();
    }
}
