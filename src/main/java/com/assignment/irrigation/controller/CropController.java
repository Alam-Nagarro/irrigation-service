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

import com.assignment.irrigation.model.Crop;
import com.assignment.irrigation.service.CropService;

@RestController
@RequestMapping(IRRI_API_V1_PREFIX + "/crops")
public class CropController {

	@Autowired
	CropService cropService;
	
	@GetMapping("/{cropId}")
	public Crop getCrop(@PathVariable Long cropId) {
		return cropService.getCrop(cropId);
	}
	
	@PostMapping
	public Crop createCrop(@RequestBody Crop crop) {
		return cropService.saveCrop(crop);
	}
	
	@PutMapping
	public Crop updateCrop(@RequestBody Crop crop) {
		return cropService.updateCrop(crop);
	}
	
	@GetMapping
	public List<Crop> getAllCrops(){
		return cropService.getAllCrops();
	}
	
	@DeleteMapping("/{cropId}")
	public void deleteCrop(@PathVariable Long cropId) {
		cropService.deleteCrop(cropId);
	}
}
