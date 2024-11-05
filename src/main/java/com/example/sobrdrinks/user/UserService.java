package com.example.sobrdrinks.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String rfId, String name, String email) {
        User user = new User();
        user.setRfId(rfId);
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User getUser(String rfId) {
        return userRepository.findByRfId(rfId).orElse(null);
    }

    public User updateUser(String rfId, String name, String email) {
        User user = userRepository.findByRfId(rfId).orElse(null);
        if (user == null) {
            return null;
        }
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void deleteUser(String rfId) {
        userRepository.deleteByRfId(rfId);
    }
}
