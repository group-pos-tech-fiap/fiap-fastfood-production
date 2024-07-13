package com.fiap.fastfood.production.common.builder;

import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.external.orm.ProductionORM;

public class ProductionBuilder {

    public static Production fromOrmToDomain(ProductionORM orm) {
        return Production.builder()
                .id(orm.getId())
                .orderId(orm.getOrderId())
                .createdAt(orm.getCreatedAt())
                .updatedAt(orm.getUpdatedAt())
                .status(orm.getStatus())
                .build();
    }

    public static ProductionORM fromDomainToOrm(Production production) {
        return ProductionORM.builder()
                .id(production.getId())
                .orderId(production.getOrderId())
                .createdAt(production.getCreatedAt())
                .updatedAt(production.getUpdatedAt())
                .status(production.getStatus())
                .build();
    }
}
