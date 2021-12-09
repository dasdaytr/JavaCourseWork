package ru.course.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameBook;

    private Double price;

    private int count;

    private String UrlImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_id_publishing")
    private PublishingHouse publishingHouse;

}
