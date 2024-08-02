package com.example.TechForb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TechForb.Dto.PlantaResponse;
import com.example.TechForb.Model.Planta;
import com.example.TechForb.Repository.IPlantaRepository;

@Service
public class PlantaService implements IPlantaService{

    @Autowired
    private IPlantaRepository iPlantaRepository;

    @Override
    public List<Planta> getPlantas() {
        return iPlantaRepository.findAll();
    }

    @Override
    public Planta guardarPlanta(Planta planta) {

        return iPlantaRepository.save(planta);

    }

    @Override
    public String borrarPlanta(Long id) {

        if(iPlantaRepository.existsById(id)){
            iPlantaRepository.deleteById(id);
            return "Planta eliminada correctamente";
        } else {
            return "Planta no encontrada";
        }

    }

    @Override
    public PlantaResponse getPlanta(Long id) {

        Optional<Planta> planta = iPlantaRepository.findById(id);

        if(planta.isPresent()){
            return new PlantaResponse("Planta Encontrada", planta.get());
        } else {
            return new PlantaResponse("Planta No Encontrada", null);
        }

    }

    @Override
    public Planta editarPlanta(Long id, Planta planta) {

        Planta plantaEdit = iPlantaRepository.findById(id).orElse(null);

        if(plantaEdit != null){
            plantaEdit.setAlertas_medias(planta.getAlertas_medias());
            plantaEdit.setAlertas_rojas(planta.getAlertas_rojas());
            plantaEdit.setBandera(planta.getBandera());
            plantaEdit.setCant_lecturas(planta.getCant_lecturas());
            plantaEdit.setNombre(planta.getNombre());
            plantaEdit.setPais(planta.getPais());
            return iPlantaRepository.save(plantaEdit);
        } else {
            return null;
        }

    }

    

}
