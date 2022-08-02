package com.eukolos.arcadeblog.repository;

import com.eukolos.arcadeblog.model.AuthorityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityModel, String> {
}
