
package ru.course.repo;

import org.springframework.data.repository.CrudRepository;
import ru.course.Models.person2;

import java.util.Optional;

public interface PostBasketRepository extends CrudRepository<person2,Integer> {
    Optional <person2> findByEmail(String email);
    @Override
    Iterable<person2> findAll();
}
