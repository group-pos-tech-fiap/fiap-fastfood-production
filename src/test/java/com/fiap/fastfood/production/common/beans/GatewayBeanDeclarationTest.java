package com.fiap.fastfood.production.common.beans;

import com.fiap.fastfood.production.common.interfaces.datasource.SpringDataMongoProductionRepository;
import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.comunication.gateway.ProductionGatewayImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class GatewayBeanDeclarationTest {

    @Mock
    private SpringDataMongoProductionRepository repository;

    @Test
    void testProductionGatewayBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(SpringDataMongoProductionRepository.class, () -> repository);
        context.register(GatewayBeanDeclaration.class);
        context.refresh();

        ProductionGateway productionGateway = context.getBean(ProductionGateway.class);

        assertNotNull(productionGateway);
        assertTrue(productionGateway instanceof ProductionGatewayImpl);
    }
}