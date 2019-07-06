package com.ostap.hotels.service.serv_impl;

import com.ostap.hotels.repository.CustomerDAO;
import com.ostap.hotels.models.Customer;
import com.ostap.hotels.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        return customerDAO.findByEmail(email);
    }

    @Override
    public UserDetails loadUserById(int id) {
        return customerDAO.findById(id);    }

    @Override
    public UserDetails loadByCode(String code) {
        return customerDAO.findByCode(code);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return customerDAO.findByUsername(s);
    }
}
