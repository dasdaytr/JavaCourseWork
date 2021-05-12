package ru.dan.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dan.course.Models.Basket;
import ru.dan.course.Models.Product;
import ru.dan.course.Models.person2;
import ru.dan.course.repo.BasketRepository;
import ru.dan.course.repo.PersonRepository;

import java.security.Principal;
import java.util.Set;

@Service
public class BasketService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BasketRepository basketRepository;

    public void deleteProduct(Principal principal, Product product){
        basketRepository.findByNameProductAndPerson2(product.getNameProduct(), personRepository.findByEmail(principal.getName())).map(basket1 -> {
            basketRepository.delete(basket1);
            return null;
        });
    }
    public Double getSum(Principal principal){
        return basketRepository.findByPerson2(personRepository.findByEmail(principal.getName())).stream().mapToDouble(x->x.getSumPrice()).sum();
    }
    public Integer getCount(Principal principal){
        return basketRepository.findByPerson2(personRepository.findByEmail(principal.getName())).stream().mapToInt(x->x.getCount()).sum();
    }
    public Set<Basket> getPersonBasket(Principal principal){
        return personRepository.findByEmail(principal.getName()).getBaskets();
    }
}
