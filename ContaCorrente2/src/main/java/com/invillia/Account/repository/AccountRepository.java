package com.invillia.Account.repository;

import com.invillia.Account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {

    List<Account> findAllByOrderByIdAsc();

}
