package com.fiap.fastfood.production.external.feign.models;

import com.fiap.fastfood.production.core.entity.Status;

public record UpdateOrderStatusRequest(String orderId, Status status) {
}
