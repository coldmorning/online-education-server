package com.coldmorning.online.education.repository;

import com.coldmorning.online.education.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AuthRepository extends JpaRepository<User, Long> {
}
