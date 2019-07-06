package com.ostap.hotels.repository;

import com.ostap.hotels.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestDAO extends JpaRepository<Guest, Integer> {
}
