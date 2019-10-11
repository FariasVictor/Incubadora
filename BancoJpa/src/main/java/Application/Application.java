package Application;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import domain.*;
import DAO.*;

import DAO.ClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.List;
import java.util.Optional;


public class Application {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("c6bank");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int option;
        do {
            option = readInt("1.Operações\n2.Cadastrar cliente/conta \n.3.Sair");

            switch (option) {
                case 1:
                    operations();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    //edit();
                    break;
                case 4:
                    //sair
                    break;
                default:
                    showMessage("Opção Inválida");
                    break;
            }
        } while (option != 3);
    }


    public static void register() {
        int option;
        do {
            option = readInt("Escolha o que deseja cadastrar:\n1. Cliente \n2.Conta");
            switch (option) {
                case 1:
                    registerClient();
                    break;
                case 2:
                    registerAccount();
                    break;
                default:
                    showMessage("Opção Inválida");
                    break;
            }
        } while (option < 1 && option > 2);
    }

    public static void operations() {
        int option;
        Optional<Account> account = accountIdentifier();

        if (account.isPresent()) {
            do {
                option = readInt("1.Sacar\n2.Depositar\n3.Transferir\n4.Extrato");
                Operations operations = new Operations(entityManager);
                switch (option) {
                    case 1:
                        operations.withdraw(account.get());
                        break;
                    case 2:
                        operations.deposit(account.get());
                        break;
                    case 3:
                        operations.transfer(account.get());
                        break;
                    case 4:
                        operations.statement(account.get());
                        break;
                    default:
                        showMessage("Opção Inválida");
                }
            } while (option < 1 && option > 3);
        } else {
            showMessage("Conta não encontrada");
        }
    }

    public static Optional<Account> accountIdentifier() {
        long accountNumber = readLong("Digite o número da conta:");
        AccountDAO accountDAO = new AccountDAO(entityManager);
        Optional<Account> account = accountDAO.findById(accountNumber);
        return account;
    }

    public static void edit() {

    }

    public static void registerAccount() {
        int type = readInt("Tipo da conta: ");
        double balance = readDouble("Saldo Inicial:");
        double maxOverdraft = readDouble("Limite da conta:");
        ClientDAO clientDAO = new ClientDAO(entityManager);
        Optional<Client> optionalClient;
        long fkClient;
        do {
            fkClient = readLong("Id do cliente");
            optionalClient = clientDAO.findById(fkClient);
            if (optionalClient.isPresent()){
                Account account = new Account(optionalClient.get(), balance, maxOverdraft, type);
                AccountDAO accountDAO = new AccountDAO(entityManager);
                accountDAO.insert(account);
            } else {
                showMessage("Id inserido Inválido");
            }
        } while (optionalClient.isEmpty());
    }

    public static void registerClient() {
        String clientName = read("Nome: ");
        String clientCPF;
        do {
            clientCPF = read("CPF (Somente Números: ");
            if (!valida(clientCPF))
                showMessage("CPF inválido, por favor digite novamente");
        } while (!valida(clientCPF));
        Client client = new Client(clientName, clientCPF);
        ClientDAO clientDAO = new ClientDAO(entityManager);
        clientDAO.insert(client);
    }

    public static boolean valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        return ((List) erros).size() <= 0;
    }

//---------------------JOptionPane------------------------------

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static String read(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public static double readDouble(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, message));
    }

    public static long readLong(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(null, message));
    }

    public static int readInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, message));
    }
}

