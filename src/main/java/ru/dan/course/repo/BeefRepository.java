package ru.dan.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dan.course.Models.Beef;

public interface BeefRepository extends JpaRepository<Beef,Integer> {
}
