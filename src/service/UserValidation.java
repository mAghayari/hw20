package service;

import dao.UserDao;

import java.util.Objects;

public class UserValidation {

    public boolean UserNameHasBeenTaken(String userName) {
        UserDao userDao = new UserDao();
        String result = userDao.checkUserNameRepetition(userName);
        if (Objects.nonNull(result))
            return true;
        else
            return false;
    }

    public boolean emailHasBeenTaken(String email) {
        UserDao userDao = new UserDao();
        String result = userDao.checkEmailRepetition(email);
        if (Objects.nonNull(result))
            return true;
        else
            return false;
    }

    public boolean mobileHasBeenTaken(String mobile) {
        UserDao userDao = new UserDao();
        String result = userDao.checkMobileRepetition(mobile);
        if (Objects.nonNull(result))
            return true;
        else
            return false;
    }
}