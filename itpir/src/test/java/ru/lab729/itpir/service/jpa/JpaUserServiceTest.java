package ru.lab729.itpir.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import ru.lab729.itpir.service.AbstractJpaUserServiceTest;

import static ru.lab729.itpir.Profiles.JPA;

@ActiveProfiles(JPA)
class JpaUserServiceTest extends AbstractJpaUserServiceTest {
}