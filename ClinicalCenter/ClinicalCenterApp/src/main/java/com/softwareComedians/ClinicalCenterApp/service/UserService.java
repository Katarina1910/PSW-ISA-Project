package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.User;

import java.util.List;

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

    User save(User u);

    User findByEmail(String mail);

    void remove(User u);

}

