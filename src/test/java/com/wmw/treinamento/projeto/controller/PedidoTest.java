package com.wmw.treinamento.projeto.controller;

import com.wmw.treinamento.projetovendas.ProjetoApplication;
import com.wmw.treinamento.projetovendas.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ProjetoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PedidoTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private PedidoRepository pedidoRepository;

//    @Autowired
//    private TestEntityManager entityManager;

    @Test
    public void deveriaDevolver200CasoDadosSejamPersistidosCorretamentePost() throws Exception {
        URI uri = new URI("/pedidos");

        String json = "{\"id\":\"3\",\"idCliente\":\"1\",\"dataEmissao\":\"2022-06-04\",\"dataEntrega\":\"2022-06-07\",\"" +
                "totalPedido\":\"63.9\",\"status\":\"RASCUNHO\",\"itens\":[{\"id\":\"4\",\"idProduto\":\"2\",\"" +
                "quantidade\":\"1\",\"precoUnitario\":\"19.9\",\"desconto\":\"0.0\",\"totalItem\":\"19.9\"}]}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));

    }


    @Test
    public void deveriaDevolver200CasoDadosSejamPersistidosCorretamentePut() throws Exception {
        URI uri = new URI("/pedidos/");

        String json = "{\"id\":\"2\",\"dataEntrega\":\"2022-06-07\",\"" +
                "totalPedido\":\"63.9\",\"status\":\"FECHADO\",\"itens\":[{\"id\":\"4\",\"idProduto\":\"2\",\"" +
                "quantidade\":\"2\",\"precoUnitario\":\"19.9\",\"desconto\":\"0.0\",\"totalItem\":\"38.8\"}]}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));


    }

    @Test
    public void deveriaDevolver200CasoDeleteFuncione() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/pedidos/11")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));

    }


}
