package com.webapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private static final String message = "hell world, from padat";

    @GetMapping("/message")
    public static String message() {
        return message;
    }
}
