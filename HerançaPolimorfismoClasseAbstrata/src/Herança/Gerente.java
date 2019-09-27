package Herança;

public class Gerente extends Funcionario {
    private String usuario;
    private String senha;

    public Gerente(String nome, double salario, String usuario, String senha) {
        super(nome, salario);
        this.usuario = usuario;
        this.senha = senha;
        this.calculaBonificacao();
    }

    @Override
    public void calculaBonificacao() {
        this.setBonificacao(this.getSalario()*0.1);
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Usuario:" +this.usuario);
        System.out.println("Senha:" +this.senha);
        System.out.println();
    }
}
