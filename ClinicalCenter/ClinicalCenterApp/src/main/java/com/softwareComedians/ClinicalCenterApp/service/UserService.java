package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  //  @Autowired
   // private UserRepository userRepository;

  /*  public Optional<User> findOne(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository .findAll();
    }

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll( page);
    }

    public User save(User u) {
        return userRepository.save(u);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }*/
}
