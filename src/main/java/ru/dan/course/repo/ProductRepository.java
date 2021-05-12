package ru.dan.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dan.course.Models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByType(String type);
}
