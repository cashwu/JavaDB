package com.cashwu.javadb.repository;

import com.cashwu.javadb.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";

        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(int id,
                             BigDecimal amount) {

        String sql = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}