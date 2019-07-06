package com.ostap.hotels.repository;

import com.ostap.hotels.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDAO  extends JpaRepository<Image,Integer> {
Image findByName(String imagename);
}
