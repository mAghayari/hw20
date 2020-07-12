package service;

import dao.UserDao;

import java.util.Objects;

public class UserValidation {

    public boolean UserNameHasBeenTaken(String userName) {
        UserDao userDao = new UserDao();
        String result = userDao.checkUserNameRepetition(userName);
        return Objects.nonNull(result);
    }

    public boolean emailHasBeenTaken(String email) {
        UserDao userDao = new UserDao();
        String result = userDao.checkEmailRepetition(email);
        return Objects.nonNull(result);
    }

    public boolean mobileHasBeenTaken(String mobile) {
        UserDao userDao = new UserDao();
        String result = userDao.checkMobileRepetition(mobile);
        return Objects.nonNull(result);
    }
}