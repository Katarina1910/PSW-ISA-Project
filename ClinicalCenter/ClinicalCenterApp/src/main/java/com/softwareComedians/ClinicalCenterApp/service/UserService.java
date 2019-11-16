package com.softwareComedians.ClinicalCenterApp.service;

import org.springframework.stereotype.Service;

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
