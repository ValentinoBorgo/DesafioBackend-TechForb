package com.example.TechForb.Controller;

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

import com.example.TechForb.Dto.SensorResponse;
import com.example.TechForb.Model.Sensor;
import com.example.TechForb.Service.ISensorService;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    @Autowired
    private ISensorService iSensorService;

    @GetMapping("/get")
    public List<Sensor> getSensores() {

        return iSensorService.getSensores();
    }

    @GetMapping("/sensoresDeshabilitados")
    public Integer getMaxSensoresDeshabilitados() {
        return iSensorService.getMaxSensoresDeshabilitados();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SensorResponse> obtenerSensor(@PathVariable Long id) {
        try {
            SensorResponse sensor = iSensorService.getSensor(id);
            return sensor != null ? ResponseEntity.ok(sensor) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Sensor> crearSensor(@RequestBody Sensor sensor) {
        try {
            Sensor newSensor = iSensorService.guardarSensor(sensor);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSensor);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> editarSensor(@PathVariable Long id, @RequestBody Sensor sensor) {
        try {
            Sensor newSensor = iSensorService.editarSensor(id, sensor);
            return newSensor != null ? ResponseEntity.ok(newSensor) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarSensor(@PathVariable Long id) {
        try {
            String mensaje = iSensorService.borrarSensor(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
