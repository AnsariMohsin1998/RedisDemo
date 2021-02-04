package com.meesho.mohsin.cache.springredisexample;

import com.meesho.mohsin.cache.springredisexample.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserRepository {

    void save(User user);
    Map<String,User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);


}
