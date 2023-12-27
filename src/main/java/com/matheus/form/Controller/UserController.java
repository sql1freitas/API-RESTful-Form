package com.matheus.form.Controller;

import com.matheus.form.DTO.UserDTO;
import com.matheus.form.Entity.User;
import com.matheus.form.Repository.UserRepository;
import com.matheus.form.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(){

        return userService.getAll();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody User user){
      UserDTO newUserDTO = userService.createUser(user);
      return newUserDTO;

  }



}
