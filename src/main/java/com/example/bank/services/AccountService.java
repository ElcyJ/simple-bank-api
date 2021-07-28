package com.example.bank.services;

import com.example.bank.models.Account;
import com.example.bank.models.User;
import com.example.bank.repositories.AccountRepository;
import com.example.bank.repositories.UserRepository;
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
        Account accountOptional = accountRepository.findAccountByNumber(account.getNumber());

        /*if(userOptional.isPresent()) {
            throw new IllegalStateException("Email já utilizado");
        }*/
        accountRepository.save(account);
    }
}
