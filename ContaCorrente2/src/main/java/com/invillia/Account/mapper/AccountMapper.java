package com.invillia.Account.mapper;

import com.invillia.Account.model.Account;
import com.invillia.Account.model.request.AccountRequest;
import com.invillia.Account.model.response.AccountResponse;
import com.invillia.Account.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    public Account accountRequestToAccount(AccountRequest accountRequest) {
        Account account = new Account();
        account.setAvailableOverdraft(accountRequest.getAvailableOverdraft());
        account.setBalance(accountRequest.getBalance());
        account.setMaxOverdraft(accountRequest.getMaxOverdraft());
        return account;
    }

    public AccountResponse accountToAccountResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setAvailableOverdraft(account.getAvailableOverdraft());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setMaxOverdraft(account.getMaxOverdraft());

        return accountResponse;
    }

    public List<AccountResponse> accountToAccountResponse(List<Account> accounts) {
        ArrayList<AccountResponse> accountResponses= new ArrayList<AccountResponse>();
        for (Account account : accounts ) {
            accountResponses.add(accountToAccountResponse(account));
        }
        return accountResponses;
    }

    public void updateAccountByAccountRequest(Account account, AccountRequest accountRequest) {
        account.setMaxOverdraft(accountRequest.getMaxOverdraft());
        account.setBalance(accountRequest.getBalance());
        account.setAvailableOverdraft(accountRequest.getAvailableOverdraft());
    }
}
