package Herança;

public class TestaFuncionario {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Claudio",5400.00,"claudinho99","zaqwsx");
        Secretaria secretaria = new Secretaria("Junior",1800.00,12);
        Telefonista telefonista= new Telefonista("Rose",2100.00,45);

//        gerente.mostraDados();
//        secretaria.mostraDados();
//        telefonista.mostraDados();

        ControleDePonto.registraEntrada(telefonista);
        ControleDePonto.registraSaida(telefonista);

        ControleDePonto.registraEntrada(gerente);
        ControleDePonto.registraSaida(gerente);

    }
}
