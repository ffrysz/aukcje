package org.aukcje.user;


import java.util.List;

public class UserService {

    public void saveUser(User user) {
       user.persist();
    }

    public List<User> getAll() {
        return User.listAll();
    }

    public User findById(Long id) {
        return User.findById(id);
    }

    public void deleteById(Long id) {
        User.deleteById(id);
    }

    public boolean emailAlreadyExists(String email) {
        return User.count("email", email) != 0;
    }
}
