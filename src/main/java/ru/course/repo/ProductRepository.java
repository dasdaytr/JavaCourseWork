package ru.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.course.Models.Product;
import ru.course.Models.PublishingHouse;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //List<Product> findByType(String type);
    List<Product> findByPublishingHouse(PublishingHouse publishingHouse);


}
