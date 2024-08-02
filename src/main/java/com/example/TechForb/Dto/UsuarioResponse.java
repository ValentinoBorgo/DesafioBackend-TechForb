package com.example.TechForb.Dto;

import com.example.TechForb.Model.Usuario;

public class UsuarioResponse {

    private String mensaje;

    private Usuario usuario;

    public UsuarioResponse(String mensaje, Usuario usuario) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
