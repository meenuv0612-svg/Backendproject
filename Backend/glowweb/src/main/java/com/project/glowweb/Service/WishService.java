package com.project.glowweb.Service;



import com.project.glowweb.Entity.Wishlist;
import com.project.glowweb.Repo.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishRepo wishRepo;

    public Wishlist add(Wishlist wish) {

        if (wishRepo.findByEmailAndProductId(
                wish.getEmail(),
                wish.getProductId()
        ).isPresent()) {
            return wish;
        }

        return wishRepo.save(wish);
    }

    public List<Wishlist> get(String email) {
        return wishRepo.findByEmail(email);
    }

    public void remove(String email, String productId) {
        wishRepo.deleteByEmailAndProductId(email, productId);
    }
}