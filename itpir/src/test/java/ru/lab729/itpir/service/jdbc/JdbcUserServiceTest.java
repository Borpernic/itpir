package ru.lab729.itpir.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.lab729.itpir.service.AbstractUserServiceTest;

import static ru.lab729.itpir.Profiles.JDBC;

@ActiveProfiles(JDBC)
class JdbcUserServiceTest extends AbstractUserServiceTest {
}