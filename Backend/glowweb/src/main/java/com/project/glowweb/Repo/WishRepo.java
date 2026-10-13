package com.project.glowweb.Repo;




import com.project.glowweb.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishRepo extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByEmail(String email);

    Optional<Wishlist> findByEmailAndProductId(String email, String productId);

    void deleteByEmailAndProductId(String email, String productId);
}