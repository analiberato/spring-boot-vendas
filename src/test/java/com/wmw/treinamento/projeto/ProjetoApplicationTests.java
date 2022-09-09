package com.wmw.treinamento.projeto;

import com.wmw.treinamento.projeto.controller.PedidoAPITeste;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(classes = PedidoAPITeste.class)
@Profile("test")
class ProjetoApplicationTests {

	@Test
	void contextLoads() {
	}

}
