package Escola;

public class TestaFuncionario {
    public static void main(String[] args) {


        Funcionario funcionario1 = new Funcionario();
        Funcionario funcionario2 = new Funcionario();

        funcionario1.setCargo("Professor");
        funcionario1.setSalario(2500.00);


        funcionario2.setCargo("Diretor");
        funcionario2.setSalario(4500.00);

        System.out.printf("Cargo: %s \nSalario %.2f\n",funcionario1.getCargo(),funcionario1.getSalario());
        System.out.printf("\nCargo: %s \nSalario %.2f",funcionario2.getCargo(),funcionario2.getSalario());
    }
}