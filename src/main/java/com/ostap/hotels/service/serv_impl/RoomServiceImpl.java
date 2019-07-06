package com.ostap.hotels.service.serv_impl;

import com.ostap.hotels.repository.RoomDAO;
import com.ostap.hotels.models.Room;
import com.ostap.hotels.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO roomDAO;

    @Override
    public void save(Room room) {
        roomDAO.save(room);
    }
}
