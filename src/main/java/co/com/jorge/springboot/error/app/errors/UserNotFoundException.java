package co.com.jorge.springboot.error.app.errors;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String id) {
        super("Usuario con id: ".concat(id).concat(" no existe en el sistema"));
    }
}
