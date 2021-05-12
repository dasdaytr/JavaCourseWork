package ru.dan.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dan.course.Models.Basket;
import ru.dan.course.Models.Product;
import ru.dan.course.repo.BasketRepository;
import ru.dan.course.repo.ProductRepository;
import ru.dan.course.repo.PersonRepository;

import java.security.Principal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BasketRepository basketRepository;

    public void viewPageProductPost(Product product, Principal principal){
        personRepository.findById( personRepository.findByEmail(principal.getName()).getId()).map(person2 -> {
            if(basketRepository.findByNameProductAndPerson2(product.getNameProduct(),person2).isEmpty()){
                Basket basket = new Basket();
                basket.setCount(product.getCount());
                basket.setNameProduct(product.getNameProduct());
                basket.setPrice(product.getPrice());
                basket.setPerson2(person2);
                basket.setSumPrice(product.getCount()*product.getPrice());
                System.out.println("Первый случай");
                return basketRepository.save(basket);
            }
            else{
                return basketRepository.findByNameProductAndPerson2(product.getNameProduct(),person2).map(basket -> {
                    basket.setSumPrice(basket.getSumPrice()+product.getCount()*product.getPrice());
                    basket.setCount(basket.getCount()+product.getCount());
                    return basketRepository.save(basket);
                });
            }
        });
    }
    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }
}
