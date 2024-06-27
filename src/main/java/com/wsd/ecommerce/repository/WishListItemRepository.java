package com.wsd.ecommerce.repository;


import com.wsd.ecommerce.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListItemRepository extends JpaRepository<WishlistItem,Long> {
    List<WishlistItem> findByCustomerId(Long customerId);
}
