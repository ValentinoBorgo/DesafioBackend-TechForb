package com.example.TechForb.Service;

import com.example.TechForb.Dto.UsuarioResponse;
import com.example.TechForb.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
public List<Usuario> getListaUsuarios();

public Usuario guardarUsuario(Usuario user);

public String borrarUsuario(Long id);

public UsuarioResponse getUsuario(Long id);

public Usuario editarUsuario(Long id, Usuario user);

public Usuario buscarPorNombre(String nombre);

}
