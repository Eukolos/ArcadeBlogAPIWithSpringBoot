package com.eukolos.arcadeblog.repository;

import com.eukolos.arcadeblog.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    Optional<AccountModel> findOneByEmail(String email);

}
