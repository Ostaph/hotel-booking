package com.ostap.hotels.repository;

import com.ostap.hotels.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer > {

}
