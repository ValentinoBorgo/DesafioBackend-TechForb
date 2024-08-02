package com.example.TechForb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "planta")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "bandera")
    private String bandera;

    @Column(name = "cant_lecturas")
    private Integer cant_lecturas;

    @Column(name = "alertas_medias")
    private Integer alertas_medias;

    @Column(name = "alertas_rojas")
    private Integer alertas_rojas;

    @Column(name = "pais")
    private String pais;

    public Planta(Long id, String nombre, String bandera, Integer cant_lecturas, Integer alertas_medias,
            Integer alertas_rojas, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.bandera = bandera;
        this.cant_lecturas = cant_lecturas;
        this.alertas_medias = alertas_medias;
        this.alertas_rojas = alertas_rojas;
        this.pais = pais;
    }

    
}
