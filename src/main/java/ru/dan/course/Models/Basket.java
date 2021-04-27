package ru.dan.course.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private float price;

    private String nameproduct;

    private  int count;

    private String externalKey;
}
