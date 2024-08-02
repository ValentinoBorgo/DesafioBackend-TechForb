package com.example.TechForb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechForb.Dto.UsuarioResponse;
import com.example.TechForb.Model.Usuario;
import com.example.TechForb.Service.IUsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})
@RestController
@RequestMapping(path = "/api/users")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    
    
    @GetMapping("/get")
    public List<Usuario> getUsuarios() {
        System.out.println("USUARIOS ENCONTRADOS-------------------------------");
        return usuarioService.getListaUsuarios();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable Long id) {
        try {
            UsuarioResponse usuario = usuarioService.getUsuario(id);
            return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping( value = "/registrar/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario user =  usuarioService.guardarUsuario(usuario);
            return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioActualizado = usuarioService.editarUsuario(id, usuario);
            return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id) {
        try {
            String mensaje = usuarioService.borrarUsuario(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // @RequestMapping(value = "/login", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    // @ResponseStatus(HttpStatus.OK)
    //     public ResponseEntity<?> handleOptions() {
    //         try{
    //             HttpHeaders headers = new HttpHeaders();
    //             headers.add("Access-Control-Allow-Origin", "https://black-media-angular.vercel.app");
    //             headers.add("Access-Control-Allow-Methods", "POST, OPTIONS");
    //             headers.add("Access-Control-Allow-Headers", "*");
    //             headers.add("Access-Control-Allow-Credentials", "true");
    //             System.out.println("HEADERS  :  "+headers);
    //             logger.info("HEADERS: {}", headers);
    //             return new ResponseEntity<>(headers, HttpStatus.OK);
    //         }catch(Exception e){
    //             e.printStackTrace();
                
    //         }
    //     return null;
    //     }

    // @GetMapping("/token/refresh")
    // public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

    //     if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
    //         try {
    //             String refresh_token = authorizationHeader.substring("Bearer ".length());
    //             Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
    //             JWTVerifier verifier = JWT.require(algorithm).build();
    //             DecodedJWT decodedJWT = verifier.verify(refresh_token);
    //             String username = decodedJWT.getSubject();
    //             Usuario usuario = usuarioService.buscarPorNombre(username);
    //             String access_token = JWT.create()
    //                     .withSubject(usuario.getEmail())
    //                     .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
    //                     .withIssuer(request.getRequestURL().toString())
    //                     .sign(algorithm);
    //             Map<String, String> tokens = new HashMap<>();
    //             tokens.put("access_token", access_token);
    //             tokens.put("refresh_token", refresh_token);
    //             response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    //             new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    //         } catch (Exception exception) {
    //             response.setHeader("error", exception.getMessage());
    //             response.setStatus(HttpStatus.FORBIDDEN.value());
    //             // response.sendError(HttpStatus.FORBIDDEN.value());
    //             Map<String, String> error = new HashMap<>();
    //             error.put("error_message", exception.getMessage());
    //             response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    //             new ObjectMapper().writeValue(response.getOutputStream(), error);
    //         }
    //     } else {
    //         throw new RuntimeException("Refresh token is missing");
    //     }
    // }

    // @GetMapping("/getByName/{name}")
    // public Usuario getIdByName(@PathVariable  String name){

    //     try {
    //         return usuarioService.buscarPorNombre(name);
    //         } 
    //     catch (Exception e) {    
    //         return null;
    //     }


    // }
}

