package com.fiap.fastfood.production.comunication.controllers;

import com.fiap.fastfood.production.common.dto.ExecuteProductionRequest;
import com.fiap.fastfood.production.common.interfaces.usecase.ProductionUseCase;
import com.fiap.fastfood.production.core.entity.Production;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/production")
public class ProductionController {

    private final ProductionUseCase productionUseCase;

    public ProductionController(ProductionUseCase productionUseCase) {
        this.productionUseCase = productionUseCase;
    }

    @PostMapping
    public ResponseEntity<Production> executeProduction(@RequestBody ExecuteProductionRequest request) throws Exception {
        return ResponseEntity.ok(productionUseCase.executeProduction(request.getProduction()));
    }
}
