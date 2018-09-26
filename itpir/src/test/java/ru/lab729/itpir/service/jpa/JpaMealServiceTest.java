package ru.lab729.itpir.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import ru.lab729.itpir.service.AbstractMealServiceTest;

import static ru.lab729.itpir.Profiles.JPA;

@ActiveProfiles(JPA)
class JpaMealServiceTest extends AbstractMealServiceTest {
}