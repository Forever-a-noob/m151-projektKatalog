package org.acme.qute.services;

import io.quarkus.security.identity.SecurityIdentity;
import org.acme.qute.UserData;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@SessionScoped
public class UserSession implements Serializable {

    @Inject
    SecurityIdentity securityIdentity;

    private static final String USER_DATA_KEY = "userData";
    private static final String USERNAME_KEY = "usernameData";
    private final VaadinSession vaadinSession;

    public void setUserData(UserData userData) {
        vaadinSession.setAttribute(USER_DATA_KEY, userData);
    }

    public UserData getUserData() {
        Object userData = vaadinSession.getAttribute(USER_DATA_KEY);
        if (userData instanceof UserData) {
            return (UserData) userData;
        } else {
            return null;
        }
    }

    public void clearSession() {
        vaadinSession.getSession().invalidate();
    }

    public void setUsername(String username) {
        vaadinSession.setAttribute(USERNAME_KEY, username);
    }

    public String getUsername() {
        Object username = vaadinSession.getAttribute(USERNAME_KEY);
        if (username instanceof String) {
            return (String) username;
        } else {
            return null;
        }
    }
}
