package com.fiap.fastfood.production.common.interfaces.gateway;

import com.fiap.fastfood.production.core.entity.Production;

public interface ProductionGateway {
    Production saveProduction(Production production);
}
