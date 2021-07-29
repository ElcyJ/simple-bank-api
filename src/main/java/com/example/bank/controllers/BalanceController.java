package com.example.bank.controllers;

import com.example.bank.models.Account;
import com.example.bank.models.AccountResponse;
import com.example.bank.models.Balance;
import com.example.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/balance")
public class BalanceController {
    private final AccountService accountService;
    @Autowired
    public BalanceController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> showBalance(@RequestBody Balance balance){
        Account account = accountService.findAccountByNumber(balance.getAccountNumber());
        balance.setBalance(account.getBalance());

        return new ResponseEntity<>(new Balance(balance.getAccountNumber(),
                balance.getBalance()), HttpStatus.OK);
    }
}
