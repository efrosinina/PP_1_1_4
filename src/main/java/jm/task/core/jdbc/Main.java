package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();
        user.createUsersTable();

        user.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println(user.getAllUsers().get(0));
        user.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println(user.getAllUsers().get(1));
        user.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println(user.getAllUsers().get(2));
        user.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println(user.getAllUsers().get(3));
        System.out.println(user.getAllUsers().toString());

        user.removeUserById(1);
        System.out.println(user.getAllUsers().toString());
        user.getAllUsers();
        System.out.println(user.getAllUsers().toString());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}