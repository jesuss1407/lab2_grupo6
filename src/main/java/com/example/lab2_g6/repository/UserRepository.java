package com.example.lab2_g6.repository;

import com.example.lab2_g6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "select * from user\n" +
            "where email = (?1) and password = (?2);",nativeQuery = true)
    User encontrarUsuario(String correo, String contrasena);
}
