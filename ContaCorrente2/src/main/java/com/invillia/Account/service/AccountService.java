package com.invillia.Account.service;

import com.invillia.Account.exception.AccountNotFoundException;
import com.invillia.Account.mapper.AccountMapper;
import com.invillia.Account.model.Account;
import com.invillia.Account.model.request.AccountRequest;
import com.invillia.Account.model.response.AccountResponse;
import com.invillia.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public Long insert(AccountRequest accountRequest){
        Account account=accountMapper.accountRequestToAccount(accountRequest);
        accountRepository.save(account);
        return account.getId();
    }

    public AccountResponse findById(long id){
        Account account=accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        AccountResponse accountResponse= accountMapper.accountToAccountResponse(account);
        return accountResponse;
    }
    public List<AccountResponse> findAll(){

        List<Account> accounts=accountRepository.findAll();
        List<AccountResponse> accountResponses=accountMapper.accountToAccountResponse(accounts);
        return accountResponses;
    }

    public void update(Long id, AccountRequest accountRequest){
        Account account= accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        accountMapper.updateAccountByAccountRequest(account,accountRequest);
        accountRepository.save(account);
    }

    public void delete(long id){
        Account account=accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        accountRepository.delete(account);
    }
}
