package com.mircea.magazinmobila.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mircea.magazinmobila.StoreConstants;
import com.mircea.magazinmobila.entity.Item;
import com.mircea.magazinmobila.repository.StoreRepository;


@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public String addItem(Item item) {
        Item foundItem = storeRepository.findById(item.getId());
        if (foundItem == null) {
            storeRepository.save(item); 
            return StoreConstants.getSuccesStatus();
        } else {
        boolean status = within5Days(item.getDate(), foundItem.getDate());
        if (status) {
            storeRepository.save(item);
            return StoreConstants.getSuccesStatus();
        } else {
            return StoreConstants.getFailedStatus();
        }
    }

    }

    @Override
    public void deleteItem(String id) {
       storeRepository.deleteById(id);
        
    }

    @Override
    public Item getItemById(String id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Item> getItems() {
        return (List<Item>)storeRepository.findAll();
    }


    private boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    
    
}
