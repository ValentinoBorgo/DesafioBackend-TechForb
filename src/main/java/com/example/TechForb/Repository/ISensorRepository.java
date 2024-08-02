package com.example.TechForb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TechForb.Model.Sensor;

@Repository
public interface ISensorRepository extends JpaRepository<Sensor, Long>{

}
