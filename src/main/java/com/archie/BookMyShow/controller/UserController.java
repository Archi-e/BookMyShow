package com.archie.BookMyShow.controller;

import com.archie.BookMyShow.dto.UserRequestDTO;
import com.archie.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        return ResponseEntity.ok(
                userService.signUp(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getPassword())
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        return ResponseEntity.ok(
                userService.login(userRequestDTO.getEmail(), userRequestDTO.getPassword())
        );
    }
}
