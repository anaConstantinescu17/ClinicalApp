package com.clinic.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.net.URI;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

//    @GetMapping(path = "/departments", produces = MediaType.TEXT_HTML_VALUE)
//    public ResponseEntity<?> customerPage() {
//        try {
//            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
//                    .location(URI.create("/departments"))
//                    .build();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            throw new RuntimeException(e);
//        }
//    }

}
