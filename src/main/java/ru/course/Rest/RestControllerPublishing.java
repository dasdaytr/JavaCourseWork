package ru.course.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.course.repo.PublishingRepository;

import java.util.List;

@RestController
public class RestControllerPublishing {
    @Autowired
    private PublishingRepository publishingRepository;
    @GetMapping("api/publishing")
    public List<String[]> getAllPublishing(){
        System.out.println("asdasd");
        return publishingRepository.findByTitlePublishingf();
    }
}
