package org.fancode;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.fancode.models.User;
import org.fancode.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApiUtils {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    public static List<User> getUsers() {
        Response response = RestAssured.get(BASE_URL + "/users");
        return response.as(new TypeRef<List<User>>() {
        });
    }

    public static List<Todo> getTodos() {
        Response response = RestAssured.get(BASE_URL + "/todos");
        return response.as(new TypeRef<List<Todo>>() {
        });
    }

    public static boolean isFanCodeCity(User user) {
        double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
        double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
        return lat > -40 && lat < 5 && lng > 5 && lng < 100;
    }

    public static double calculateCompletionPercentage(List<Todo> todos) {
        int totalTodos = todos.size();
        int completedTodos = 0;
        for (Todo todo : todos) {
            if (todo.isCompleted()) {
                completedTodos++;
            }
        }
        logger.debug("Total Todos: {}, Completed Todos: {}",
                totalTodos, completedTodos);
        return (completedTodos * 100.0) / totalTodos;
    }
}

