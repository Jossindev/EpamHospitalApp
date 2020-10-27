package serviceTest;

import model.entity.Role;
import model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.UserService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
    @Mock
    private UserService userService;

    User user;
    List<User> users = new ArrayList<>();

    @Before
    public void setUp() {
       user = new User("ihor", "Ivanov", Date.valueOf("2012-01-01"),
                "gg@gmail.com", "1111", new Role(1));
       users.add(user);
    }

    @Test
    public void findAllUsersTest() { Mockito.when(userService.getAllUsers()).thenReturn(users); }

    @Test
    public void registerUserTest() {
        Mockito.when(userService.registerUser(user)).thenReturn(true);
    }


    @Test
    public void findUserByIdTest() {
        Mockito.when(userService.getUserById(1)).thenReturn(Optional.of(user));
    }

    @Test
    public void signInTest() {
        Mockito.when(userService.signIn("gg@gmail.com","1111")).thenReturn(Optional.of(user));
    }
}
