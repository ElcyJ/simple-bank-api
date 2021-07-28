package com.example.bank.repositories;

import com.example.bank.models.Account;
import com.example.bank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByNumber(String username);

    @Query("SELECT u FROM Account u WHERE u.number = :number")
    Account existsByNumber(@Param("number") String number);
}
