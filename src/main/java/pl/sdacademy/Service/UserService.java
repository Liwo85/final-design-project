package pl.sdacademy.service;

import pl.sdacademy.model.User;

public interface UserService {

    boolean existsByUsername (String username);

    void save(User user);
}
