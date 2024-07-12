package com.fiap.fastfood.production.common.builder;

import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.external.orm.ProductionORM;

public class ProductionBuilder {

    public static Production fromOrmToDomain(ProductionORM orm) {
        return Production.builder()
                .id(orm.getId())
                .createdAt(orm.getCreatedAt())
                .updatedAt(orm.getUpdatedAt())
                .status(orm.getStatus())
                .build();
    }

    public static ProductionORM fromDomainToOrm(Production order) {
        return ProductionORM.builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .status(order.getStatus())
                .build();
    }
}
