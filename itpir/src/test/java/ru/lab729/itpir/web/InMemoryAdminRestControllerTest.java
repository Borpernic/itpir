package ru.lab729.itpir.web;

import org.junit.jupiter.api.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lab729.itpir.UserTestData;
import ru.lab729.itpir.model.User;
import ru.lab729.itpir.repository.mock.InMemoryUserRepositoryImpl;
import ru.lab729.itpir.util.exception.NotFoundException;
import ru.lab729.itpir.web.user.AdminRestController;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static ru.lab729.itpir.UserTestData.ADMIN;

class InMemoryAdminRestControllerTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminRestController controller;

    @BeforeAll
    static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminRestController.class);
    }

    @AfterAll
    static void afterClass() {
//        May cause during JUnit "Cache is not alive (STATUS_SHUTDOWN)" as JUnit share Spring context for speed
//        http://stackoverflow.com/questions/16281802/ehcache-shutdown-causing-an-exception-while-running-test-suite
//        appCtx.close();
    }

    @BeforeEach
    void setUp() {
        // re-initialize
        InMemoryUserRepositoryImpl repository = appCtx.getBean(InMemoryUserRepositoryImpl.class);
        repository.init();
    }

    @Test
    void testDelete() {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        assertEquals(users.size(), 1);
        assertEquals(users.iterator().next(), ADMIN);
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () -> controller.delete(10));
    }
}