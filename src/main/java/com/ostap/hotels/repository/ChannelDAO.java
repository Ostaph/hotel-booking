package com.ostap.hotels.repository;

import com.ostap.hotels.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelDAO extends JpaRepository<Channel,Integer> {
    String findByName(String name);
}
