package com.fpt.csw_final_api.repository;

import com.fpt.csw_final_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
