package com.eukolos.arcadeblog.repository;

import com.eukolos.arcadeblog.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
