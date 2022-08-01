package com.eukolos.arcadeblog.service;

import ch.qos.logback.core.net.AutoFlushingObjectWriter;
import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountModel save(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }
}
