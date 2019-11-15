package com.softwareComedians.ClinicalCenterApp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
  //  @Autowired
   // private UserService userService;

  /*  @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<User> users = userService.findAll();

        List<UserDTO> userDTO = new ArrayList<>();
        for (User u : users) {
           // userDTO.add(new UserDTO());
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        User user = new User();
       //setere napravi

        user = userService.save(user);
        //user u konstruktor dto
        return new ResponseEntity<>(new UserDTO(), HttpStatus.CREATED);
    }*/
}
