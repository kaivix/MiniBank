package com.kaivix.mini_bank.Service;

import com.kaivix.mini_bank.Models.Users;
import com.kaivix.mini_bank.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public Users updateUser(Users user) {
        // проверить, что пользователь существует в базе данных по id
        // обновить данные пользователя в базе данных с помощью userRepository
        // вернуть пользователя
        return user;
    }

    public void deleteUser(Long id) {
        // проверить, что пользователь существует в базе данных по id
        // удалить пользователя из базы данных с помощью userRepository
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // найти пользователя в базе данных по имени пользователя с помощью userRepository
        // если пользователь не найден, выбросить исключение UsernameNotFoundException
        // создать объект UserDetails, который содержит данные пользователя, такие как username, password, authorities и т.д.
        // вернуть объект UserDetails
        return null;
    }

    public void save(Users users){
        userRepository.save(users);
    }

}
