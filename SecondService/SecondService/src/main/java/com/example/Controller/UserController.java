package com.example.Controller;

import com.example.DTO.UserDTO;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/post")
    public ResponseEntity<?> craeteUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);
        return new ResponseEntity(user,HttpStatus.CREATED);
    }
}
