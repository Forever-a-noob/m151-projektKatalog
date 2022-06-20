package org.acme.qute.rest;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.acme.qute.services.RegisterService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class RegisterResource {

    @Inject
    RegisterService registerService;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance register(boolean successfulLogin);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)
    public TemplateInstance register(String username, String password){
        return LoginResource.Templates.login(registerService.register(username, password));
    }
}
