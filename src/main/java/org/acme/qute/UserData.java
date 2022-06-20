package org.acme.qute;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<Permission> permissions = new ArrayList<>();
    private String authentication;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public enum Permission {
        ALL
    }
}
