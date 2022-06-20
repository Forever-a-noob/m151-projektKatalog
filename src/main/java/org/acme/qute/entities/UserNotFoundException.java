package entities;

import javax.ws.rs.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
