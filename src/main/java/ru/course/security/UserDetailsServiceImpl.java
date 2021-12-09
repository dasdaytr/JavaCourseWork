package ru.course.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.course.Models.person2;
import ru.course.repo.PostBasketRepository;
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PostBasketRepository postBasketRepository;
    @Autowired
    public UserDetailsServiceImpl(PostBasketRepository postBasketRepository) {
        this.postBasketRepository = postBasketRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        person2 user = postBasketRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User doest't exists"));
        return SecurityUser.fromUser(user);
    }


}

