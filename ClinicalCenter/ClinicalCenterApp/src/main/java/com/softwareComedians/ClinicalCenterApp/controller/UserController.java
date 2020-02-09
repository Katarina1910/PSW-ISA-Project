package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.common.TimeProvider;
import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForPatientRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.mappers.UserMapper;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
	private RequestForPatientRegistrationService requestForPatientRegistrationService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private TimeProvider timeProvider;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/public/{id}")
	//@PreAuthorize("hasRole('ROLE_CA')")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}

	@GetMapping
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@PreAuthorize("hasRole('ROLE_CA')")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(UserMapper.toListDto(users), HttpStatus.OK);
	}

	@PostMapping("/public/add-user")
    public ResponseEntity<RequestForPatientRegistrationDTO> createRqForPatientReg(@RequestBody RequestForPatientRegistrationDTO rqDTO) {
		if (userRepository.findByEmail(rqDTO.getUserData().getEmail()) != null) {
			throw new ApiRequestException("Email '" + rqDTO.getUserData().getEmail() + "' already exists.");
		}
		if (!rqDTO.getUserData().getPassword().equals(rqDTO.getUserData().getPassword2())) {
			throw new ApiRequestException("Provided passwords must be the same.");
		}
		User user = new User();
		user.setId(rqDTO.getUserData().getId());
		user.setName(rqDTO.getUserData().getName());
		user.setSurname(rqDTO.getUserData().getSurname());
		user.setUcidn(rqDTO.getUserData().getUcidn());
		user.setAddress(rqDTO.getUserData().getAddress());
		user.setCity(rqDTO.getUserData().getCity());
		user.setCountry(rqDTO.getUserData().getCountry());
		user.setEmail(rqDTO.getUserData().getEmail());
		user.setPhone(rqDTO.getUserData().getPhone());
		user.setUsername(rqDTO.getUserData().getUsername());
		user.setPassword(passwordEncoder.encode(rqDTO.getUserData().getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.setRole(UserRoles.ROLE_PATIENT);
		user.getUsersAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_PATIENT));

		user = userService.save(user);

		RequestForPatientRegistration req = new RequestForPatientRegistration(user);
		req = requestForPatientRegistrationService.save(req);

		return new ResponseEntity<>(new RequestForPatientRegistrationDTO(req), HttpStatus.CREATED);
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO) {
		//User newUserInfo = userService.editUser(user);
		//newUserInfo = userService.save(newUserInfo);

		User userInfo = userService.findById(userDTO.getId());
		userInfo.setName(userDTO.getName());
		userInfo.setSurname(userDTO.getSurname());
		userInfo.setPhone(userDTO.getPhone());
		userInfo.setUsername(userDTO.getUsername());
		//userInfo.setPassword(userDTO.getPassword());
		userInfo.setActivated(userDTO.isActivated());
		userInfo.setCountry(userDTO.getCountry());
		userInfo.setCity(userDTO.getCity());
		//userInfo.setId(userDTO.getId());
		userInfo.setAddress(userDTO.getAddress());
		userInfo.setUcidn(userDTO.getUcidn());

		userInfo = userService.save(userInfo);

		return new ResponseEntity<>(UserMapper.toDto(userInfo), HttpStatus.OK);
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

}
