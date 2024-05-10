package com.cashwu.javadb.services;

import com.cashwu.javadb.exceptions.AccountNotFoundException;
import com.cashwu.javadb.model.Account;
import com.cashwu.javadb.repository.AccountSpringDataRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@Service
public class TransferSpringDataService {

    private final AccountSpringDataRepository repo;

    public TransferSpringDataService(AccountSpringDataRepository accountSpringDataRepository) {
        this.repo = accountSpringDataRepository;
    }

    @SneakyThrows
    @Transactional
    public void transferAmount(int idSender,
                               int idReceiver,
                               BigDecimal amount) {

        Account sender = repo.findById(idSender)
                             .orElseThrow(AccountNotFoundException::new);

        Account receiver = repo.findById(idReceiver)
                               .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount()
                                           .subtract(amount);

        BigDecimal receiverNewAmount = receiver.getAmount()
                                               .add(amount);

        repo.changeAmount(idSender, senderNewAmount);
        repo.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return repo.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return repo.findAccountsByName(name);
    }
}

