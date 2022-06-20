package org.acme.qute.services;

import org.acme.qute.entities.UserEntity;
import org.acme.qute.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public UserEntity getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
