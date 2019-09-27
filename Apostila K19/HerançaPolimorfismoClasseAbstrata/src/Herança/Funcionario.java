package Herança;


public abstract class Funcionario {
    private String nome;
    private double salario;
    private double bonificacao;

    public Funcionario(String nome, double salario){
        this.nome=nome;
        this.salario=salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public abstract void calculaBonificacao();

    public void mostraDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Salario: " + this.salario);
        System.out.println("Bonificacao: " + this.bonificacao);
    }
}