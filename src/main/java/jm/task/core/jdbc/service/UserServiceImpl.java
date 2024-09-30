package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Была создана таблица\"UserTo\".");
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Таблица\"UserTo\" была удалена.");

    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем: " + name + "Фамилией: " + lastName + " и возрастом - " + age + " добавлен в таблицу UserTo.");
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
        System.out.println(id+"-й User удалён из таблицы UserTo.");

    }

    public List<User> getAllUsers() {
        System.out.println("Весь список UserTo.");
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Таблица UserTo очищена.");

    }
}