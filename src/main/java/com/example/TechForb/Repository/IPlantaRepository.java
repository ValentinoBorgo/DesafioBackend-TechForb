package com.example.TechForb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TechForb.Model.Planta;

@Repository
public interface IPlantaRepository extends JpaRepository<Planta, Long>{

}
