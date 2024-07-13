package com.fiap.fastfood.production.common.beans;

import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.common.interfaces.usecase.ProductionUseCase;
import com.fiap.fastfood.production.core.usecase.ProductionUseCaseImpl;
import com.fiap.fastfood.production.external.feign.OrderClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UseCaseBeanDeclarationTest {

    @Mock
    private ProductionGateway productionGateway;

    @Mock
    private OrderClient orderClient;

    @Test
    void testProductionUseCaseBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(ProductionGateway.class, () -> productionGateway);
        context.registerBean(OrderClient.class, () -> orderClient);
        context.register(UseCaseBeanDeclaration.class);
        context.refresh();

        ProductionUseCase useCase = context.getBean(ProductionUseCase.class);

        assertNotNull(useCase);
        assertTrue(useCase instanceof ProductionUseCaseImpl);
    }
}