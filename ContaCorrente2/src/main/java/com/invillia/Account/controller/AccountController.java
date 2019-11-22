package com.invillia.Account.controller;

import com.invillia.Account.model.Account;
import com.invillia.Account.model.request.AccountRequest;
import com.invillia.Account.model.response.AccountResponse;
import com.invillia.Account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Controller
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll() {
        return accountService.findAll();
    }
    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> insert(@Valid @RequestBody AccountRequest accountRequest) {
        Long id = accountService.insert(accountRequest);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path(("/accounts/{id}")).build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, @Valid @RequestBody AccountRequest accountRequest) {
        accountService.update(id,accountRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
