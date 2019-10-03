import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        String cpf = getPessoaCPF();
        String cpf = "282.795.678-01";
        System.out.println(valida(cpf));
    }

    public static boolean valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        return ((List) erros).size() <= 0;
    }
}
