package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void createUser(User user);
    User readUserById(int id);
    void updateUser(User user);
    void deleteUserById(int id);

}
