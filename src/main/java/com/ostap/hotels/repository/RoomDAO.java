package com.ostap.hotels.repository;

import com.ostap.hotels.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;

public interface RoomDAO extends JpaRepository<Room,Integer> {
            List<Room>findAllByHotelCityOrHotelName(String finder,String finderr);

    List<Room>findAll();
    //Потрібно шукати за кімнатими, а потім за містом або назвою, бо кімнати відфільтровують зайві запити
    LinkedList<Room> findAllByRoominessAndHotelCityOrRoominessAndHotelName(Integer roominess, String finder, Integer room, String name);
    Room findById(int id);
}
