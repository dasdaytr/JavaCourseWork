package ru.course.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "publishing_house")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title_publishing")
    private String titlePublishing;
    @Column(name = "amount")
    private int amount;
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "publishingHouse",fetch = FetchType.EAGER,cascade = {
            CascadeType.REMOVE
    },orphanRemoval = true)
    private List<Product> productList;
}
