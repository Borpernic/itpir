package ru.lab729.itpir.service;


import ru.lab729.itpir.model.User;
import ru.lab729.itpir.to.UserTo;
import ru.lab729.itpir.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void update(UserTo user);

    List<User> getAll();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}