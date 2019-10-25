package com.invillia;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.invillia.DAO.AccountDAO;
import com.invillia.DAO.ClientDAO;
import com.invillia.DAO.Operations;
import com.invillia.domain.Account;
import com.invillia.domain.Client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@ComponentScan
public class Application {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        ClientDAO clientDAO = context.getBean(ClientDAO.class);
        Operations operations = context.getBean(Operations.class);

        menu(accountDAO,clientDAO,operations);
    }

    public static void menu(AccountDAO accountDao,ClientDAO clientDAO,Operations operations) {
        int option;
        do {
            option = readInt("1.Operações\n2.Cadastrar cliente/conta \n3.Sair");

            switch (option) {
                case 1:
                    operations(operations,accountDao);
                    break;
                case 2:
                    register(clientDAO,accountDao);
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


    public static void register(ClientDAO clientDAO, AccountDAO accountDAO) {
        int option;
        do {
            option = readInt("Escolha o que deseja cadastrar:\n1. Cliente \n2.Conta");
            switch (option) {
                case 1:
                    registerClient(clientDAO);
                    break;
                case 2:
                    registerAccount(accountDAO,clientDAO);
                    break;
                default:
                    showMessage("Opção Inválida");
                    break;
            }
        } while (option < 1 && option > 2);
    }

    public static void operations(Operations operations, AccountDAO accountDAO) {
        int option;
        Optional<Account> account = accountIdentifier(accountDAO);

        if (account.isPresent()) {
            do {
                option = readInt("1.Sacar\n2.Depositar\n3.Transferir\n4.Extrato");
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

    public static Optional<Account> accountIdentifier(AccountDAO accountDAO) {
        long accountNumber = readLong("Digite o número da conta:");
        Optional<Account> account = accountDAO.findById(accountNumber);
        return account;
    }

    public static void edit() {

    }

    public static void registerAccount(AccountDAO accountDAO, ClientDAO clientDAO) {
        int type = readInt("Tipo da conta: ");
        double balance = readDouble("Saldo Inicial:");
        double maxOverdraft = readDouble("Limite da conta:");
        Optional<Client> optionalClient;
        long fkClient;
        do {
            fkClient = readLong("Id do cliente");
            optionalClient = clientDAO.findById(fkClient);
            if (optionalClient.isPresent()) {
                Account account = new Account(optionalClient.get(), balance, maxOverdraft, type);
                accountDAO.insert(account);
            } else {
                showMessage("Id inserido Inválido");
            }
        } while (optionalClient.isEmpty());
    }

    public static void registerClient(ClientDAO clientDAO) {
        String clientName = read("Nome: ");
        String clientCPF;
        do {
            clientCPF = read("CPF (Somente Números: ");
            if (!valida(clientCPF))
                showMessage("CPF inválido, por favor digite novamente");
        } while (!valida(clientCPF));
        Client client = new Client(clientName, clientCPF);
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

