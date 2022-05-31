package it.f2informatica.questionari;

import it.f2informatica.questionari.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DomandeControllerTest.class,
        QuestionarioControllerTest.class,
        QuestionarioUtenteControllerTest.class,
        RisposteUtenteControllerTest.class,
        UtenteControllerTest.class})
class GestionequestionariSpringApplicationTests {

    @Test
    void contextLoads() {
    }

}
