//package repositories;
//
//import entities.UserEntity;
//import entities.UserNotFoundException;
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//
//import javax.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class UserRepository implements PanacheRepository<UserEntity> {
//
//    public UserEntity getUserByUsername(String username) {
//        UserEntity user = find("username", username).firstResult();
//
//        if (user != null) {
//            return user;
//        }
//        throw new UserNotFoundException(username);
//    }
//}
