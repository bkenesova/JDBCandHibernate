package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

//        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Alex", "Markov", (byte) 98);
        userService.saveUser("Maya", "Kasenova", (byte) 10);
        userService.saveUser("Lily", "Brown", (byte) 32);
        userService.saveUser("Matronna", "Qween", (byte) 24);
        List<User> users = userService.getAllUsers();


        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }


}