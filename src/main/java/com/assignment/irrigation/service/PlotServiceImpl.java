package com.assignment.irrigation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assignment.irrigation.model.Plot;
import com.assignment.irrigation.repository.PlotRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlotServiceImpl implements PlotService {

	@Autowired
	PlotRepository plotRepository;
	
	@Value("${irrigation.water-amount-per-sqrmtr-ltr:10}")
	private Integer waterAmountPerSqrmtr;
	
	@Override
	public Plot getPlot(Long plotId) {
		return plotRepository.findByPlotId(plotId);
	}

	@Override
	public Plot savePlot(Plot plot) {
		log.debug("Received plot to save: " + plot);
		return plotRepository.save(plot);
	}

	@Override
	public Plot updatePlot(Plot plot) {
		log.debug("Received plot to update: " + plot);
		Plot persistedPlot = plotRepository.findByPlotId(plot.getPlotId());
		if(Objects.nonNull(persistedPlot)) {
			persistedPlot = updatePersistedPlot(persistedPlot, plot);
		}
		return plotRepository.save(persistedPlot);
	}

	@Override
	public List<Plot> getAllPlots() {
		return plotRepository.findAll();
	}
	
	@Override
	public void deletePlot(Long plotId) {
		Plot persistedPlot = plotRepository.findByPlotId(plotId);
		if(Objects.nonNull(persistedPlot)) {
			plotRepository.delete(persistedPlot);
		}else {
			log.info("Plot with id {} does not exist.", plotId);
		}
	}

	private Plot updatePersistedPlot(Plot persistedPlot, Plot newPlot) {
		if(Objects.nonNull(newPlot.getName())) {
			persistedPlot.setName(newPlot.getName());
		}
		if(Objects.nonNull(newPlot.getAreaSqrmtr())) {
			persistedPlot.setAreaSqrmtr(newPlot.getAreaSqrmtr());
		}
		if(Objects.nonNull(newPlot.getCultivationStartDate())) {
			persistedPlot.setCultivationStartDate(newPlot.getCultivationStartDate());
		}
		if(Objects.nonNull(newPlot.getCropId())) {
			persistedPlot.setCropId(newPlot.getCropId());
		}
		return persistedPlot;
	}

	@Override
	public Integer calculateAmountOfWaterForThePlot(Long plotId) {
		Plot plot = plotRepository.findByPlotId(plotId);
		if(Objects.nonNull(plot)) {
			return waterAmountPerSqrmtr * plot.getAreaSqrmtr();
		}
		return Integer.MIN_VALUE;
	}

}
