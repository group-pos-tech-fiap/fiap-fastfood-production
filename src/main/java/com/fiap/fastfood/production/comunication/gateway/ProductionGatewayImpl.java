package com.fiap.fastfood.production.comunication.gateway;

import com.fiap.fastfood.production.common.builder.ProductionBuilder;
import com.fiap.fastfood.production.common.interfaces.datasource.SpringDataMongoProductionRepository;
import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.core.entity.Production;
import org.springframework.stereotype.Component;

@Component
public class ProductionGatewayImpl implements ProductionGateway {

    private final SpringDataMongoProductionRepository repository;

    public ProductionGatewayImpl(SpringDataMongoProductionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Production saveProduction(Production production) {
        var orm = ProductionBuilder.fromDomainToOrm(production);
        return ProductionBuilder.fromOrmToDomain(repository.save(orm));
    }
}
