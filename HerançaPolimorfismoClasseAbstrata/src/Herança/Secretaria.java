package Herança;

public class Secretaria extends Funcionario {
    private int ramal;


    public Secretaria(String nome, double salario, int ramal) {
        super(nome, salario);
        this.ramal = ramal;
        calculaBonificacao();
    }

    @Override
    public void calculaBonificacao() {
        this.setBonificacao(this.getSalario()*0.06);
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Ramal:" +this.ramal);
        System.out.println();
    }
}
