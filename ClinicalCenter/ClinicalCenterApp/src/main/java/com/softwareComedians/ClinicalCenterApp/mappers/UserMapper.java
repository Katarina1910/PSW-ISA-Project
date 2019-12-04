package com.softwareComedians.ClinicalCenterApp.mappers;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.User;

import java.util.List;
import java.util.stream.Collectors;

//pretvara entity u dto i obrnuto
public class UserMapper {

    private UserMapper() {
    }

    public static UserDTO toDto(User user) {
        return new UserDTO(user);
    }

    public static List<UserDTO> toListDto(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public static User toEntity(UserRegistrationDTO userInfo) {
        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setEnabled(false);
        user.setEmail(userInfo.getEmail());
        user.setName(userInfo.getName());
        user.setSurname(userInfo.getSurname());
        user.setPassword("");
        user.setUcidn(userInfo.getUcidn());
        user.setPhone(userInfo.getPhone());
        user.setCountry(userInfo.getCountry());
        user.setCity(userInfo.getCity());
        user.setAddress(userInfo.getAddress());

        return user;
    }
}
