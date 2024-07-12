package com.fiap.fastfood.production.common.beans;

import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.common.interfaces.usecase.ProductionUseCase;
import com.fiap.fastfood.production.core.usecase.ProductionUseCaseImpl;
import com.fiap.fastfood.production.external.feign.OrderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanDeclaration {

    @Bean
    public ProductionUseCase productionUseCase(ProductionGateway productionGateway, OrderClient orderClient) {
        return new ProductionUseCaseImpl(productionGateway, orderClient);
    }
}
