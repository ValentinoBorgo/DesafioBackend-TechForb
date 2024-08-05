package com.example.TechForb.Service;

import java.util.HashMap;
import java.util.List;

import com.example.TechForb.Dto.PlantaResponse;
import com.example.TechForb.Model.Planta;

public interface IPlantaService {

    public List<Planta> getPlantas();

    public Planta guardarPlanta(Planta planta);

    public String borrarPlanta(Long id);

    public PlantaResponse getPlanta(Long id);

    public Planta editarPlanta(Long id, Planta planta);

    public HashMap<String, Integer> getTotalizadores();
}
