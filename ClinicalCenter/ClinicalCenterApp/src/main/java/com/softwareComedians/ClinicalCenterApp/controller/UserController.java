package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
	private RequestForPatientRegistrationService requestForPatientRegistrationService;

    @PostMapping()
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		User user = new User();
		if(userService.findByEmail(userDTO.getEmail())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
		}
		if(userService.findByUICDN(userDTO.getUcidn())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
		}
		if(userService.findByUserName(userDTO.getUserName())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
		}

		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setUcidn(userDTO.getUcidn());
		user.setAddress(userDTO.getAddress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());

		user = userService.save(user);

		RequestForPatientRegistration req = new RequestForPatientRegistration(user);
		requestForPatientRegistrationService.save(req);

		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}

	@PostMapping()
	@RequestMapping(value = "/login")
	public  ResponseEntity<?> login(@RequestBody UserDTO u){
    	User user = new User();
    	user = userService.findByUserName(u.getUserName());
    	if (user!=null){
			if(user.getPassword().equals(u.getPassword())) {
				return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
			}
		}
		return  new ResponseEntity<>("Wrong username or password", HttpStatus.OK);
	}

}
