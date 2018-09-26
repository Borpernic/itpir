package ru.lab729.itpir.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.lab729.itpir.service.AbstractMealServiceTest;

import static ru.lab729.itpir.Profiles.JDBC;

@ActiveProfiles(JDBC)
class JdbcMealServiceTest extends AbstractMealServiceTest {
}