package com.matheus.form.Service;

import com.matheus.form.DTO.UserAssemble;
import com.matheus.form.DTO.UserDTO;
import com.matheus.form.Entity.User;
import com.matheus.form.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAssemble userAssemble;



    public List<UserDTO> getAll(){
        List<User> userList = userRepository.findAll();

        List<UserDTO> userDTOList = userList.stream()
                .map(user -> userAssemble.userToUserDTO(user))
                .collect(Collectors.toList());

        return userDTOList;
    }

    public UserDTO createUser(User user){
        userRepository.save(user);

        UserDTO newUserDTO = userAssemble.userToUserDTO(user);


        return newUserDTO;

    }
}
