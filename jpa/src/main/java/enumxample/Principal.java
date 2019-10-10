package enumxample;

public class Principal {

    public static void main(String[] args) {
        Conta corrente = new Conta("123123", "123123", TipoConta.CORRENTE);
        Conta poupanca = new Conta("123123", "123123", TipoConta.POUPANCA);

        if (corrente.getTipo() == TipoConta.CORRENTE) {

        }

//        Conta poupanca = new Conta("123123", "123123", "SASUDHASUIDHAS");
    }
}
