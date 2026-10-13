package com.project.glowweb.Repo;

import com.project.glowweb.Entity.UserloginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepo extends JpaRepository<UserloginEntity, Integer> {

    Optional<UserloginEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}