package ru.dan.course.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double price;

    private String nameProduct;

    private Double sumPrice;
    private  int count;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_key")
    private person2 person2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameproduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameproduct) {
        this.nameProduct = nameproduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public person2 getPerson2() {
        return person2;
    }

    public void setPerson2(person2 person2) {
        this.person2 = person2;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", price=" + price +
                ", nameproduct='" + nameProduct + '\'' +
                ", count=" + count +
                '}';
    }
}
