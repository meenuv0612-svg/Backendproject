package com.project.glowweb.Service;

import com.project.glowweb.Entity.UserloginEntity;
import com.project.glowweb.Repo.Userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice {

    @Autowired
    private Userrepo userrepo;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // REGISTER
    public String register(UserloginEntity user) {

        if (userrepo.existsByEmail(user.getEmail())) {
            return "Already registered";
        }

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        userrepo.save(user);

        return "Registration successful";
    }

    // LOGIN
    public UserloginEntity login(String email, String password) {

        UserloginEntity user =
                userrepo.findByEmail(email).orElse(null);

        if (user == null) {
            return null;
        }

        if (!encoder.matches(password, user.getPassword())) {
            return null;
        }

        return user;
    }
}