package com.example.TechForb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.TechForb.Dto.UsuarioResponse;
import com.example.TechForb.Model.Usuario;
import com.example.TechForb.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUsuarioRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> getListaUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario user) {

        return userRepo.save(user);

    }

    @Override
    public String borrarUsuario(Long id) {

        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "Usuario eliminado correctamente";
        } else {
            return "Usuario no encontrado";
        }
    }

    @Override
    public UsuarioResponse getUsuario(Long id) {

        Optional<Usuario> user = userRepo.findById(id);

        if(user.isPresent()){
            return new UsuarioResponse("Usuario Encontrado", user.get());
        } else {
            return new UsuarioResponse("Usuario No Encontrado", null);
        }

    }

    @Override
    public Usuario editarUsuario(Long id, Usuario user) {

        Usuario editUser = userRepo.findById(id).orElse(null);

        if(editUser != null){
            editUser.setContrasenia(passwordEncoder.encode(user.getContrasenia()));
            editUser.setEmail(user.getEmail());
            editUser.setApellido(user.getApellido());
            editUser.setNombre(user.getNombre());
            return userRepo.save(editUser);
        } else {
            return null;
        }

    }

     @Override
     public Usuario buscarPorNombre(String nombre) {

         Optional<Usuario> user = userRepo.findByEmail(nombre);

         Usuario userDenegado = new Usuario();
         userDenegado.setNombre("No Encontrados");

         Usuario usuarioEfectivo = user.orElse(userDenegado);

         return usuarioEfectivo;

     }

}
