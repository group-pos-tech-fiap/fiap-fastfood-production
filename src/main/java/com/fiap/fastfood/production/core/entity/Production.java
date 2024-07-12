package com.fiap.fastfood.production.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Production {
    private String id;
    private String orderId;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
