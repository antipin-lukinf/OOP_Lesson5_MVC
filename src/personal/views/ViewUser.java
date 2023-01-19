package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            try {
                switch (com) {
                    case CREATE:
                        String firstName = prompt("Имя: ");
                        String lastName = prompt("Фамилия: ");
                        String phone = prompt("Номер телефона: ");
                        String question = prompt("В каком формате сохранять?(введите 1, для сохранения с ,\n или 2, для сохранения с ;): ");
                        userController.saveUser(new User(firstName, lastName, phone), question);
                        break;
                    case READ:
                        String id = prompt("Идентификатор пользователя: ");

                        User user = userController.readUser(id);
                        System.out.println(user);

                        break;
                    case LIST:
                        List<User> lst = userController.readList();
                        lst.forEach(i -> System.out.println(i + "\n"));
                        break;
                    case UPDATE:
                        String numId = prompt("Какой контакт редактировать? Введите номер ID: ");
                        userController.idPresenceValidation(numId);
                        userController.updUser(numId, createAGuy());
                        break;
                    case DELETE:
                        String delNumId = prompt("Какой контакт удалять? Введите номер ID: ");
                        userController.idPresenceValidation(delNumId);
                        userController.delUser(delNumId);
                        break;


                }
            } catch (Exception e) {
                System.out.println("Oopsie!\n"+e.getMessage());;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private User createAGuy() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        User newGuy = new User(firstName, lastName, phone);
        return newGuy;
    }

}
