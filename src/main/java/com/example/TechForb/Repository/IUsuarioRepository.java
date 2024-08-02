package com.example.TechForb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TechForb.Model.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}