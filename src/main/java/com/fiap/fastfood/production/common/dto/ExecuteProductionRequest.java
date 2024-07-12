package com.fiap.fastfood.production.common.dto;

import com.fiap.fastfood.production.core.entity.Production;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteProductionRequest {
    private Production production;
}
