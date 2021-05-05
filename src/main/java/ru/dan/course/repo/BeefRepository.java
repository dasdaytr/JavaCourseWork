package ru.dan.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dan.course.Models.Beef;

import java.util.List;

public interface BeefRepository extends JpaRepository<Beef,Integer> {

    List<Beef> findByType(String type);
}
