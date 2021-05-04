package ru.dan.course.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Product {

    private Integer id;

    private String nameProduct;

    private Double price;

    private int count;

    private String UrlImage;
}
