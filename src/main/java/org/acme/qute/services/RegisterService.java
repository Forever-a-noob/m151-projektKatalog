package org.acme.qute.services;

import org.acme.qute.entities.UserEntity;
import org.acme.qute.repositories.UserRepository;

import javax.inject.Inject;

public class RegisterService {
    @Inject
    UserRepository userRepository;

    public boolean register(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        try{
            userRepository.persist(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
