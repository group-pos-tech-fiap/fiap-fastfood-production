package com.fiap.fastfood.production.core.usecase;

import com.fiap.fastfood.production.common.interfaces.gateway.ProductionGateway;
import com.fiap.fastfood.production.common.interfaces.usecase.ProductionUseCase;
import com.fiap.fastfood.production.core.entity.Production;
import com.fiap.fastfood.production.external.feign.OrderClient;
import com.fiap.fastfood.production.external.feign.models.UpdateOrderStatusRequest;

public class ProductionUseCaseImpl implements ProductionUseCase {

    private final ProductionGateway productionGateway;
    private final OrderClient orderClient;

    public ProductionUseCaseImpl(ProductionGateway productionGateway, OrderClient orderClient) {
        this.productionGateway = productionGateway;
        this.orderClient = orderClient;
    }

    @Override
    public Production executeProduction(Production production) throws Exception {
        try {
            orderClient.updateOrderStatus(new UpdateOrderStatusRequest(production.getOrderId(), production.getStatus()));
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar Status do Pedido!");
        }
        return productionGateway.saveProduction(production);
    }
}
