package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
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

    public User findByEmail(String email){
        for(User u : userRepository.findAll()){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public User findByUserName(String userName){
        for(User u : userRepository.findAll()){
            if(u.getUserName().equals(userName)){
                return u;
            }
        }
        return null;
    }

    public User findByUICDN(String uicdn){
        for(User u : userRepository.findAll()){
            if(u.getUcidn().equals(uicdn)){
                return u;
            }
        }
        return null;
    }


    public User save(User u) {
        return userRepository.save(u);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }


}
