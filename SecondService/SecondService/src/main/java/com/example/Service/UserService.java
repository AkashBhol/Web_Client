package com.example.Service;

import com.example.DTO.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public UserDTO createUser(UserDTO userDTO);

    public List<UserDTO> getALlUserDto();
}
