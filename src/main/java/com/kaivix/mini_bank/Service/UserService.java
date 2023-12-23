package com.kaivix.mini_bank.Service;

import com.kaivix.mini_bank.Models.Users;
import com.kaivix.mini_bank.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getOne(Long id){
        Optional<Users> st = userRepository.findById(id);
        return st.orElse(null);
    }

    public void save(Users users){
        userRepository.save(users);
    }

}
