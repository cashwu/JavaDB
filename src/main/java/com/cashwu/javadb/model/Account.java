package com.cashwu.javadb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Data
public class Account {

    @Id
    private int id;
    private String name;
    private BigDecimal amount;
}
