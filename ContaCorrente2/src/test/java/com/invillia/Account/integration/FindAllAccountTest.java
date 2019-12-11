package com.invillia.Account.integration;

import com.invillia.Account.factory.AccountFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAllAccountTest {
    private final AccountFactory accountFactory;

    @Autowired
    public FindAllAccountTest(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    @Test
    public void findAllWithSuccess() {
        accountFactory.create(5);
        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/").
                then()
                    .log().all()
                    .statusCode(SC_OK)
                    .body("$", Matchers.hasSize(5));
    }
}
