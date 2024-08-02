package com.example.TechForb.Dto;

import com.example.TechForb.Model.Planta;

public class PlantaResponse {

    private String mensaje;

    private Planta planta;

    public PlantaResponse(String mensaje, Planta planta) {
        this.mensaje = mensaje;
        this.planta = planta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    

}
