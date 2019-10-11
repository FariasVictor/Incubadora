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

    @Column(name = "available_overdraft", nullable = false)
    private double availableOverdraft;

    @Column(name="max_overdraft", nullable = false)
    private double maxOverdraft;

    @Column(name = "type", nullable = false)
    private int type;

    public Account() {
    }

    public Account(Client client, double balance, double maxOverdraft, int type) {
        this.client = client;
        this.balance = balance;
        this.maxOverdraft=maxOverdraft;
        this.availableOverdraft = maxOverdraft;
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("accountNumber=" + accountNumber)
                .add("client=" + client)
                .add("balance=" + balance)
                .add("availableOverdraft=" + availableOverdraft)
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

    public double getAvailableOverdraft() {
        return availableOverdraft;
    }

    public void setAvailableOverdraft(double availableOverdraft) {
        this.availableOverdraft = availableOverdraft;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }
}
