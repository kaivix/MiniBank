package com.kaivix.mini_bank.Service;

import com.kaivix.mini_bank.Models.Users;
import com.kaivix.mini_bank.Repositories.RoleRepository;
import com.kaivix.mini_bank.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//User service actions

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;



    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Users findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void save(Users users){
        users.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
        userRepository.save(users);
        System.out.println("Register user successfully!");
    }

    public Optional<Users> findByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = findByName(username).orElseThrow(() -> new UsernameNotFoundException(String.format("not found", username)));
        return new User(users.getUsername(), users.getPassword(),
                users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }
}
