package com.coldmorning.online.education.auth.repository;

import com.coldmorning.online.education.auth.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM User u WHERE u.email = ?1 and u.delete_time is null",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
