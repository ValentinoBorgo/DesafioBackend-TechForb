package com.example.TechForb.Utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EstadoTest {
    @Test
    void testGetEstado() {

        Assertions.assertThat(Estado.activo.getEstado()).isEqualTo("activo");

        Assertions.assertThat(Estado.deshabilitado.getEstado()).isEqualTo("deshabilitado");
    }

    @Test
    void testToString() {

        Assertions.assertThat(Estado.activo.toString()).isEqualTo("activo");

        Assertions.assertThat(Estado.deshabilitado.toString()).isEqualTo("deshabilitado");

    }

    @Test
    void testValueOf() {

        Assertions.assertThat(Estado.valueOf("activo")).isEqualTo(Estado.activo);

        Assertions.assertThat(Estado.valueOf("deshabilitado")).isEqualTo(Estado.deshabilitado);

    }

    @Test
    void testValues() {

        Assertions.assertThat(Estado.values()).containsExactly(Estado.activo, Estado.deshabilitado);

    }
}
