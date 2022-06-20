package org.acme.qute.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.acme.qute.entities.ItemEntity;
import org.acme.qute.repositories.ItemRepository;

@Path("items")
public class ItemResource {

    @Inject
    ItemRepository itemRepository;

    @CheckedTemplate
    static class Templates {
        
        static native TemplateInstance items(List<ItemEntity> items);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return Templates.items(itemRepository.getAllItems());
    }
}
