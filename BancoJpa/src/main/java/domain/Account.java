package domain;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_number")
    private long accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable=false)
    private Client client;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "overdraft_limit", nullable = false)
    private double overdraft;

    @Column(name = "type", nullable = false)
    private int type;

    public Account() {
    }

    public Account(Client client, double balance, double overdraft, int type) {
        this.client = client;
        this.balance = balance;
        this.overdraft = overdraft;
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("accountNumber=" + accountNumber)
                .add("client=" + client)
                .add("balance=" + balance)
                .add("overdraft=" + overdraft)
                .add("type=" + type)
                .toString();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
