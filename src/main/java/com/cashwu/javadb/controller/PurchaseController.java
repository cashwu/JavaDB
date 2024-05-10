package com.cashwu.javadb.controller;

import com.cashwu.javadb.model.Purchase;
import com.cashwu.javadb.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/09
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {

        purchaseRepository.storePurchase(purchase);

    }

    @GetMapping
    public List<Purchase> findPurchase() {

        return purchaseRepository.findAllPurchases();

    }
}
