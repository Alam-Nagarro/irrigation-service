package com.assignment.irrigation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.irrigation.model.Crop;
import com.assignment.irrigation.repository.CropRepository;

@Service
public class CropServiceImpl implements CropService {
	 
	@Autowired
	CropRepository cropRepository;
	
	@Override
	public Crop getCrop(Long cropId) {
		return cropRepository.findByCropId(cropId);
	}

	@Override
	public Crop saveCrop(Crop crop) {
		return cropRepository.save(crop);
	}

	@Override
	public Crop updateCrop(Crop crop) {
		Crop persistedCrop = cropRepository.findByCropId(crop.getCropId());
		if(Objects.nonNull(persistedCrop)) {
			persistedCrop = updatePersistedCrop(persistedCrop, crop);
		}
		return cropRepository.save(persistedCrop);
	}

	@Override
	public List<Crop> getAllCrops() {
		return cropRepository.findAll();
	}
	
	@Override
	public void deleteCrop(Long cropId) {
		Crop persistedCrop = cropRepository.findByCropId(cropId);	
		if(Objects.nonNull(persistedCrop)) {
			cropRepository.delete(persistedCrop);
		}
	}
	
	private Crop updatePersistedCrop(Crop persistedCrop, Crop newCrop) {
		if(Objects.nonNull(newCrop.getCultivationPeriodDays())) {
			persistedCrop.setCultivationPeriodDays(newCrop.getCultivationPeriodDays());
		}
		if(Objects.nonNull(newCrop.getIrrigationGapDays())) {
			persistedCrop.setIrrigationGapDays(newCrop.getIrrigationGapDays());
		}
		if( Objects.nonNull(newCrop.getName())) {
			persistedCrop.setName(newCrop.getName());
		}
		return persistedCrop;
	}



}
