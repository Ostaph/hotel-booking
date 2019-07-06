package com.ostap.hotels.service;

import com.ostap.hotels.models.Adress;
import org.springframework.stereotype.Service;


@Service
public interface AdressService {

    void save(Adress adress);
}
