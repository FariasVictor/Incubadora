package enumxample;

public enum TipoConta {

    POUPANCA("Conta poupança bla bla"),
    CORRENTE("Conta corrente alb alb");

    private String descricao;

    TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
