package service;

import model.User;

import javax.servlet.ServletRequest;

public class UserFactory {
    public User userFactory(ServletRequest request) {
        User user = new User();
        user.setFirstName(request.getParameter("fName"));
        user.setLastName(request.getParameter("lName"));
        user.setEmail(request.getParameter("email"));
        user.setMobileNumber(request.getParameter("mobile"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setGender(request.getParameter("gender"));
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}