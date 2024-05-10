package com.cashwu.javadb.services;

import com.cashwu.javadb.model.Account;
import com.cashwu.javadb.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal amount) {

        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount()
                                    .subtract(amount);

        BigDecimal receiverNewAmount = receiver.getAmount()
                                      .add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("oh shit ~");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
