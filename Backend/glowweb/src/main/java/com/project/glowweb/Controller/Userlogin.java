package com.project.glowweb.Controller;

import com.project.glowweb.Entity.UserloginEntity;
import com.project.glowweb.Service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class Userlogin {

    @Autowired
    private Userservice us;


    // REGISTER
    @PostMapping("/register")
    public String register(
            @RequestBody UserloginEntity user) {

        return us.register(user);
    }


    // LOGIN
    @PostMapping("/user")
    public Map<String, Object> login(
            @RequestBody UserloginEntity user) {

        UserloginEntity result =
                us.login(
                        user.getEmail(),
                        user.getPassword()
                );

        Map<String, Object> response =
                new HashMap<>();

        if (result == null) {

            response.put("success", false);
            response.put(
                    "message",
                    "Invalid email or password"
            );

            return response;
        }

        response.put("success", true);
        response.put("message", "Login successful");
        response.put("name", result.getUsername());
        response.put("email", result.getEmail());

        return response;
    }
}