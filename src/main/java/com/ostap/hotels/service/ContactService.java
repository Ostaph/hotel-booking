package com.ostap.hotels.service;

import com.ostap.hotels.models.Contact;
import org.springframework.stereotype.Service;


@Service
public interface ContactService {

    void save(Contact contact);
}
