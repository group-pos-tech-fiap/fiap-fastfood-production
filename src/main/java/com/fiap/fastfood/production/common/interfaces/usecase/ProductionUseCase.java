package com.fiap.fastfood.production.common.interfaces.usecase;

import com.fiap.fastfood.production.core.entity.Production;

public interface ProductionUseCase {
    Production executeProduction(Production production) throws Exception;
}
