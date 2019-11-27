package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.User;

import java.util.List;

<<<<<<< HEAD
public interface UserService {

    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    User addRegularUser(UserRegistrationDTO userInfo);
    User addAdminUser(UserRegistrationDTO userInfo);
    void changeUserEnabledStatus(Long id, boolean status);
    User editUser(UserDTO user);
    //void setProfileImage(String imagePath);
    void verifyUserAccount(String token);
=======
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

        User user = userRepository.findByEmail(email);

        return user;

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


>>>>>>> master
}

