package com.fiap.fastfood.production.common.interfaces.datasource;

import com.fiap.fastfood.production.external.orm.ProductionORM;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoProductionRepository extends MongoRepository<ProductionORM, String> {

}
