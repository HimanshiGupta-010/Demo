package com.assign.item.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.item.Model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
   
}