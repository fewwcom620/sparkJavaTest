package model.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by steve on 2015/9/13.
 */
public class UserService {
    private List<User> users = Arrays.asList(
            new User("101", "steve1", "steve@test.com"),
            new User("102", "steveSon", "steveson@test.com"));

    // returns a list of all users
    public List<User> getAllUsers() {
        return users;
    }

    // returns a single user by id
    public Optional<User> getUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    // creates a new user
    public User createUser(String name, String email) {
        User maxIdUser = users.stream()
                .sorted((user1, user2) ->
                        Integer.compare(Integer.parseInt(user2.getId()),
                                Integer.parseInt(user1.getId())))
                .findFirst()
                .get();
        int maxId = Integer.parseInt(maxIdUser.getId());
        User newUser = new User(String.valueOf(maxId + 1), name, email);
//        addUser(newUser);
        return newUser;
    }

    // updates an existing user
    public User updateUser(String id, String name, String email) {
        User user = getUser(id).get();
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    private void addUser(User user) {
        this.users.add(user);
    }

    private List<User> users() {
        return users;
    }
}
