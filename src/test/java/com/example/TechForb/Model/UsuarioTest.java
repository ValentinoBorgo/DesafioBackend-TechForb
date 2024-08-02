package com.example.TechForb.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @Test
    void testGet() {
        Usuario user = new Usuario(1L, "Carlos","Borgo","carlos@hotmail.com", "carloslll");

        assertEquals(1L, user.getId());
        assertEquals("Carlos", user.getNombre());
        assertEquals("Borgo", user.getApellido());
        assertEquals("carlos@hotmail.com", user.getEmail());
        assertEquals("carloslll", user.getContrasenia());
    }

    @Test
    void testSet() {
        Usuario user = new Usuario();

        user.setId(1L);
        user.setApellido("Borgo");
        user.setContrasenia("carloslll");
        user.setEmail("carlos@hotmail.com");
        user.setNombre("Carlos");

        assertEquals(1L, user.getId(), "El id 1");
        assertEquals("Carlos", user.getNombre(), "El nombre es Carlos");
        assertEquals("Borgo", user.getApellido(), "El apellido es Borgo");
        assertEquals("carlos@hotmail.com", user.getEmail(), "El email es carlos@hotmail.com");
        assertEquals("carloslll", user.getContrasenia(), "La contraseña es carloslll");
    }

    @Test
    void testToString() {

        Usuario user = new Usuario(1L, "Carlos","Borgo","carlos@hotmail.com", "carloslll");

        String esperado = "Usuario(id=1, nombre=Carlos, apellido=Borgo, email=carlos@hotmail.com, contrasenia=carloslll)";
        String real = user.toString();

        assertEquals(esperado, real, "Son iguales");

    }

    @Test
    void testHash() {

        Usuario user1 = new Usuario(1L, "Carlos","Borgo","carlos@hotmail.com", "carloslll");
        Usuario user2 = new Usuario(1L, "Carlos","Borgo","carlos@hotmail.com", "carloslll");
        Usuario user3 = new Usuario(3L, "Valentino","Germano","germano@gmail.com", "germanoppp");
        

        assertEquals(user1, user2, "User 1 y 2 iguales !");

        assertNotEquals(user1, user3, "User 1 y 3 diferentes !");

        assertEquals(user1.hashCode(), user2.hashCode(), "User 1 y 2 mismo hash !");

        assertNotEquals(user1.hashCode(), user3.hashCode(), "User 1 y 3 distinto hash");

    }
}
