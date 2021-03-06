package com.example.billing.service.service;

import com.example.billing.service.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.billing.service.utils.AbstractIntegrationTest;

//TODO: пока что такие говенные тесты
public class UserServiceTests extends AbstractIntegrationTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        var user = new User();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");
        user.setBalance(0d);

        var result = userService.addUser(user);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(user.getName(), result.getName());
        Assertions.assertEquals(user.getSurname(), result.getSurname());
    }

    @Test
    public void testUpdateUser() {
        var user = new User();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");
        user.setBalance(0d);

        var addResult = userService.addUser(user);
        Assertions.assertNotNull(addResult);
        Assertions.assertNotNull(addResult.getId());
        Assertions.assertEquals(user.getName(), addResult.getName());
        Assertions.assertEquals(user.getSurname(), addResult.getSurname());

        final String newName = "Олег";
        addResult.setName(newName);

        var updateResult = userService.updateUser(addResult);
        Assertions.assertNotNull(updateResult);
        Assertions.assertNotNull(updateResult.getId());
        Assertions.assertEquals(newName, updateResult.getName());
        Assertions.assertEquals(user.getSurname(), updateResult.getSurname());
    }

    @Test
    public void testGetUser() {
        var user = new User();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");
        user.setBalance(0d);

        var addResult = userService.addUser(user);
        Assertions.assertNotNull(addResult);
        Assertions.assertNotNull(addResult.getId());
        Assertions.assertEquals(user.getName(), addResult.getName());
        Assertions.assertEquals(user.getSurname(), addResult.getSurname());

        var getResult = userService.getUser(addResult.getId());
        Assertions.assertNotNull(getResult);
        Assertions.assertNotNull(getResult.getId());
        Assertions.assertEquals(user.getName(), getResult.getName());
        Assertions.assertEquals(user.getSurname(), getResult.getSurname());
    }

    @Test
    public void testDeleteUser() {
        var user = new User();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");
        user.setBalance(0d);

        var addResult = userService.addUser(user);
        Assertions.assertNotNull(addResult);
        Assertions.assertNotNull(addResult.getId());
        Assertions.assertEquals(user.getName(), addResult.getName());
        Assertions.assertEquals(user.getSurname(), addResult.getSurname());

        var deleteResult = userService.deleteUser(addResult.getId());
        Assertions.assertEquals(addResult.getId(), deleteResult);
    }
}
