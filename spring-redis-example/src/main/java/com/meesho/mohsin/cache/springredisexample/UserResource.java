package com.meesho.mohsin.cache.springredisexample;

import com.meesho.mohsin.cache.springredisexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add/{id}/{name}/")
    public User add(@PathVariable("id") String id,@PathVariable("name") String name){
        userRepository.save(new User(id,name,20000L));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}/")
    public User update(@PathVariable("id") String id,@PathVariable("name") String name){
        userRepository.update(new User(id,name,10000L));
        return userRepository.findById(id);
    }

    @GetMapping("/delete/{id}/")
    public Map<String,User> delete(@PathVariable("id") String id){
        userRepository.delete(id);
        return findAll();
    }

    @GetMapping("/all/")
    public Map<String,User> findAll(){
        return userRepository.findAll();
    }
}
