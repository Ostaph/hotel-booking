package com.ostap.hotels.service.serv_impl;

import com.ostap.hotels.repository.HotelDAO;
import com.ostap.hotels.models.Hotel;
import com.ostap.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public void save(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    @Override
    public Optional<Hotel> findById(int id) {
        return hotelDAO.findById(id);
    }
    @Override
    public List<Hotel> findAll() {
        return hotelDAO.findAll();
    }

    @Override
    public void deleteById(int id) {
        hotelDAO.deleteById(id);
    }
}
