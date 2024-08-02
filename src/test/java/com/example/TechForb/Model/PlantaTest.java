package com.example.TechForb.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.example.TechForb.Utils.Estado;

public class PlantaTest {
    @Test
    void testGet() {
        Planta planta = new Planta(1L,"San Pepito Planta","https://flagcdn.com/w320/ar.png", 200, 30, 2, "Argentina");

        assertEquals(1L, planta.getId());
        assertEquals("San Pepito Planta", planta.getNombre());
        assertEquals("https://flagcdn.com/w320/ar.png", planta.getBandera());
        assertEquals(200, planta.getCant_lecturas());
        assertEquals("Argentina", planta.getPais());
        assertEquals(30, planta.getAlertas_medias());
        assertEquals(2, planta.getAlertas_rojas());
    }

    @Test
    void testSet() {
        Planta planta = new Planta();

        planta.setId(1L);
        planta.setAlertas_medias(30);
        planta.setAlertas_rojas(2);
        planta.setCant_lecturas(200);
        planta.setPais("Argentina");
        planta.setBandera("https://flagcdn.com/w320/ar.png");
        planta.setNombre("San Pepito Planta");

        assertEquals(1L, planta.getId(), "El id 1");
        assertEquals(30, planta.getAlertas_medias(), "Alertas medias 30");
        assertEquals(2, planta.getAlertas_rojas(), "Alertas Rojas 2");
        assertEquals(200, planta.getCant_lecturas(), "Cantidad de lecturas 200");
        assertEquals("Argentina", planta.getPais(), "Argentina");
        assertEquals("https://flagcdn.com/w320/ar.png", planta.getBandera(), "Bandera Argentina");
        assertEquals("San Pepito Planta", planta.getNombre(), "El nombre es San Pepito Planta");
    }

    @Test
    void testToString() {

        Planta planta = new Planta(1L,"San Pepito Planta","https://flagcdn.com/w320/ar.png", 200, 30, 2, "Argentina");

        String esperado = "Planta(id=1, nombre=San Pepito Planta, bandera=https://flagcdn.com/w320/ar.png, cant_lecturas=200, alertas_medias=30, alertas_rojas=2, pais=Argentina)";
        String real = planta.toString();

        assertEquals(esperado, real, "Son iguales");

    }

    @Test
    void testEquals() {

        Planta planta1 = new Planta(1L,"San Pepito Planta","https://flagcdn.com/w320/ar.png", 200, 30, 2, "Argentina");
        Planta planta2 = new Planta(1L,"San Pepito Planta","https://flagcdn.com/w320/ar.png", 200, 30, 2, "Argentina");
        Planta planta3 = new Planta(2L,"Juan Manuel Planta","https://flagcdn.com/w320/it.png", 400, 130, 45, "Italia");

        assertEquals(planta1, planta2, "Plantas 1 y 2 iguales !");

        assertNotEquals(planta1, planta3, "Plantas 1 y 3 diferentes !");

    }
}
