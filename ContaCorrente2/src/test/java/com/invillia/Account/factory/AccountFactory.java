package com.invillia.Account.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.Account.model.Account;
import com.invillia.Account.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory extends JBacon<Account> {
    private final AccountRepository accountRepository;

    private final Faker faker;

    @Autowired
    public AccountFactory(AccountRepository accountRepository, Faker faker) {
        this.accountRepository = accountRepository;
        this.faker = faker;
    }

    @Override
    protected Account getDefault() {
        final Account account=new Account();

        account.setId(1L);
        account.setAvailableOverdraft(faker.number().randomDouble(2,1, 250000));
        account.setBalance(faker.number().randomDouble(2,1,Integer.MAX_VALUE));
        account.setMaxOverdraft(faker.number().randomDouble(2, (int) account.getAvailableOverdraft(),250000));
        return account;
    }

    @Override
    protected Account getEmpty() {
        return new Account();
    }

    @Override
    protected void persist(Account account) {
        accountRepository.save(account);
    }
}
