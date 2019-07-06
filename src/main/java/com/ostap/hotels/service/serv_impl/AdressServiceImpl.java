package com.ostap.hotels.service.serv_impl;

import com.ostap.hotels.repository.AdressDAO;
import com.ostap.hotels.models.Adress;
import com.ostap.hotels.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdressServiceImpl implements AdressService {

    @Autowired
    private AdressDAO adressDAO;

    @Override
    public void save(Adress adress) {

    }
}
