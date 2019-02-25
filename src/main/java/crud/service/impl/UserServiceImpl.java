package crud.service.impl;

import crud.dao.UserDao;
import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao usersDAO;

    @Override
    @Transactional
    public void addUser(User User) {
        this.usersDAO.addUser(User);
    }

    @Override
    @Transactional
    public void updateUser(User User) {
        this.usersDAO.updateUser(User);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.usersDAO.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.usersDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        List<User> list = this.usersDAO.listUsers();
        return list;
    }

    @Override
    public User getUserByUserName(String userName) {
        return usersDAO.getUserByUserName(userName);
    }
}