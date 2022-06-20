package org.acme.qute.services;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.WildFlyElytronPasswordProvider;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecurityUtil {

    public String hashPassword(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    public Boolean verifyBcryptPassword(String passwordHash, String password) throws Exception {
        WildFlyElytronPasswordProvider provider = new WildFlyElytronPasswordProvider();

        PasswordFactory pwFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);

        Password decodedPassword = ModularCrypt.decode(passwordHash);

        Password restoredPassword = pwFactory.translate(decodedPassword);

        return pwFactory.verify(restoredPassword, password.toCharArray());
    }

}
