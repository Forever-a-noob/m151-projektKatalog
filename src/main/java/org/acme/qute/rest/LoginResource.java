package org.acme.qute.rest;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.acme.qute.services.LoginService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginResource {

    @Inject
    LoginService loginService;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance login(boolean successfulLogin);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)
    public TemplateInstance logIn(String username, String password){
        return Templates.login(loginService.login(username, password));
    }
}
