package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {


		/*if (userDTO.getRole().equals("Doctor")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}*/

		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setUcidn(userDTO.getUcidn());
		user.setAddress(userDTO.getAddress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setRole(userDTO.getRole());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());

		user = userService.save(user);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}

}
