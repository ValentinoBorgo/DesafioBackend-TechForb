/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TechForb.Security;

import com.example.TechForb.Model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final Usuario user;

    @Override
    public String getPassword() {
        return user.getContrasenia();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public ArrayList<String> getDatos() {
        
        ArrayList<String> datos = new ArrayList<>();
        datos.add(user.getNombre());
        datos.add(user.getApellido());
        datos.add(user.getEmail());

        return datos;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

}
