package enumxample;

public class Conta {

    private String numero;

    private String agencia;

    private TipoConta tipo;

    public Conta(String numero, String agencia, TipoConta tipo) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public TipoConta getTipo() {
        return tipo;
    }
}
