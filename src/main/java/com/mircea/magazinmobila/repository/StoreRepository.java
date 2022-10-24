package com.mircea.magazinmobila.repository;



import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.mircea.magazinmobila.entity.Item;


public interface StoreRepository extends CrudRepository<Item, Long> {

    Item findById(String id);
    @Transactional
    void deleteById(String id);

}
