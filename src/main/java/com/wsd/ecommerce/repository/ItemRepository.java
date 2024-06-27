package com.wsd.ecommerce.repository;


import com.wsd.ecommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("SELECT i FROM Item i JOIN i.sales s GROUP BY i.id ORDER BY SUM(s.amount) DESC")
    List<Item> findTop5SellingItems();
}
