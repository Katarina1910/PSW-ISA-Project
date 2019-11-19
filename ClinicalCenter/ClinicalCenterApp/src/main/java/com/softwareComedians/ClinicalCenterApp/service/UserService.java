package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOne(Long id){
        return userRepository.findById(id).orElseGet(null);
    }

    public List<User> findAll(){
        return userRepository .findAll();
    }


    public User save(User u) {
        return userRepository.save(u);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }


}
