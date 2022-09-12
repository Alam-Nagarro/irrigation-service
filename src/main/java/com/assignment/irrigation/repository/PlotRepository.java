package com.assignment.irrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.irrigation.model.Crop;
import com.assignment.irrigation.model.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

	public Plot findByPlotId(Long plotId);
}
