package Escola;

import java.sql.SQLOutput;

public class TestaAluno {
    public static void main(String[] args) {


        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();

        Turma turma1=new Turma();

        turma1.setPeriodo("Matutino");
        turma1.setSerie(5);
        turma1.setSigla("A");
        turma1.setTipoDeEnsino("Fundamental");

        aluno1.setNome("Víctor");
        aluno1.setDataNascimento("04/01/2000");
        aluno1.setRG("345.567.789-01");
        aluno1.setTurma(turma1);

        aluno2.setNome("Oliver");
        aluno2.setDataNascimento("03/08/2010");
        aluno2.setRG("030.584.985-98");


        System.out.printf("Nome do aluno1: "+aluno1.getNome()+"\nRG: "+aluno1.getRG()+"\nData de Nascimento(aluno1): "
                +aluno1.getDataNascimento());
        System.out.printf("\n--------------------------------\nPeriodo Turma do aluno 1: %s\nSerie do aluno 1: %d" +
                "\nSigla da turma do aluno 1: %s\nTipo de ensino Turma do aluno 1: %s\n",
                aluno1.getTurma().getPeriodo(),aluno1.getTurma().getSerie(),aluno1.getTurma().getSigla(),aluno1.getTurma().getTipoDeEnsino());


        System.out.printf("\nNome do aluno: "+aluno2.getNome()+"\nRG: "+aluno2.getRG()+"\nData de Nascimento: "+aluno2.getDataNascimento());
    }
}