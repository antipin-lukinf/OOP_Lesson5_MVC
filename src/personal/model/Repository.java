package personal.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String createUser(User user, String command);

    void updUser(User user);

    void delitUser(String id);
}
