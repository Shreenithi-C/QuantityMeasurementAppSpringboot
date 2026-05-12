package com.example.quantity_measurement.repository;

import com.example.quantity_measurement.model.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, Long> {
    Optional<UnitEntity> findByName(String name);
}
