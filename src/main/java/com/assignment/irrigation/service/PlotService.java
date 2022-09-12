package com.assignment.irrigation.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.assignment.irrigation.model.Plot;

public interface PlotService {

	/**
	 * Get plot.
	 * @param plotId
	 * @return
	 */
	public Plot getPlot(Long plotId);
	
	/**
	 * Save plot.
	 * @param plot
	 * @return
	 */
	public Plot savePlot(Plot plot);
	
	/**
	 * Update plot.
	 * @param plot
	 * @return
	 */
	public Plot updatePlot(Plot plot);
	
	/**
	 * Get all plots.
	 * @return
	 */
	public List<Plot> getAllPlots();
	/**
	 * Delete plot.
	 * @param plotId
	 */
	public void deletePlot(Long plotId);

	/**
	 * Calculate amount of water for the plot.
	 * @param plotId
	 * @return
	 */
	public Integer calculateAmountOfWaterForThePlot(Long plotId);
}
