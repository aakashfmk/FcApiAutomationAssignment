package org.fancode;

import org.fancode.models.User;
import org.fancode.models.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FcApiTest {

    private static final Logger logger = LoggerFactory.getLogger(FcApiTest.class);

    @Test
    public void testTodoCompletionPercentage() {
        List<User> users = ApiUtils.getUsers();
        List<Todo> todos = ApiUtils.getTodos();

        List<User> fanCodeUsers = new ArrayList<>();
        for (User user : users) {
            if (ApiUtils.isFanCodeCity(user)) {
                fanCodeUsers.add(user);
            }
        }

        for (User user : fanCodeUsers) {
            List<Todo> userTodos = new ArrayList<>();
            for (Todo todo : todos) {
                if (todo.getUserId() == user.getId()) {
                    userTodos.add(todo);
                }
            }

            double completionPercentage = ApiUtils.calculateCompletionPercentage(userTodos);
            logger.info("User ID: {}, Completion Percentage: {}", user.getId(), completionPercentage);
            Assert.assertTrue("User ID: " + user.getId() + " has less than 50% tasks completed",
                    completionPercentage > 50);
        }
    }
}
