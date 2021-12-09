package ru.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.course.Models.Basket;
import ru.course.repo.BasketRepository;
import ru.course.repo.PersonRepository;
import ru.course.Models.Product;

import java.security.Principal;
import java.util.Set;

@Service
public class BasketService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BasketRepository basketRepository;

    public void deleteProduct(Principal principal, Product product){
        basketRepository.findByNameProductAndPerson2(product.getNameBook(), personRepository.findByEmail(principal.getName())).map(basket1 -> {
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
