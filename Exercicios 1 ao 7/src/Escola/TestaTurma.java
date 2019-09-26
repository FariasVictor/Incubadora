package Escola;

public class TestaTurma {
    public static void main(String[] args) {
        Turma turma1=new Turma();
        Turma turma2=new Turma();

        turma1.setPeriodo("Matutino");
        turma1.setSerie(5);
        turma1.setSigla("A");
        turma1.setTipoDeEnsino("Fundamental");


        turma2.setPeriodo("Vespertino");
        turma2.setSerie(1);
        turma2.setSigla("B");
        turma2.setTipoDeEnsino("Médio");

        System.out.printf("Periodo: %s\nSerie: %d\nSigla: %s\nTipo de Ensino: %s",
                turma1.getPeriodo(),turma1.getSerie(),turma1.getSigla(),turma1.getTipoDeEnsino());
        System.out.printf("\n\nPeriodo: %s\nSerie: %d\nSigla: %s\nTipo de Ensino: %s",
                turma2.getPeriodo(),turma2.getSerie(),turma2.getSigla(),turma2.getTipoDeEnsino());
    }
}
