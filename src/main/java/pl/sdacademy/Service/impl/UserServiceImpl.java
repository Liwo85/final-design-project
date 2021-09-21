package pl.sdacademy.Service.impl;

import org.springframework.stereotype.Service;
import pl.sdacademy.Service.UserService;
import pl.sdacademy.model.User;
import pl.sdacademy.repository.UserRepository;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

       public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }

}

