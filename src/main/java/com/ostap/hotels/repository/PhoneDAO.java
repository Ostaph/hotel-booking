package com.ostap.hotels.repository;

import com.ostap.hotels.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDAO extends JpaRepository<Phone,Integer> {
}
