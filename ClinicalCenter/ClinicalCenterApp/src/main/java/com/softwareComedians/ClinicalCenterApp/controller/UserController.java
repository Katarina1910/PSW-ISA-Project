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

import javax.servlet.http.HttpServletRequest;

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
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
		}
		if(userService.findByUICDN(userDTO.getUcidn())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
		}
		if(userService.findByUserName(userDTO.getUserName())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
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
	public  ResponseEntity<?> login(@RequestBody UserDTO u, HttpServletRequest request){
    	User user = new User();
    	user = userService.findByUserName(u.getUserName());
		System.out.println(u.getUserName());
    	if (user!=null){
			if(user.getPassword().equals(u.getPassword())) {
				if(request.getSession().getAttribute("user") != null)
					request.getSession().invalidate();


				request.getSession().setAttribute("user", user);
				return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
			}
		}
		return  new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
	}

	@GetMapping()
	@RequestMapping(value = "/logout")
	public  ResponseEntity<?> logout (HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<>("Logged out!", HttpStatus.OK);
	}

}
