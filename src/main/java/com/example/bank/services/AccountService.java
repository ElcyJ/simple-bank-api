package com.example.bank.services;

import com.example.bank.models.Account;
import com.example.bank.models.User;
import com.example.bank.repositories.AccountRepository;
import com.example.bank.repositories.UserRepository;
import com.example.bank.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addNewAccount(Account account) {
        Account numberExists = accountRepository.existsByNumber(account.getNumber());

        if(numberExists != null) {
            throw new IllegalStateException("Numero de conta já utilizado");
        }
        accountRepository.save(account);
    }
}
