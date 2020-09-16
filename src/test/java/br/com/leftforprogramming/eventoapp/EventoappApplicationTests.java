package br.com.leftforprogramming.eventoapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventoappApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class EventoappApplicationTests {

	@Test
	void contextLoads() {
	}

}
