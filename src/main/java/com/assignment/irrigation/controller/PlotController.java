package com.assignment.irrigation.controller;

import static com.assignment.irrigation.constants.IrrigationConstants.IRRI_API_V1_PREFIX;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.irrigation.model.Plot;
import com.assignment.irrigation.service.PlotService;

@RestController
@RequestMapping(IRRI_API_V1_PREFIX + "/plots")
public class PlotController {
	
	@Autowired
	PlotService plotService;
	
	@GetMapping("/{plotId}")
	public Plot getPlot(@PathVariable Long plotId) {
		return plotService.getPlot(plotId);
	}
	
	@PostMapping
	public Plot createPlot(@RequestBody Plot plot) {
		return plotService.savePlot(plot);
	}
	
	@PutMapping
	public Plot updatePlot(@RequestBody Plot plot) {
		return plotService.updatePlot(plot);
	}
	
	@GetMapping
	public List<Plot> getAllPlots(){
		return plotService.getAllPlots();
	}
	@DeleteMapping("/{plotId}")
	public void deletePlot(@PathVariable Long plotId) {
		plotService.deletePlot(plotId);
	}
	
	
	@GetMapping("/water-amount-ltr/{plotId}")
	public Integer CalculateAmountOfWaterForThePlot(@PathVariable Long plotId) {
		return plotService.calculateAmountOfWaterForThePlot(plotId);
	}
}
