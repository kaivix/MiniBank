package com.kaivix.mini_bank.Repositories;

import com.kaivix.mini_bank.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Override
    Optional<Card> findById(Long card);
}
