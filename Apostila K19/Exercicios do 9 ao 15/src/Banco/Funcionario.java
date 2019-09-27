package Banco;

import javax.swing.*;

public class Funcionario {
    private String nome;
    private double salario;


    public Funcionario(String nome){
        this.nome=nome;
        salario=200;
    }

    public void aumentaSalario(double porcentagem){
        this.salario*=1+porcentagem/100;
    }
    public void consultaDados(){
        System.out.printf("Nome: %s\nSalario: %.2f\n",this.getNome(),this.getSalario());
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
    public void alteraNome(){
        this.nome= JOptionPane.showInputDialog("Digite o novo nome: ");
    }
    public void alteraSalario(){
        this.salario=Double.parseDouble(JOptionPane.showInputDialog("Digite o novo salario: "));
    }

}
