package com.example.TechForb.Dto;

import com.example.TechForb.Model.Sensor;

public class SensorResponse {

    private String mensaje;

    private Sensor sensor;

    public SensorResponse(String mensaje, Sensor sensor) {
        this.mensaje = mensaje;
        this.sensor = sensor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    

}
