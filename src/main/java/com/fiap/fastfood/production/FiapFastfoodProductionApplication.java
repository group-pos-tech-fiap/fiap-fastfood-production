package com.fiap.fastfood.production;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Fast Food PRODUCTION - FIAP", description = "Microservico responsavel pela esteira de produção dos pedidos dos clientes", version = "v1"))
public class FiapFastfoodProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapFastfoodProductionApplication.class, args);
    }

}
