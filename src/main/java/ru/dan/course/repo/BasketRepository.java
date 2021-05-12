package ru.dan.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dan.course.Models.Basket;
import ru.dan.course.Models.person2;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository <Basket,Integer> {
    Optional <Basket>findByNameProductAndPerson2(String nameProduct, person2 person2);
    List <Basket> findByPerson2(person2 person2);
}
