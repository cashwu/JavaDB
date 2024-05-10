package com.cashwu.javadb.model;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Data
public class Purchase {

    private int id;

    private String product;

    private BigDecimal price;
}

