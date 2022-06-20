package org.acme.qute.repositories;

import org.acme.qute.entities.ItemEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<ItemEntity> {

    public List<ItemEntity> getAllItems(){
        return listAll();
    }
}
