package ru.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.course.Models.PublishingHouse;

import java.util.List;

public interface PublishingRepository extends JpaRepository <PublishingHouse,Integer> {
    @Query("select id,titlePublishing,url from publishing_house ")
    List<String[]> findByTitlePublishingf();
    PublishingHouse findById(int id);
    PublishingHouse findByTitlePublishing(String publish);
}
