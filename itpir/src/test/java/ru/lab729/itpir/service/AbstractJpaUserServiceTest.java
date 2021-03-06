package ru.lab729.itpir.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lab729.itpir.model.Role;
import ru.lab729.itpir.model.User;
import ru.lab729.itpir.repository.JpaUtil;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Date;

abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest {

    @Autowired
    private JpaUtil jpaUtil;

    @BeforeEach
    @Override
    void setUp() throws Exception {
        super.setUp();
        jpaUtil.clear2ndLevelHibernateCache();
    }

    @Test
    void testValidation() {
        validateRootCause(() -> service.create(new User(null, "  ", "invalid@yandex.ru", "password", 2000, Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "  ", "password", 2000, Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "invalid@yandex.ru", "", 2000, Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "mail@yandex.ru", "password", 9, true, new Date(), Collections.emptySet())), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "mail@yandex.ru", "password", 10001, true, new Date(), Collections.emptySet())), ConstraintViolationException.class);
    }
}