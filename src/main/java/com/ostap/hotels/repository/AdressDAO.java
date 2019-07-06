package com.ostap.hotels.repository;

import com.ostap.hotels.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressDAO extends JpaRepository<Adress,Integer> {

}
