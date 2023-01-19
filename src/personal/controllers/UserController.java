package personal.controllers;

import personal.model.Repository;
import personal.model.User;

import java.util.List;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user, String command) throws Exception{
        validateUser(user);
        repository.createUser(user, command);
    }

    public void delUser(String id) throws Exception{
        //validateUser(id);
        repository.delitUser(id);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }

    public List<User> readList() {
        return repository.getAllUsers();
    }

    public void updUser(String idNumber, User newGue) throws Exception {
        idPresenceValidation(idNumber);
        newGue.setId(idNumber);
        validateUserId(newGue);
        repository.updUser(newGue);

    }

    private void validateUser(User user) throws Exception {

        if (user.getFirstName().isEmpty()) throw new Exception("User has no FirstName");
        if (user.getLastName().isEmpty()) throw new Exception("User has no LastName");
        if (user.getFirstName().contains(" ")) throw new Exception("User name has unacceptable characters");
        if (user.getLastName().contains(" ")) throw new Exception("User name has unacceptable characters");
        if (user.getPhone().isEmpty()) throw new Exception("User lastname has unacceptable characters");

    }
    private void validateUserId (User user) throws Exception {
        if (user.getId().isEmpty()) throw new Exception("User has no id");
        validateUser(user);
    }

    public void idPresenceValidation (String inputId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User u : users){
            if(u.getId().equals(inputId))
                return;
        }
        throw new Exception("No such Id here");
    }


}
