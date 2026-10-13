package com.project.glowweb.Controller;



import com.project.glowweb.Entity.AdminEntity;
import com.project.glowweb.Service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Create Admin
    @PostMapping("/create")
    public AdminEntity createAdmin(@RequestBody AdminEntity admin) {
        return adminService.createAdmin(admin);
    }

    // Admin Login
    @PostMapping("/login")
    public Map<String, Object> loginAdmin(
            @RequestBody Map<String, String> loginData) {

        String email = loginData.get("email");
        String password = loginData.get("password");

        boolean success = adminService.loginAdmin(email, password);

        Map<String, Object> response = new HashMap<>();

        if (success) {
            response.put("success", true);
            response.put("message", "Admin login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid email or password");
        }

        return response;
    }
}