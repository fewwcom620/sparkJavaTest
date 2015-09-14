package controller.user; /**
 * Created by steve on 2015/9/13.
 */


import controller.user.UserController;
import model.user.User;
import model.user.UserService;

import java.util.Arrays;

import static spark.Spark.*;

public class CRUD {
    public static void main(String[] args) {
        new UserController(new UserService());
    }
}
