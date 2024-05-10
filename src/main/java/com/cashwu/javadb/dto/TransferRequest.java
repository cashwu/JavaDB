package com.cashwu.javadb.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Data
public class TransferRequest {

    private int senderId;
    private int receiverId;
    private BigDecimal amount;
}
