package ru.dan.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dan.course.Models.person2;

public interface PersonRepository extends JpaRepository <person2,Integer> {
    person2 findByEmail(String email);
}
