package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.mappers.UserMapper;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
	private RequestForPatientRegistrationService requestForPatientRegistrationService;

	@GetMapping("/public/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(UserMapper.toListDto(users), HttpStatus.OK);
	}

	@PostMapping("/public/add-user")
	public ResponseEntity<UserDTO> addRegularUser(@Valid @RequestBody UserRegistrationDTO userInfo) {
		User user = userService.addRegularUser(userInfo);
		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO user) {
		User newUserInfo = userService.editUser(user);
		return new ResponseEntity<>(UserMapper.toDto(newUserInfo), HttpStatus.OK);
	}

	@PostMapping("/add-admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<UserDTO> addAdminUser(@RequestBody UserRegistrationDTO userInfo) {
		User user = userService.addAdminUser(userInfo);
		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}

	@GetMapping("/public/verify/{token}")
	public void verifyAccount(@PathVariable String token) {
		userService.verifyUserAccount(token);
	}
/*
    @PostMapping()
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		User user = new User();
		if(userService.findByEmail(userDTO.getEmail())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
		}
		if(userService.findByUICDN(userDTO.getUcidn())!=null){
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.BAD_REQUEST);
		}
		if(userService.findByUsername(userDTO.getUsername())!=null){
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
		user.setUsername(userDTO.getUsername());
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
    	user = userService.findByUsername(u.getUsername());
		System.out.println(u.getUsername());
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
*/
}
