package com.fiap.fastfood.production.common.interfaces.gateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fiap.fastfood.production.common.interfaces.datasource.SpringDataMongoProductionRepository;
import com.fiap.fastfood.production.comunication.gateway.ProductionGatewayImpl;
import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.core.entity.Status;
import com.fiap.fastfood.production.external.orm.ProductionORM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class ProductionGatewayTest {

    @Mock
    private SpringDataMongoProductionRepository repository;

    @InjectMocks
    private ProductionGatewayImpl productionGateway;

    @Test
    void testSaveProduction() {
        LocalDateTime now = LocalDateTime.now();
        Production production = Production.builder()
                .id("1")
                .orderId("123")
                .status(Status.READY)
                .createdAt(now)
                .updatedAt(now)
                .build();

        ProductionORM productionORM = ProductionORM.builder()
                .id(production.getId())
                .orderId(production.getOrderId())
                .status(production.getStatus())
                .createdAt(production.getCreatedAt())
                .updatedAt(production.getUpdatedAt())
                .build();

        when(repository.save(any(ProductionORM.class))).thenReturn(productionORM);

        Production savedProduction = productionGateway.saveProduction(production);

        assertEquals(production.getId(), savedProduction.getId());
        assertEquals(production.getOrderId(), savedProduction.getOrderId());
        assertEquals(production.getStatus(), savedProduction.getStatus());
        assertEquals(production.getCreatedAt(), savedProduction.getCreatedAt());
        assertEquals(production.getUpdatedAt(), savedProduction.getUpdatedAt());
    }
}