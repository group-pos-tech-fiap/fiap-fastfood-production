package com.fiap.fastfood.production.external.feign;

import com.fiap.fastfood.production.external.feign.models.UpdateOrderStatusRequest;
import com.fiap.fastfood.production.external.feign.models.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "OrderClient", url = "${spring.cloud.openfeign.client.order.uri}")
public interface OrderClient {

    @PostMapping(value="/status")
    OrderResponse updateOrderStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest);
}
