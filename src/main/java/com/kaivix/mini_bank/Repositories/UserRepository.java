package com.kaivix.mini_bank.Repositories;

import com.kaivix.mini_bank.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
}
