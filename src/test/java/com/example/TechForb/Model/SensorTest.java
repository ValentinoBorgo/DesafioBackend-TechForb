package com.example.TechForb.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.example.TechForb.Utils.Estado;

public class SensorTest {
    @Test
    void testGet() {
        Sensor sensor = new Sensor(1L,"San Javier KM10", Estado.activo, 1L );

        assertEquals(1L, sensor.getId());
        assertEquals("San Javier KM10", sensor.getNombre());
        assertEquals(Estado.activo, sensor.getEstado());
        assertEquals(1L, sensor.getPlanta_id());
    }

    @Test
    void testSet() {
        Sensor sensor = new Sensor();

        sensor.setId(1L);
        sensor.setEstado(Estado.deshabilitado);
        sensor.setNombre("San Javier KM10");
        sensor.setPlanta_id(2L);

        assertEquals(1L, sensor.getId(), "El id 1");
        assertEquals(Estado.deshabilitado, sensor.getEstado(), "El estado es Deshabilitado");
        assertEquals("San Javier KM10", sensor.getNombre(), "El nombre es San Javier KM10");
        assertEquals(2L, sensor.getPlanta_id(), "La planta de este sensor es la numero 2");
    }

    @Test
    void testToString() {

        Sensor sensor = new Sensor(1L,"San Javier KM10", Estado.activo, 1L );

        String esperado = "Sensor(id=1, nombre=San Javier KM10, estado=activo, planta_id=1)";
        String real = sensor.toString();

        assertEquals(esperado, real, "Son iguales");

    }

    @Test
    void testEquals() {

        Sensor sensor1 = new Sensor(1L,"San Javier KM10", Estado.activo, 1L );
        Sensor sensor2 = new Sensor(1L,"San Javier KM10", Estado.activo, 1L );
        Sensor sensor3 = new Sensor(3L,"Vera KM200", Estado.deshabilitado, 2L );

        assertEquals(sensor1, sensor2, "Sensor 1 y 2 iguales !");

        assertNotEquals(sensor1, sensor3, "Sensor 1 y 3 diferentes !");

    }
}
