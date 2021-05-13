package ru.dan.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.dan.course.Models.Product;
import ru.dan.course.Models.person2;
import ru.dan.course.repo.PersonRepository;
import ru.dan.course.repo.ProductRepository;

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
