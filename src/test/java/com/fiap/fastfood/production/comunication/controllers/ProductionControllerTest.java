package com.fiap.fastfood.production.comunication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.fastfood.production.common.dto.ExecuteProductionRequest;
import com.fiap.fastfood.production.common.interfaces.usecase.ProductionUseCase;
import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.core.entity.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class ProductionControllerTest {

    @Mock
    private ProductionUseCase productionUseCase;

    @InjectMocks
    private ProductionController productionController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(productionController).build();
    }

    @Test
    void createOrder() throws Exception {
        var production = Production.builder()
                .orderId("123")
                .status(Status.IN_PREPARATION)
                .build();
        var request = new ExecuteProductionRequest(production);

        when(productionUseCase.executeProduction(production)).thenReturn(production);

        mockMvc.perform(post("/production")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(productionUseCase, times(1)).executeProduction(any(Production.class));
    }
}