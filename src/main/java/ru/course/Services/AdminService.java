package ru.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.course.Models.Product;
import ru.course.repo.PersonRepository;
import ru.course.repo.ProductRepository;
import ru.course.Models.person2;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProductRepository productRepository;
    public List<person2> infoPerson(){
        List <person2> list = new ArrayList<>();
        for(person2 Person:personRepository.findAll()){
            if (!Person.getRole().name().equals("ADMIN")){
                list.add(Person);
            }
        }
        return list;
    }
    public void deletePerson(person2 Person){
        person2 p = personRepository.findByEmail(Person.getEmail());
        personRepository.delete(p);
    }

    public void addProduct(Product product){
        product.setCount(1);
        productRepository.save(product);
    }
}
