package com.wsd.ecommerce.repository;


import com.wsd.ecommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("SELECT i FROM Item i JOIN i.sales s GROUP BY i.id ORDER BY SUM(s.amount) DESC LIMIT 5")
    List<Item> findTop5SellingItems();


    @Query("SELECT i FROM Item i JOIN i.sales s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY i.id ORDER BY COUNT(s.id) DESC LIMIT 1")
    List<Item> findTopSellingItemsLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
