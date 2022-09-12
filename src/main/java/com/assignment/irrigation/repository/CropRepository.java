package com.assignment.irrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.irrigation.model.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
	
	public Crop findByCropId(Long cropId);
	
}
