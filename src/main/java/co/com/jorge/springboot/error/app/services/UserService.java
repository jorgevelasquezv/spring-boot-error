package co.com.jorge.springboot.error.app.services;

import co.com.jorge.springboot.error.app.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    User getById(Integer id);

    Optional<User> getByIdOptional (Integer id);
}
