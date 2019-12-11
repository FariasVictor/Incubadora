package com.invillia.Account.integration;

import com.invillia.Account.Response;
import com.invillia.Account.factory.AccountFactory;
import com.invillia.Account.model.Account;
import com.invillia.Account.repository.AccountRepository;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAccountByIdTest {

    private AccountRepository accountRepository;
    private AccountFactory accountFactory;

    @Autowired
    public FindAccountByIdTest(AccountRepository accountRepository, AccountFactory accountFactory) {
        this.accountRepository = accountRepository;
        this.accountFactory = accountFactory;
    }

    @Test
    public void FindByIdWithSuccess(){
        Account account = accountFactory.create();

        accountRepository.findById(account.getId());

        RestAssured.
                given().log().all()
                .when().get("/1")
                .then().log().all().statusCode(SC_OK)
                .body("id", Matchers.is(1))
                .body("availableOverdraft", Matchers.is((float)account.getAvailableOverdraft()))
                .body("balance", Matchers.is((float)account.getBalance()))
                .body("maxOverdraft", Matchers.is((float)account.getMaxOverdraft()));
    }

    @Test
    public void FindByIdNotFound(){
//        Account account= accountFactory.create();

        RestAssured
                .given().log().all()
                .when().get("/2")
                .then().log().all()
                .specification(Response.notFound());
    }
}
