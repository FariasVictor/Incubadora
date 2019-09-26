package Banco;

public class FuncoesConta{

    public void deposito(Conta conta, double valor){
        double saldo=conta.getSaldo();
        conta.setSaldo(saldo+=valor);
        System.out.printf("O depósito de %.2f na conta %d foi efetuado com sucesso", valor,conta.getNumero());
    }

    public void saque(Conta conta, double valor){
        double saldo=conta.getSaldo();
        conta.setSaldo(saldo-=valor);
        System.out.printf("O saque de %.2f na conta %d foi efetuado com sucesso", valor,conta.getNumero());
    }

    public void extrato(Conta conta){
        System.out.printf("Numero da conta: %d\nSaldo: %.2f\nLimite: %.2f\n",conta.getNumero(),conta.getLimite(),conta.getSaldo());
    }

}
