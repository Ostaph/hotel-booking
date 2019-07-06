package com.ostap.hotels.service.serv_impl;

import com.ostap.hotels.repository.ContactDAO;
import com.ostap.hotels.models.Contact;
import com.ostap.hotels.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;
    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }
}
