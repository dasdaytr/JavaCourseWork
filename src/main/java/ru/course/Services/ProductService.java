package ru.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.course.Models.PublishingHouse;
import ru.course.repo.PersonRepository;
import ru.course.Models.Basket;
import ru.course.Models.Product;
import ru.course.repo.BasketRepository;
import ru.course.repo.ProductRepository;
import ru.course.repo.PublishingRepository;

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
    @Autowired
    private PublishingRepository publishingRepository;

    public void viewPageProductPost(Product product, Principal principal){
        personRepository.findById( personRepository.findByEmail(principal.getName()).getId()).map(person2 -> {
            if(basketRepository.findByNameProductAndPerson2(product.getNameBook(),person2).isEmpty()){
                Basket basket = new Basket();
                System.out.println(product.toString());
                basket.setCount(product.getCount());
                basket.setNameProduct(product.getNameBook());
                basket.setPrice(product.getPrice());
                basket.setPerson2(person2);
                basket.setSumPrice(product.getCount()*product.getPrice());
                System.out.println("Первый случай");
                return basketRepository.save(basket);
            }
            else{
                return basketRepository.findByNameProductAndPerson2(product.getNameBook(),person2).map(basket -> {
                    basket.setSumPrice(basket.getSumPrice()+product.getCount()*product.getPrice());
                    basket.setCount(basket.getCount()+product.getCount());
                    return basketRepository.save(basket);
                });
            }
        });
    }

    public void addNewProductInShop(Product product, String publish){
        product.setCount(1);
        PublishingHouse publishingHouse = publishingRepository.findByTitlePublishing(publish);
        product.setPublishingHouse(publishingHouse);
        productRepository.save(product);
    }
}
