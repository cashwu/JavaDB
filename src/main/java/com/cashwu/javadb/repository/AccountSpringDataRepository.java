package com.cashwu.javadb.repository;

import com.cashwu.javadb.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Repository
public interface AccountSpringDataRepository extends CrudRepository<Account, Integer> {

    @Query("select * from account where name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("update account set amount = :amount where id = :id")
    void changeAmount(int id, BigDecimal amount);
}
