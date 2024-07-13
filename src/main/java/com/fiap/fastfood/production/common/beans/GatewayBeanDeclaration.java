package com.fiap.fastfood.production.common.beans;

import com.fiap.fastfood.production.common.interfaces.datasource.SpringDataMongoProductionRepository;
import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.comunication.gateway.ProductionGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeanDeclaration {

    @Bean
    public ProductionGateway orderGateway(SpringDataMongoProductionRepository repository) {
        return new ProductionGatewayImpl(repository);
    }
}
