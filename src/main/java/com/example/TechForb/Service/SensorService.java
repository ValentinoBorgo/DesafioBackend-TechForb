package com.example.TechForb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TechForb.Dto.PlantaResponse;
import com.example.TechForb.Dto.SensorResponse;
import com.example.TechForb.Model.Planta;
import com.example.TechForb.Model.Sensor;
import com.example.TechForb.Repository.ISensorRepository;

@Service
public class SensorService implements ISensorService{

    @Autowired
    private ISensorRepository iSensorRepository;

    @Override
    public List<Sensor> getSensores() {
        return iSensorRepository.findAll();
    }

    @Override
    public Sensor guardarSensor(Sensor sensor) {

        return iSensorRepository.save(sensor);

    }

    @Override
    public String borrarSensor(Long id) {
        
        if(iSensorRepository.existsById(id)){
            iSensorRepository.deleteById(id);
            return "Sensor eliminado correctamente";
        } else {
            return "Sensor no encontrado";
        }


    }

    @Override
    public SensorResponse getSensor(Long id) {

        Optional<Sensor> sensor = iSensorRepository.findById(id);

        if(sensor.isPresent()){
            return new SensorResponse("Sensor Encontrado", sensor.get());
        } else {
            return new SensorResponse("Sensor No Encontrado", null);
        }

    }

    @Override
    public Sensor editarSensor(Long id, Sensor sensor) {

        Sensor editSensor = iSensorRepository.findById(id).orElse(null);

        if(editSensor != null){
            editSensor.setEstado(sensor.getEstado());
            editSensor.setNombre(sensor.getNombre());
            editSensor.setPlanta_id(sensor.getPlanta_id());
            return iSensorRepository.save(editSensor);
        } else {
            return null;
        }

    }


    
}
