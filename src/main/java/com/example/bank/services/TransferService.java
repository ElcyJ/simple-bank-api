package com.example.bank.services;

import com.example.bank.models.Account;
import com.example.bank.models.Transfer;
import com.example.bank.repositories.AccountRepository;
import com.example.bank.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    public void addNewTransfer(Transfer transfer) {
        Account sourceAccount = accountRepository.findAccountByNumber(transfer.getSourceAccountNumber());
        Account destinationAccount = accountRepository.findAccountByNumber(transfer.getDestinationAccountNumber());

        if(sourceAccount == null) {
            throw new IllegalStateException("Conta de origem nao existe");
        }
        if(destinationAccount == null) {
            throw new IllegalStateException("Conta de destino nao existe");
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - transfer.getAmount());
        destinationAccount.setBalance(destinationAccount.getBalance() + transfer.getAmount());

        transferRepository.save(transfer);
    }
}
