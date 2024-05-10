package com.cashwu.javadb.controller;

import com.cashwu.javadb.dto.TransferRequest;
import com.cashwu.javadb.model.Account;
import com.cashwu.javadb.services.TransferSpringDataService;
import org.springframework.web.bind.annotation.*;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@RestController
public class AccountController {

    private final TransferSpringDataService transferService;

    public AccountController(TransferSpringDataService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {

        //        transferService.transferMoney(request.getSenderId(), request.getReceiverId(), request.getAmount());
        transferService.transferAmount(request.getSenderId(), request.getReceiverId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        //        return transferService.getAllAccounts();

        if (name == null) {
            return transferService.getAllAccounts();
        }
        return transferService.findAccountsByName(name);
    }
}
