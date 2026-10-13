package com.project.glowweb.Service;


import com.project.glowweb.Entity.AdminEntity;
import com.project.glowweb.Repo.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    // Create Admin
    public AdminEntity createAdmin(AdminEntity admin) {

        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException("Admin email already exists");
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");
        admin.setStatus("ACTIVE");

        return adminRepository.save(admin);
    }

    // Admin Login
    public boolean loginAdmin(String email, String password) {

        AdminEntity admin = adminRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Admin email not found"));

        if (!admin.getStatus().equals("ACTIVE")) {
            throw new RuntimeException("Admin account is inactive");
        }

        return passwordEncoder.matches(
                password,
                admin.getPassword()
        );
    }
}