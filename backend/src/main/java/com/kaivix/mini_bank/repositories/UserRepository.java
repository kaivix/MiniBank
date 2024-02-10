package com.kaivix.mini_bank.repositories;

import com.kaivix.mini_bank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Long, User> {
    Optional<Long> findById(Long id);
}
