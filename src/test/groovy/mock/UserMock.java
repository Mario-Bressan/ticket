package mock;

import com.delogic.ticket.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMock {

    public static List<User> USERS = getUsers();

    public static List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder().id((long) i).build();
            users.add(user);
        }
        return users;
    }
}
