package com.matheus.form.DTO;

import com.matheus.form.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAssemble {

    public UserDTO userToUserDTO (User user){

        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
