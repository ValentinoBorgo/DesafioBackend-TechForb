package com.example.TechForb.Utils;

public enum Estado {
    activo("activo"),
    deshabilitado("deshabilitado");

    private final String estadoString;

    Estado(String estadoString){
        this.estadoString = estadoString;
    }

    public String getEstado(){
        return this.estadoString;
    }

    @Override
    public String toString(){
        return estadoString;
    }

}
