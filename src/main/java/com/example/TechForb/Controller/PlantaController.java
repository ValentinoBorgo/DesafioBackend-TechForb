package com.example.TechForb.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechForb.Dto.PlantaResponse;
import com.example.TechForb.Model.Planta;
import com.example.TechForb.Service.IPlantaService;

@RestController
@RequestMapping("/api/planta")
public class PlantaController {

    @Autowired
    private IPlantaService iPlantaService; 

    @GetMapping("/get")
    public List<Planta> getPlantas() {

        return iPlantaService.getPlantas();
    }

    @GetMapping("/getTotalizadores")
    public HashMap<String, Integer> getTotalizadores() {
        return iPlantaService.getTotalizadores();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PlantaResponse> obtenerPlanta(@PathVariable Long id) {
        try {
            PlantaResponse planta = iPlantaService.getPlanta(id);
            return planta != null ? ResponseEntity.ok(planta) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Planta> crearPlanta(@RequestBody Planta planta) {
        try {
            Planta newPlanta = iPlantaService.guardarPlanta(planta);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPlanta);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planta> editarPlanta(@PathVariable Long id, @RequestBody Planta planta) {
        try {
            Planta newPlanta = iPlantaService.editarPlanta(id, planta);
            return newPlanta != null ? ResponseEntity.ok(newPlanta) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPlanta(@PathVariable Long id) {
        try {
            String mensaje = iPlantaService.borrarPlanta(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
