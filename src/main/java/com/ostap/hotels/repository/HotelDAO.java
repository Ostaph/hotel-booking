package com.ostap.hotels.repository;

import com.ostap.hotels.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelDAO extends JpaRepository<Hotel,Integer> {
    List<Hotel> findAllByCityOrName(String finder,String finderr);
}
