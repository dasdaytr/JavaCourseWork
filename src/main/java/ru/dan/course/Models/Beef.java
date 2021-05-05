package ru.dan.course.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Beef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameProduct;

    private Double price;

    private int count;

    private String UrlImage;
    @Column(name = "type")
    private String type;

}
