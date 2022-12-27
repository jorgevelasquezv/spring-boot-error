package co.com.jorge.springboot.error.app.services;

import co.com.jorge.springboot.error.app.models.domain.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl() {
        this.users = Arrays.asList(
                new User(1, "Isaac", "Velásquez"),
                new User(2, "Jorge", "Velásquez"),
                new User(3, "Katherine", "Caceres"),
                new User(4, "Apolo", "Mascota"),
                new User(5, "Pablo", "Marmol")
        );
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Optional<User> getByIdOptional(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findAny();
    }


}
