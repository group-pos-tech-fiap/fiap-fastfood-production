package com.fiap.fastfood.production.common.interfaces.usecase;

import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.core.entity.Status;
import com.fiap.fastfood.production.core.usecase.ProductionUseCaseImpl;
import com.fiap.fastfood.production.external.feign.OrderClient;
import com.fiap.fastfood.production.external.feign.models.OrderResponse;
import com.fiap.fastfood.production.external.feign.models.UpdateOrderStatusRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductionUseCaseTest {

    @Mock
    private ProductionGateway productionGateway;

    @Mock
    private OrderClient orderClient;

    @InjectMocks
    private ProductionUseCaseImpl productionUseCase;

    @Test
    void executeProduction() throws Exception {
        var production =  Production.builder()
                .id("ABC134")
                .orderId("1234566777")
                .status(Status.COMPLETED)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        when(orderClient.updateOrderStatus(any(UpdateOrderStatusRequest.class))).thenReturn(new OrderResponse("123"));
        when(productionGateway.saveProduction(any(Production.class))).thenReturn(production);

        var result = productionUseCase.executeProduction(production);

        assertEquals(Status.COMPLETED, result.getStatus());
        verify(productionGateway, times(1)).saveProduction(production);
    }
}