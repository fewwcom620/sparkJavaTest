package controller.user;

import model.error.ResponseError;
import model.user.User;
import model.user.UserService;
import model.json.JsonUtil;

import java.util.Optional;

import static spark.Spark.*;

/**
 * Created by steve on 2015/9/13.
 */
public class UserController {
    public UserController(final UserService userService) {
        get("users", (request, response) -> userService.getAllUsers()
                , JsonUtil.json());
        after((request, response) -> response.type("application/json"));

        get("users/:id", (request, response) -> {
            String id = request.params(":id");
            Optional<User> userOptional = userService.getUser(id);

            if (userOptional.isPresent()) {
                return userOptional.get();
            }

            response.status(400);
            return new ResponseError("No user with %s found", id);

        }, JsonUtil.json());

        put("/users/:id", (request, response) ->
                userService.updateUser(
                        request.params(":id"),
                        request.queryParams("name"),
                        request.queryParams("email"))
                , JsonUtil.json());

        post("/users", (request, response) ->
                userService.createUser(
                        request.queryParams("name"),
                        request.queryParams("email"))
                , JsonUtil.json());
    }
}
