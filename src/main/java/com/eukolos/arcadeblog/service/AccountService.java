package com.eukolos.arcadeblog.service;

import ch.qos.logback.core.net.AutoFlushingObjectWriter;
import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountModel save(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    public Optional<AccountModel> findByEmail(String email){
        return accountRepository.findOneByEmail(email);
    }
}
