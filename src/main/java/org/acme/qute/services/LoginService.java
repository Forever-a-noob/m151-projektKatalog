package org.acme.qute.services;

import org.acme.qute.entities.UserEntity;
import org.acme.qute.services.SecurityUtil;
import org.acme.qute.services.UserService;
import org.acme.qute.services.UserSession;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginService {

    @Inject
    UserService userService;
    @Inject
    UserSession userSession;
    @Inject
    SecurityUtil securityUtil;

    public boolean login(String username, String password) {
        try {
            UserEntity user = userService.getUserByUsername(username);
            if (securityUtil.verifyBcryptPassword(user.getPassword(), password)) {
                userSession.setUsername(username);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
