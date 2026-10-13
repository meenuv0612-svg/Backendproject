package com.project.glowweb.Controller;




import com.project.glowweb.Entity.Wishlist;
import com.project.glowweb.Service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "*")
public class WishController {

    @Autowired
    private WishService wishService;

    @PostMapping("/add")
    public Wishlist add(@RequestBody Wishlist wish) {
        return wishService.add(wish);
    }

    @GetMapping("/{email}")
    public List<Wishlist> get(@PathVariable String email) {
        return wishService.get(email);
    }

    @DeleteMapping("/remove")
    public String remove(
            @RequestParam String email,
            @RequestParam String productId) {

        wishService.remove(email, productId);

        return "Removed from wishlist";
    }
}