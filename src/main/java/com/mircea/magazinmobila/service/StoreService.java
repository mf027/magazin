package com.mircea.magazinmobila.service;


import java.util.List;

import com.mircea.magazinmobila.entity.Item;


public interface StoreService {

    String addItem(Item item);
    void deleteItem(String id);
    Item getItemById(String id);
    List<Item> getItems();
    
    
}
