package com.archie.BookMyShow.controller;

import com.archie.BookMyShow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    InitService initService;
    @GetMapping("/init")
    public ResponseEntity generateData(){
        return ResponseEntity.ok(
                initService.initialise()
        );
    }
}
