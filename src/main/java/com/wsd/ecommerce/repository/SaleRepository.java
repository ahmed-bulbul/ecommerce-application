package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    List<Sale> findByCreatedDate(LocalDate now);
}
