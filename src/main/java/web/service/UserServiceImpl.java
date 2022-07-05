package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User readUserById(int id) {
        return userDAO.readUserById(id);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) { userDAO.updateUser(user);}

    @Override
    @Transactional
    public void deleteUserById(int id) { userDAO.deleteUserById(id); }
}
