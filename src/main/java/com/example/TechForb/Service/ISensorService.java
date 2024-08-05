package com.example.TechForb.Service;

import java.util.List;

import com.example.TechForb.Dto.SensorResponse;
import com.example.TechForb.Model.Sensor;

public interface ISensorService {

    public List<Sensor> getSensores();

    public Sensor guardarSensor(Sensor sensor);

    public String borrarSensor(Long id);

    public SensorResponse getSensor(Long id);

    public Sensor editarSensor(Long id, Sensor sensor);

    public Integer getMaxSensoresDeshabilitados();
}
