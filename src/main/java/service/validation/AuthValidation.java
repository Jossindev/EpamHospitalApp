package service.validation;

import model.entity.User;
import service.impl.UserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthValidation {
    UserService userService = new UserService();

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,15}$";

    public boolean login(String username, String rawPassword, HttpSession session) {
        Optional<User> user = userService.signIn(username, rawPassword);

        if(!user.isPresent()) {
            return false;
        }

        if (username == null || rawPassword == null) {
            return false;
        }


        session.setAttribute("role", user.get().getRoleId().getName());
        session.setAttribute("user_id", user.get().getId());
        return true;
    }


    public boolean register(User user, String confirmPassword) {
        if (user.getName() == null || user.getSurname() == null || user.getBirthday() == null
                || user.getEmail() == null || user.getPassword() == null || user.getRoleId() == null) {
            return false;
        }

        if (!user.getPassword().equals(confirmPassword)) {
            return false;
        }

        Matcher emailMatcher = Pattern.compile(EMAIL_REGEX).matcher(user.getEmail());
        Matcher passwordMatcher = Pattern.compile(PASSWORD_REGEX).matcher(user.getPassword());
        if (emailMatcher.matches() && passwordMatcher.matches()) {
            return userService.registerUser(user);
        } else {
            return false;
        }
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
