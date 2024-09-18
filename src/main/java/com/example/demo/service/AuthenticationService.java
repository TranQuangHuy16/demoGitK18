package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.exception.DuplicateEntity;
import com.example.demo.repository.AccountRepository;
import jakarta.validation.ConstraintDeclarationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // đánh dấu đây là class cho service
public class AuthenticationService {

    @Autowired
    AccountRepository accountRepository;

    public Account register(Account account) {
        // => pass vòng validation
        try {
            Account newAccount = accountRepository.save(account);
            return newAccount;
        } catch (Exception e) {
            if (e.getMessage().contains(account.getCode())) {
                throw new DuplicateEntity("Duplicate code");
            } else  {
                throw new DuplicateEntity("Duplicate email");
            }
        }

    }

    public List<Account> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    public Account login(Account account) {
        return null;
    }
}
