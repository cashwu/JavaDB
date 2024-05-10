package com.cashwu.javadb.repository;

import com.cashwu.javadb.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet,
                          int rowNum) throws SQLException {

        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }
}
